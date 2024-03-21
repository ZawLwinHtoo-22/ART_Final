package com.art.artproject.service.impl;

import com.art.artproject.dto.NewCardRequest;
import com.art.artproject.entity.Card;
import com.art.artproject.entity.Category;
import com.art.artproject.entity.User;
import com.art.artproject.repo.CardRepo;
import com.art.artproject.repo.CategoryRepo;
import com.art.artproject.repo.UserRepo;
import com.art.artproject.service.CardService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CardServiceImpl implements CardService {
    @Autowired
    private CardRepo cardRepo;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Autowired
    private CardService cardService;
    @Override
    public Card createCard(NewCardRequest request) {
        Card card=mapper.map(request,Card.class);
        User user=userRepo.findById(request.getUser_id()).get();
        Category category=categoryRepo.findById(request.getCategory_id()).get();
        card.setUser(user);
        card.setCategory(category);
        return cardRepo.save(card);
    }

    @Override
    public List<Card> showAll() {
        return cardRepo.findAll();
    }

    @Override
    public List<Card> showWithType(Long category_id) {
        List<Card> cards=cardService.showAll();
        List<Card> filterCards=new ArrayList<>();
        for(Card card:cards){
            if (card.getCategory().getId()==category_id){
                filterCards.add(card);
            }
        }
        return filterCards;
    }
}
