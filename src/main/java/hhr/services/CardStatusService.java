package hhr.services;

import hhr.entity.CardStatus;
import hhr.entity.ProjectCard;

import java.util.List;

public interface CardStatusService {
    CardStatus getByName(String cardStatus);
    CardStatus getById(int id);
    List<CardStatus> getAll();
}
