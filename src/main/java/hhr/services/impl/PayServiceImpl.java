package hhr.services.impl;

import hhr.entity.Pay;
import hhr.repository.PayRepository;
import hhr.services.PayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PayServiceImpl implements PayService {
    @Autowired
    PayRepository payRepository;
    @Override
    public Pay getByName(String pay) {
        return payRepository.findByName(pay);
    }

    @Override
    public Pay getById(int id) {
        return payRepository.findById(id);
    }

    @Override
    public List<Pay> getAll() {
        return payRepository.findAll();
    }
}
