package hhr.services;

import hhr.entity.CardStatus;
import hhr.entity.Overtimes;

import java.util.List;

public interface OvertimesService {
    Overtimes getByName(String overtime);
    Overtimes getById(int id);
    List<Overtimes> getAll();

}
