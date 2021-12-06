package hhr.repository;

import hhr.entity.CardStatus;
import hhr.entity.Changes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ChangesRepository extends JpaRepository<Changes, Integer> {
    @Query("select b from Changes b where b.name = :name")
    Changes findByName(@Param("name") String name);

    @Query("select b from Changes b where b.id = :id")
    Changes findById(@Param("id") int id);
}
