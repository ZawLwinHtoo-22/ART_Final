package com.art.artproject.controller;

import com.art.artproject.domain.TalentResponse;
import com.art.artproject.dto.FavouriteRequest;
import com.art.artproject.entity.Favourite;
import com.art.artproject.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/favorite")
public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @PostMapping
    public ResponseEntity<TalentResponse> giveFavourite (@RequestParam Long card_id, FavouriteRequest request){
        Favourite favourite = favouriteService.giveFavourite(card_id, request);
        TalentResponse response =
                new TalentResponse<>(favourite, card, "success fav", HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

}
