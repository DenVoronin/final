package hhr.services;

import hhr.entity.CardStatus;
import hhr.entity.ProjectStage;

import java.util.List;

public interface ProjectStageService {
    ProjectStage getByName(String projectStage);
    ProjectStage getById(int id);
    List<ProjectStage> getAll();
}
