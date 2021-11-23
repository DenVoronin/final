package hhr.services;

import hhr.entity.CardStatus;
import hhr.entity.ProjectType;

import java.util.List;

public interface ProjectTypeService {
    ProjectType getByName(String projectType);
    ProjectType getById(int id);
    List<ProjectType> getAll();
}
