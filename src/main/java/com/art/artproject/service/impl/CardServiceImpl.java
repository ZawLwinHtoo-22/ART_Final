package com.art.artproject.service.impl;

import com.art.artproject.dto.NewCardRequest;
import com.art.artproject.dto.UserNameResponse;
import com.art.artproject.entity.*;

import com.art.artproject.repo.CardRepo;
import com.art.artproject.repo.CategoryRepo;
import com.art.artproject.repo.UserRepo;
import com.art.artproject.service.CardService;
import com.art.artproject.service.StorageService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
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
    @Autowired
    private StorageService service;

    @Override
    public Card createCard(Long user_id, MultipartFile imageFile, NewCardRequest request) throws IOException {
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
        card.setImageFile(service.uploadImage(imageFile));
        card.setPrice(request.getPrice());
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
    @Override
    public Card showWithId(Long card_id) {
        return cardRepo.findById(card_id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid ID  " + card_id));
    }

}
