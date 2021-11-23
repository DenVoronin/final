package hhr.repository;

import hhr.entity.CardStatus;
import hhr.entity.Overtimes;
import hhr.entity.ProjectCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OvertimesRepository extends JpaRepository<Overtimes, Integer> {
    @Query("select b from Overtimes b where b.name = :name")
    Overtimes findByName(@Param("name") String name);

    @Query("select b from Overtimes b where b.id = :id")
    Overtimes findById(@Param("id") int id);
}
