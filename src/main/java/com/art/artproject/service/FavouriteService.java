package com.art.artproject.service;

import com.art.artproject.dto.FavouriteRequest;
import com.art.artproject.entity.Favourite;

public interface FavouriteService {

    Favourite giveFavourite(Long user_id,Long card_id, FavouriteRequest favouriteRequest);
}
