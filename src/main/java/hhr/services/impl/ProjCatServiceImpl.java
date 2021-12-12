package hhr.services.impl;

import hhr.entity.Overtimes;
import hhr.entity.ProjCat;
import hhr.repository.OvertimesRepository;
import hhr.repository.ProjCatRepository;
import hhr.services.OvertimesService;
import hhr.services.ProjCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjCatServiceImpl implements ProjCatService {
    @Autowired
    ProjCatRepository projCatRepository;
    @Override
    public ProjCat getByName(String overtime) {
        return projCatRepository.findByName(overtime);
    }

    @Override
    public ProjCat getById(int id) {
        return projCatRepository.findById(id);
    }

    @Override
    public List<ProjCat> getAll() {
        return projCatRepository.findAll();
    }
}
