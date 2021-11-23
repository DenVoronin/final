package hhr.services.impl;

import hhr.entity.ProjectCard;
import hhr.repository.ProjectRepository;
import hhr.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public ProjectCard newProject(ProjectCard project) {
        ProjectCard savedProject = projectRepository.saveAndFlush(project);

        return savedProject;
    }

    @Override
    public void delete(int id) {
        projectRepository.deleteById(id);
    }

    @Override
    public ProjectCard getByName(String name) {
        return projectRepository.findByName(name);
    }

    @Override
    public ProjectCard getById(int id) {
        return projectRepository.findById(id);
    }

    @Override
    public ProjectCard edit(ProjectCard project) {
        return projectRepository.saveAndFlush(project);
    }

    @Override
    public List<ProjectCard> getAll() {
        return projectRepository.findAll();
    }

}
