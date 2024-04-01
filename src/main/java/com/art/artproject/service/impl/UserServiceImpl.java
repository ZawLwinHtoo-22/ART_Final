package com.art.artproject.service.impl;

import com.art.artproject.cache.OTP;
import com.art.artproject.cache.OTPCache;
import com.art.artproject.constant.EmailConstant;
import com.art.artproject.domain.OTPValidateRequest;
import com.art.artproject.dto.*;
import com.art.artproject.entity.User;
import com.art.artproject.entity.UserInfo;
import com.art.artproject.repo.UserRepo;
import com.art.artproject.service.UserService;
import com.art.artproject.utils.EmailUtil;
import jakarta.mail.Authenticator;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Properties;
import java.util.Random;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepo;

    @Autowired
    private ModelMapper mapper;

    private final EmailUtil emailUtil;



    public UserServiceImpl(EmailUtil emailUtil) {
        this.emailUtil = emailUtil;
    }

    @Override
    public UserResponse registerUser(MultipartFile file, NewUserRequest request) {
        User user=User.of(request);
//        user.setProfileImage(utils.save(file));
        return mapper.map(userRepo.save(user),UserResponse.class);
    }

    @Override
    public UserInfo validateUser(UserValidateRequest request) {
        final User user = userRepo
                .findUsersByMailAndPassword(request.getMail(),request.getPassword())
                .orElseThrow( () -> new RuntimeException("No User"));

        return UserInfo.of(user);

    }


    public List<User> showAll() {
        return userRepo.findAll();
    }

    @Override
    public void verifyMailToRegister(String mail) {
        final Optional<User> user = userRepo.findUsersByMail(mail);
        if(user.isPresent()){
            // code generate
            // send the generated code to mail

            int max = 999999;
            int min = 100000;

            Random rand = new Random();
            int r = rand.nextInt(max - min + 1) + min;

            System.out.println("Generating secret key");
            System.out.println(r);

            send(mail, "Your one time password is "+ r);

            OTP otp = new OTP(mail, Integer.toString(r), LocalDateTime.now().plusMinutes(1));
            OTPCache.saveOTP(otp);


        }else{


            throw new RuntimeException("UserName not Found`q");

        }
    }

    @Override
    public boolean validateOTP(OTPValidateRequest request) {
        boolean isValidate = false;
        final OTP otp = OTPCache.getOTP(request.getMail());

        if(otp != null){
            if (otp.getOtp().equals(request.getOtp())) {

                if (LocalDateTime.now().isBefore(otp.getExpiredTime())) {

                    isValidate = true;
                }
            }
        }
        return isValidate;
    }

    private void send(String toEmail, String subject){
        final String fromEmail = EmailConstant.senderMail;
        final String password = EmailConstant.senderPassword;

        Properties properties = new Properties();
        properties.put("mail.smtp.host", EmailConstant.SMTP_HOST);
        properties.put("mail.smtp.socketFactory.port", "465");
        properties.put("mail.smtp.socketFactory.class",
                "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.debug", "true");

        jakarta.mail.Authenticator auth = new Authenticator() {
            //override the getPasswordAuthentication method
            protected jakarta.mail.PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(fromEmail, password);
            }

        };

        Session session = Session.getInstance(properties, auth);
        emailUtil.sendEmail(session, toEmail, subject);
    }

}
