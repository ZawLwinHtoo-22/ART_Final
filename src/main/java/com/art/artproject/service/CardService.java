package com.art.artproject.service;

import com.art.artproject.dto.NewCardRequest;
import com.art.artproject.entity.Card;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


import java.io.IOException;
import java.util.List;

public interface CardService {


    Card createCard(Long user_id, MultipartFile imageFile, NewCardRequest request) throws IOException;
    List<Card> showAll();
    List<Card> showWithType(Long category_id);
    Card showWithId(Long card_id);

}
