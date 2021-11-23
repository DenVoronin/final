package hhr.services.impl;

import hhr.entity.ProjectType;
import hhr.repository.ProjectTypeRepository;
import hhr.services.ProjectTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectTypeServiceImpl implements ProjectTypeService {
    @Autowired
    ProjectTypeRepository projectTypeRepository;
    @Override
    public ProjectType getByName(String projectType) {
        return projectTypeRepository.findByName(projectType);
    }

    @Override
    public ProjectType getById(int id) {
        return projectTypeRepository.findById(id);
    }

    @Override
    public List<ProjectType> getAll() {
        return projectTypeRepository.findAll();
    }
}
