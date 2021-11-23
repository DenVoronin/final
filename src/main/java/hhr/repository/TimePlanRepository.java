package hhr.repository;

import hhr.entity.ProjectCard;
import hhr.entity.ProjectType;
import hhr.entity.TimePlan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface TimePlanRepository extends JpaRepository<TimePlan, Integer> {
    @Query("select b from TimePlan b where b.name = :name")
    TimePlan findByName(@Param("name") String name);

    @Query("select b from TimePlan b where b.id = :id")
    TimePlan findById(@Param("id") int id);
}
