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

@RequestMapping("/favourites")

public class FavouriteController {

    @Autowired
    private FavouriteService favouriteService;

    @PostMapping
    public ResponseEntity<TalentResponse<Favourite>> doFavourite (@RequestParam Long user_id,Long card_id){
        Favourite favourite = favouriteService.doFavourite(user_id,card_id);
        TalentResponse response =
                new TalentResponse<>(favourite, "Success favourite", HttpStatus.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<TalentResponse<List<Favourite>>> showAll(){
        List<Favourite> favourites=favouriteService.showAll();
        TalentResponse response =
                new TalentResponse<>(favourites, "success", HttpStatus.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteFavourite(@RequestParam Long id){
        favouriteService.deleteFavourite(id);
        return new ResponseEntity<>("Successfully deleted", HttpStatus.OK);
    }
}
