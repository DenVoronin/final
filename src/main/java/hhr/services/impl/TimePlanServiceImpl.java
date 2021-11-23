package hhr.services.impl;

import hhr.entity.TimePlan;
import hhr.repository.TimePlanRepository;
import hhr.services.TimePlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimePlanServiceImpl implements TimePlanService {
    @Autowired
    TimePlanRepository timePlanRepository;

    @Override
    public TimePlan getByName(String timePlan) {
        return timePlanRepository.findByName(timePlan);
    }

    @Override
    public TimePlan getById(int id) {
        return timePlanRepository.findById(id);
    }

    @Override
    public List<TimePlan> getAll() {
        return timePlanRepository.findAll();
    }
}
