package hhr.repository;

import hhr.entity.ProjectCard;
import hhr.entity.ProjectStage;
import hhr.entity.ProjectType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectTypeRepository extends JpaRepository<ProjectType, Integer> {
    @Query("select b from ProjectType b where b.name = :name")
    ProjectType findByName(@Param("name") String name);

    @Query("select b from ProjectType b where b.id = :id")
    ProjectType findById(@Param("id") int id);
}
