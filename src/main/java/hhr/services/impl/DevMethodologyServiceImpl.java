package hhr.services.impl;

import hhr.entity.DevMethodology;
import hhr.repository.DevMethodologyRepository;
import hhr.services.DevMethodologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DevMethodologyServiceImpl implements DevMethodologyService {
    @Autowired
    DevMethodologyRepository devMethodologyRepository;
    @Override
    public DevMethodology getByName(String devMethod) {
        return devMethodologyRepository.findByName(devMethod);
    }

    @Override
    public DevMethodology getById(int id) {
        return devMethodologyRepository.findById(id);
    }

    @Override
    public List<DevMethodology> getAll() {
        return devMethodologyRepository.findAll();
    }
}
