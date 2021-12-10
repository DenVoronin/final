package hhr.services.impl;

import hhr.entity.ProjectCard;
import hhr.repository.ProjectRepository;
import hhr.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
@Service
public class ProjectServiceImpl implements ProjectService {
    @Autowired
    private ProjectRepository projectRepository;
    private EntityManager entityManager;


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


    public List getAllCustom()  {

        List<ProjectCard> list = projectRepository.findAll();
        List<Object> list1 = new ArrayList<Object>();
       for (ProjectCard cards : list) {
           HashMap map = new HashMap();
           map.put("id",cards.getId());
           map.put("name",cards.getName());
           map.put("client",cards.getClient());
           map.put("funcArea",cards.getFuncArea());
           map.put("devMethod",cards.getDevMethod());
           map.put("deadlineHR",cards.getDeadlineHR());
           map.put("gost",cards.getGost());
           map.put("cardStatus",cards.getCardStatus());
           map.put("author",cards.getAuthor());
           list1.add(map);
            }
          return list1;
    }

    public List<ProjectCard> findCustom(String param, String value) throws NoSuchFieldException, IllegalAccessException {
        ArrayList<ProjectCard> lists = (ArrayList<ProjectCard>) projectRepository.findAll();
        List<ProjectCard> lists1 = new ArrayList<>();
        for (int i = 0; i<lists.size(); i++){
            if (lists.get(i).getClass().getDeclaredField(param).getName().equals("cardStatus")){
                if (lists.get(i).cardStatus.getName().equals(value)){
                    lists1.add(lists.get(i));
                }
            }

            if (lists.get(i).getClass().getDeclaredField(param).getName().equals("projectType")){
                if (lists.get(i).projectType.getName().equals(value)){
                    lists1.add(lists.get(i));
                }
            }

            if (lists.get(i).getClass().getDeclaredField(param).getName().equals("stage")){
                if (lists.get(i).stage.getName().equals(value)){
                    lists1.add(lists.get(i));
                }
            }

            if (lists.get(i).getClass().getDeclaredField(param).getName().equals("devMethod")){
                if (lists.get(i).devMethod.getName().equals(value)){
                    lists1.add(lists.get(i));
                }
            }

            if (lists.get(i).getClass().getDeclaredField(param).getName().equals("timeplan")){
                if (lists.get(i).timeplan.getName().equals(value)){
                    lists1.add(lists.get(i));
                }
            }

            if (lists.get(i).getClass().getDeclaredField(param).getName().equals("overtimes")){
                if (lists.get(i).overtimes.getName().equals(value)){
                    lists1.add(lists.get(i));
                }
            }

            if (lists.get(i).getClass().getDeclaredField(param).get(lists.get(i)).toString().equals(value)){
                lists1.add(lists.get(i));
            }

        }

        return lists1;
    }

}
