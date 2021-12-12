package hhr.services;

import hhr.entity.CardStatus;
import hhr.entity.Location;

import java.util.List;

public interface LocationService {
    Location getByName(String location);
    Location getById(int id);
    List<Location> getAll();
}
