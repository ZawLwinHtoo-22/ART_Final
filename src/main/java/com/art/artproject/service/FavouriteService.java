package com.art.artproject.service;

import com.art.artproject.dto.FavouriteRequest;
import com.art.artproject.entity.Favourite;

import java.util.List;

public interface FavouriteService {

    Favourite doFavourite(Long user_id,Long card_id);
    List<Favourite> showAll();
    void deleteFavourite(Long id);
}
