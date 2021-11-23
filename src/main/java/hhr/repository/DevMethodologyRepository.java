package hhr.repository;

import hhr.entity.CardStatus;
import hhr.entity.DevMethodology;
import hhr.entity.ProjectCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface DevMethodologyRepository extends JpaRepository<DevMethodology, Integer> {
    @Query("select b from DevMethodology b where b.name = :name")
    DevMethodology findByName(@Param("name") String name);

    @Query("select b from DevMethodology b where b.id = :id")
    DevMethodology findById(@Param("id") int id);
}
