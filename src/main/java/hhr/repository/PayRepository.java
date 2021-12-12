package hhr.repository;

import hhr.entity.Changes;
import hhr.entity.Pay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PayRepository extends JpaRepository<Pay, Integer> {
    @Query("select b from Pay b where b.name = :name")
    Pay findByName(@Param("name") String name);

    @Query("select b from Pay b where b.id = :id")
    Pay findById(@Param("id") int id);
}
