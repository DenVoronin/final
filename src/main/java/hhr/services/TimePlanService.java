package hhr.services;

import hhr.entity.CardStatus;
import hhr.entity.TimePlan;

import java.util.List;

public interface TimePlanService {
    TimePlan getByName(String timePlan);
    TimePlan getById(int id);
    List<TimePlan> getAll();
}
