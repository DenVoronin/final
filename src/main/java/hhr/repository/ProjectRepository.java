package hhr.repository;

import hhr.entity.ProjectCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepository extends JpaRepository<ProjectCard, Integer> {
    @Query("select b from ProjectCard b where b.name = :name")
    ProjectCard findByName(@Param("name") String name);

    @Query("select b from ProjectCard b where b.id = :id")
    ProjectCard findById(@Param("id") int id);

}
