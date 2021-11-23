package hhr.services.impl;

import hhr.entity.CardStatus;
import hhr.repository.CardStatusRepository;
import hhr.repository.ProjectRepository;
import hhr.services.CardStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CardStatusServiceImpl implements CardStatusService {

    @Autowired
    private CardStatusRepository cardStatusRepository;


    @Override
    public CardStatus getByName(String cardStatus) {
        return cardStatusRepository.findByName(cardStatus);
    }

    @Override
    public CardStatus getById(int id) {
        return cardStatusRepository.findById(id);
    }

    @Override
    public List<CardStatus> getAll() {
        return cardStatusRepository.findAll();
    }
}
