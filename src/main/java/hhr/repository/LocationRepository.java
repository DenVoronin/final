package hhr.repository;

import hhr.entity.CardStatus;
import hhr.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LocationRepository extends JpaRepository<Location, Integer> {
    @Query("select b from Location b where b.name = :name")
    Location findByName(@Param("name") String name);

    @Query("select b from Location b where b.id = :id")
    Location findById(@Param("id") int id);
}
