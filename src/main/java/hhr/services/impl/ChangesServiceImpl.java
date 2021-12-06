package hhr.services.impl;

import hhr.entity.Changes;
import hhr.entity.ProjectCard;
import hhr.repository.ChangesRepository;
import hhr.repository.ProjectRepository;
import hhr.services.ChangesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class ChangesServiceImpl implements ChangesService {
    @Autowired
    private ChangesRepository changesRepository;
    private EntityManager entityManager;

    @Override
    public Changes newChanges(Changes changes) {
        Changes savedChanges = changesRepository.saveAndFlush(changes);

        return savedChanges;
    }

    @Override
    public void delete(int id) {
    changesRepository.deleteById(id);
    }

    @Override
    public Changes getByName(String changes) {
        return null;
    }

    @Override
    public Changes getById(int id) {
        return changesRepository.findById(id);
    }

    @Override
    public Changes edit(Changes changes) {
        return changesRepository.saveAndFlush(changes);
    }

    @Override
    public List<Changes> getAll() {
        return changesRepository.findAll();
    }
}
