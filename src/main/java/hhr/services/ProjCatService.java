package hhr.services;

import hhr.entity.CardStatus;
import hhr.entity.Pay;
import hhr.entity.ProjCat;

import java.util.List;

public interface ProjCatService {
    ProjCat getByName(String projCat);
    ProjCat getById(int id);
    List<ProjCat> getAll();
}
