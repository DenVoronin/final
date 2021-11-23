package hhr.services.impl;

import hhr.entity.ProjectStage;
import hhr.repository.ProjectStageRepository;
import hhr.services.ProjectStageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectStageServiceImpl implements ProjectStageService {
    @Autowired
    ProjectStageRepository projectStageRepository;
    @Override
    public ProjectStage getByName(String projectStage) {
        return projectStageRepository.findByName(projectStage);
    }

    @Override
    public ProjectStage getById(int id) {
        return projectStageRepository.getById(id);
    }

    @Override
    public List<ProjectStage> getAll() {
        return projectStageRepository.findAll();
    }
}
