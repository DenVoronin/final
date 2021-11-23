package hhr.services.impl;

import hhr.entity.Overtimes;
import hhr.repository.OvertimesRepository;
import hhr.services.OvertimesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OvertimesServiceImpl implements OvertimesService {
    @Autowired
    OvertimesRepository overtimesRepository;
    @Override
    public Overtimes getByName(String overtime) {
        return overtimesRepository.findByName(overtime);
    }

    @Override
    public Overtimes getById(int id) {
        return overtimesRepository.findById(id);
    }

    @Override
    public List<Overtimes> getAll() {
        return overtimesRepository.findAll();
    }
}
