package com.art.artproject.controller;

import com.art.artproject.domain.TalentResponse;
import com.art.artproject.dto.NewCardRequest;
import com.art.artproject.entity.Card;
import com.art.artproject.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cards")
@CrossOrigin
public class CardController {
    @Autowired
    private CardService cardService;

    @PostMapping
    public ResponseEntity<TalentResponse> createCard(@RequestParam Long user_id,@RequestBody NewCardRequest request){
        Card card=cardService.createCard(user_id,request);
        TalentResponse response=
                new TalentResponse(card,"Successfully created", HttpStatus.CREATED);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Card>> showAll(){
        List<Card> cards=cardService.showAll();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }

    @GetMapping("/find")
    public ResponseEntity<Card> showById(@RequestParam Long card_id){
        Card card = cardService.showWithId(card_id);
        return new ResponseEntity<>(card,HttpStatus.OK);

    }
    @GetMapping("/filter")
    public ResponseEntity<List<Card>> showWithType(@RequestParam Long category_id){
        List<Card> cards=cardService.showWithType(category_id);
        return new ResponseEntity<>(cards,HttpStatus.OK);
    }




}
