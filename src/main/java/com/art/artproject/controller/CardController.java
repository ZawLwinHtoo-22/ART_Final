package com.art.artproject.controller;

import com.art.artproject.domain.TalentResponse;
import com.art.artproject.dto.NewCardRequest;
import com.art.artproject.entity.Card;
import com.art.artproject.entity.FileUtils;
import com.art.artproject.service.CardService;
import com.art.artproject.utils.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

<<<<<<< HEAD
//    @PostMapping("/upload")
//    public String saveFile(@RequestParam MultipartFile file){
//        return FileUtils.save(file);
//    }

=======
//    @PostMapping("/save")
//    public void saveCard(@RequestParam("image") MultipartFile image,
//                         @RequestParam("file") MultipartFile file,
//                         @RequestParam("title") String title) {
//        try {
//            Card card = new Card();
//            card.setImageData(image.getBytes());
//            card.setFileData(file.getBytes());
//            card.setTitle(title);
//            cardService.saveCard(card);
//        } catch (Exception e) {
//            // Handle exceptions
//        }
//    }



>>>>>>> 6ee21ce59f7530cf681c45adf1863a59902f8866
    @PostMapping
    public ResponseEntity<TalentResponse> createCard(@RequestParam MultipartFile file,@RequestParam Long user_id,@RequestBody NewCardRequest request){
        Card card=cardService.createCard(file, user_id,request);


        TalentResponse response=
                new TalentResponse(file,"Successfully created", HttpStatus.CREATED);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Card>> showAll(){
        List<Card> cards=cardService.showAll();
        return new ResponseEntity<>(cards, HttpStatus.OK);
    }
    @GetMapping("/filter")
    public ResponseEntity<List<Card>> showWithType(@RequestParam Long category_id){
        List<Card> cards=cardService.showWithType(category_id);
        return new ResponseEntity<>(cards,HttpStatus.OK);
    }


}
