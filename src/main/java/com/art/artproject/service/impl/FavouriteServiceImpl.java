package com.art.artproject.service.impl;

import com.art.artproject.dto.FavouriteRequest;
import com.art.artproject.entity.Card;
import com.art.artproject.entity.Favourite;
import com.art.artproject.repo.CardRepo;
import com.art.artproject.repo.FavouriteRepo;
import com.art.artproject.service.FavouriteService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FavouriteServiceImpl implements FavouriteService {

    @Autowired
    private FavouriteRepo favouriteRepo;

    @Autowired
    private CardRepo cardRepo;

    @Autowired
    public ModelMapper mapper;

    @Override
    public Favourite giveFavourite(Long card_id, FavouriteRequest favouriteRequest) {

        Favourite favourite = mapper.map(favouriteRequest, Favourite.class);
        Optional<Card> card = cardRepo.findById(card_id);


        favourite.setCard(card.get());
        favourite.setFavourite(card.isPresent());
        return favouriteRepo.save(favourite);
    }
}
