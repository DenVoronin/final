package hhr.services;

import hhr.entity.Changes;
import hhr.entity.ProjectCard;

import java.util.List;

public interface ChangesService {
    Changes newChanges(Changes changes);
    void delete(int id);
    Changes getByName(String changes);
    Changes getById(int id);
    Changes edit(Changes changes);
    List<Changes> getAll();
}
