package hhr.services.impl;

import hhr.entity.CardStatus;
import hhr.entity.Location;
import hhr.repository.CardStatusRepository;
import hhr.repository.LocationRepository;
import hhr.services.CardStatusService;
import hhr.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;


    @Override
    public Location getByName(String cardStatus) {
        return locationRepository.findByName(cardStatus);
    }

    @Override
    public Location getById(int id) {
        return locationRepository.findById(id);
    }

    @Override
    public List<Location> getAll() {
        return locationRepository.findAll();
    }
}
