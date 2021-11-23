package hhr.services;

import hhr.entity.CardStatus;
import hhr.entity.DevMethodology;

import java.util.List;

public interface DevMethodologyService {
    DevMethodology getByName(String devMethod);
    DevMethodology getById(int id);
    List<DevMethodology> getAll();
}
