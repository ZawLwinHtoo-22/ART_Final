package com.art.artproject.service.impl;

import com.art.artproject.dto.FavouriteRequest;
import com.art.artproject.entity.Card;
import com.art.artproject.entity.Favourite;
import com.art.artproject.entity.User;
import com.art.artproject.repo.CardRepo;
import com.art.artproject.repo.FavouriteRepo;
import com.art.artproject.repo.UserRepo;
import com.art.artproject.service.FavouriteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private FavouriteRepo favouriteRepo;

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    public ModelMapper mapper;
    @Autowired
    public UserRepo userRepo;

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

    @Override
    public Favourite giveFavourite(String user_ids, Long card_id, FavouriteRequest favouriteRequest) {
        Favourite favourite = mapper.map(favouriteRequest, Favourite.class);
        Optional<Card> card = cardRepo.findById(card_id);
        List<Long> userIds = Arrays.stream(user_ids.split(","))
                .map(Long::valueOf)
                .collect(Collectors.toList());
        List<User> users=userRepo.findAllById(userIds);
        favourite.setUsers(users);
        favourite.setCard(card.get());
        favourite.setFavourite(card.isPresent());

        return favouriteRepo.save(favourite);
    }

    @Override
    public List<Favourite> showAll() {
        return favouriteRepo.findAll();
    }

    @Override
    public Favourite updateNewFavourite(Long id, FavouriteRequest request) {
        Optional<Favourite> fav=favouriteRepo.findById(id);
        if(fav.isPresent()){
            Favourite favourite=fav.get();
            favourite.setFavourite(request.getFavourite());

            return favouriteRepo.save(favourite);
        }
        return null;
    }

    @Override
    public void deleteFavourite(Long id) {
        if(favouriteRepo.existsById(id)){
            favouriteRepo.deleteById(id);
        }
    }

}
