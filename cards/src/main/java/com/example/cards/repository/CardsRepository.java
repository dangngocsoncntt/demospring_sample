package com.example.cards.repository;

import com.example.cards.model.CardsDto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Repository
public class CardsRepository {

    private List<CardsDto> cardList = new ArrayList<>();

    public void save(CardsDto cardsDto){
        cardList.add(cardsDto);
    }

    public void saveAll(Collection<CardsDto> accountsDtos){
        cardList.addAll(accountsDtos);
    }

}
