package com.art.artproject.service.impl;

import com.art.artproject.dto.*;
import com.art.artproject.entity.Card;
import com.art.artproject.entity.Category;
import com.art.artproject.entity.Favourite;
import com.art.artproject.entity.User;
import com.art.artproject.repo.CardRepo;
import com.art.artproject.repo.FavouriteRepo;
import com.art.artproject.repo.UserRepo;
import com.art.artproject.service.FavouriteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Arrays;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private FavouriteRepo favouriteRepo;

    @Autowired
    private FavouriteService favouriteService;

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    public ModelMapper mapper;


//    @Override
//    public Favourite giveFavourite(Long card_id, FavouriteRequest favouriteRequest) {
//
//        Favourite favourite = mapper.map(favouriteRequest, Favourite.class);
//        Optional<Card> card = cardRepo.findById(card_id);
//
//
//        favourite.setCard(card.get());
//        favourite.setFavourite(card.isPresent());
//        return favouriteRepo.save(favourite);
//    }

//    @Override
//    public Card createCard(Long user_id, NewCardRequest request) {
//        Card card=mapper.map(request,Card.class);
//        Optional<User> user=userRepo.findById(user_id);
//        Optional<UserNameResponse> userNameResponseOptional = userRepo.findUserNameById(user_id);
//        if (userNameResponseOptional.isPresent()) {
//            UserNameResponse userNameResponse = userNameResponseOptional.get();
//            card.setUserName(userNameResponse.getUserName());
//        } else {
//            // Handle the case when username response is not found
//            throw new NoSuchElementException("Username response not found for user ID: " + user_id);
//        }
//
//        Category category=categoryRepo.findById(request.getCategory_id()).get();
//        card.setUser(user.get());
//        card.setCategory(category);
//        return cardRepo.save(card);
//    }

    @Override
    public Favourite doFavourite(Long user_id, Long card_id) {
        Favourite favourite=new Favourite();
        User user=userRepo.findById(user_id).get();
        Card card=cardRepo.findById(card_id).get();
        favourite.setUser(user);
        favourite.setCard(card);
        return favouriteRepo.save(favourite);
    }

    @Override
    public List<Favourite> showAll() {
        return favouriteRepo.findAll();
    }



    @Override
    public void deleteFavourite(Long id) {
        if(favouriteRepo.existsById(id)){
            favouriteRepo.deleteById(id);
        }
    }

}
