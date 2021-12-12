package hhr.repository;

import hhr.entity.Overtimes;

import hhr.entity.ProjCat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface ProjCatRepository extends JpaRepository<ProjCat, Integer> {
    @Query("select b from ProjCat b where b.name = :name")
    ProjCat findByName(@Param("name") String name);

    @Query("select b from ProjCat b where b.id = :id")
    ProjCat findById(@Param("id") int id);
}
