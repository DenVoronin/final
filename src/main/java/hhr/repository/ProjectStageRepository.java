package hhr.repository;

import hhr.entity.ProjectCard;
import hhr.entity.ProjectStage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectStageRepository extends JpaRepository<ProjectStage, Integer> {
    @Query("select b from ProjectStage b where b.name = :name")
    ProjectStage findByName(@Param("name") String name);

    @Query("select b from ProjectStage b where b.id = :id")
    ProjectStage findById(@Param("id") int id);
}
