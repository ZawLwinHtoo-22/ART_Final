package com.art.artproject.service;

import com.art.artproject.dto.NewCardRequest;
import com.art.artproject.entity.Card;
import com.art.artproject.repo.CardRepo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public interface CardService {

    Card createCard(Long user_id,NewCardRequest request);
    List<Card> showAll();
    List<Card> showWithType(Long category_id);

    Card showWithId(Long card_id);


}
