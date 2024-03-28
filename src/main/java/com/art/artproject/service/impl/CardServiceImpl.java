package com.art.artproject.service.impl;

import com.art.artproject.dto.NewCardRequest;
import com.art.artproject.dto.UserNameResponse;
import com.art.artproject.entity.Card;
import com.art.artproject.entity.Category;

import com.art.artproject.entity.FileUtils;
import com.art.artproject.entity.User;
import com.art.artproject.repo.CardRepo;
import com.art.artproject.repo.CategoryRepo;
import com.art.artproject.repo.UserRepo;
import com.art.artproject.service.CardService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.*;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepo cardRepo;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private CardService cardService;

    public final ObjectMapper objectMapper;

    public CardServiceImpl(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }


    public FileUtils utils;


    @Override
    public Card createCard(Long user_id, MultipartFile imageFile, NewCardRequest request) {
        Card card=mapper.map(request,Card.class);
        Optional<User> user=userRepo.findById(user_id);
        Optional<UserNameResponse> userNameResponseOptional = userRepo.findUserNameById(user_id);
        if (userNameResponseOptional.isPresent()) {
            UserNameResponse userNameResponse = userNameResponseOptional.get();
            card.setUserName(userNameResponse.getUserName());
        } else {
            throw new NoSuchElementException("Username response not found for user ID: " + user_id);
        }
        Category category=categoryRepo.findById(request.getCategory_id()).get();
        card.setUser(user.get());
        card.setCategory(category);
        card.setImageFile(utils.save(imageFile));
        card.setPrice(request.getPrice());

        // Handle imageFile
//        if (imageFile != null && !imageFile.isEmpty()) {
//            // Handle file upload and set imageFile attribute
//            // Example: Save file to a location and set the file path in card.setImageFile(filePath);
//            card.setImageFile(request.getImageFile());
//
//
//        } else {
//            // Handle case when imageFile is null or empty
//            // Example: Set a default image or throw an exception if imageFile is required
//            throw new NoSuchElementException("No image found ");
//        }


//        byte[] imageData;
//        try {
//            imageData = imageFile.getBytes();
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new RuntimeException("Failed to read image file bytes.", e);
//        }
//
//        String imageDataJson;
//        try {
//            imageDataJson = objectMapper.writeValueAsString(imageData);
//        } catch (JsonProcessingException e) {
//            e.printStackTrace();
//
//            throw new RuntimeException("Failed to convert image data to JSON.", e);
//        }
//        card.setImageFile(imageDataJson);

//        byte[] imageData = new byte[0];
//        try {
//            imageData = imageFile.getBytes();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        Byte[] imageFileBytes = new Byte[imageData.length];
//        for (int i = 0; i < imageData.length; i++) {
//            imageFileBytes[i] = imageData[i];
//        }
//
//        card.setimageFile(imageFileBytes);
//

//        try {
//            String jsonString = objectMapper.writeValueAsString(imageData);
//        } catch (Exception e) {
//            e.printStackTrace();

//        }


        return cardRepo.save(card);
    }

    @Override
    public List<Card> showAll() {
        return cardRepo.findAll();
    }

    @Override
    public List<Card> showWithType(Long category_id) {
        List<Card> cards=cardService.showAll();
        List<Card> filterCards=new ArrayList<>();
        for(Card card:cards){
            if (card.getCategory().getId()==category_id){
                filterCards.add(card);
            }
        }
        return filterCards;
    }

}
