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
import com.art.artproject.utils.FileUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

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


    @Override
<<<<<<< HEAD
    public Card createCard(Long user_id, NewCardRequest request) {
=======
    public Card createCard(MultipartFile file,Long user_id, NewCardRequest request) {
>>>>>>> 6ee21ce59f7530cf681c45adf1863a59902f8866
        Card card=mapper.map(request,Card.class);
        Optional<User> user=userRepo.findById(user_id);
        Optional<UserNameResponse> userNameResponseOptional = userRepo.findUserNameById(user_id);
        if (userNameResponseOptional.isPresent()) {
            UserNameResponse userNameResponse = userNameResponseOptional.get();
            card.setUserName(userNameResponse.getUserName());
        } else {
            // Handle the case when username response is not found
            throw new NoSuchElementException("Username response not found for user ID: " + user_id);
        }

        Category category=categoryRepo.findById(request.getCategory_id()).get();
        card.setUser(user.get());
        card.setCategory(category);
        FileUtils.save(file);

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
