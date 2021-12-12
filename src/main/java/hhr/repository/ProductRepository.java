package hhr.repository;

import hhr.entity.CardStatus;
import hhr.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    @Query("select b from Product b where b.name = :name")
    Product findByName(@Param("name") String name);

    @Query("select b from Product b where b.id = :id")
    Product findById(@Param("id") int id);
}
