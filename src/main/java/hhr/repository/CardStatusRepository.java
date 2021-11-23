package hhr.repository;

import hhr.entity.CardStatus;
import hhr.entity.ProjectCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CardStatusRepository extends JpaRepository<CardStatus, Integer> {
    @Query("select b from CardStatus b where b.name = :name")
    CardStatus findByName(@Param("name") String name);

    @Query("select b from CardStatus b where b.id = :id")
    CardStatus findById(@Param("id") int id);
}
