package com.art.artproject.controller;

import com.art.artproject.domain.TalentResponse;
import com.art.artproject.dto.FavouriteRequest;
import com.art.artproject.entity.Favourite;
import com.art.artproject.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin

@RequestMapping("/favourite")

public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @PostMapping
    public ResponseEntity<TalentResponse> giveFavourite (@RequestParam String user_ids,Long card_id,@RequestBody FavouriteRequest request){
        Favourite favourite = favouriteService.giveFavourite(user_ids,card_id, request);
        TalentResponse response =
                new TalentResponse<>(favourite, "success fav", HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<TalentResponse<List<Favourite>>> showAll(){
        List<Favourite> favourites=favouriteService.showAll();
        TalentResponse response =
                new TalentResponse<>(favourites, "success", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<TalentResponse<Favourite>> updateFavourite(@RequestParam Long id,@RequestBody FavouriteRequest request){
        Favourite favourite=favouriteService.updateNewFavourite(id,request);
        TalentResponse response =
                new TalentResponse<>(favourite, "success", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @DeleteMapping
    public ResponseEntity<String> deleteFavourite(@RequestParam Long id){
        favouriteService.deleteFavourite(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
