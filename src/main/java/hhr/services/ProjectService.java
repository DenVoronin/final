package hhr.services;

import hhr.entity.ProjectCard;

import java.util.List;

public interface ProjectService {
    ProjectCard newProject(ProjectCard projectCard);
    void delete(int id);
    ProjectCard getByName(String project);
    ProjectCard getById(int id);
    ProjectCard edit(ProjectCard projectCard);
    List<ProjectCard> getAll();
}
