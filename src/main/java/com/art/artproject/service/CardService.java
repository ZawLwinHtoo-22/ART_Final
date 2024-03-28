package com.art.artproject.service;

import com.art.artproject.dto.NewCardRequest;
import com.art.artproject.entity.Card;
<<<<<<< HEAD
=======
import com.art.artproject.repo.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
>>>>>>> 6ee21ce59f7530cf681c45adf1863a59902f8866

import java.util.List;

public interface CardService {

<<<<<<< HEAD
    Card createCard(Long user_id, NewCardRequest request);
=======
    Card createCard(MultipartFile file, Long user_id, NewCardRequest request);
>>>>>>> 6ee21ce59f7530cf681c45adf1863a59902f8866
    List<Card> showAll();
    List<Card> showWithType(Long category_id);


}
