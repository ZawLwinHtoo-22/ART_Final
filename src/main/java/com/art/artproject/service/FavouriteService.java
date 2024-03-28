package com.art.artproject.service;

import com.art.artproject.dto.FavouriteRequest;
import com.art.artproject.entity.Favourite;

import java.util.List;

public interface FavouriteService {

    Favourite giveFavourite(String user_ids, Long card_id, FavouriteRequest favouriteRequest);
    List<Favourite> showAll();
    Favourite updateNewFavourite(Long id,FavouriteRequest request);
    void deleteFavourite(Long id);
}
