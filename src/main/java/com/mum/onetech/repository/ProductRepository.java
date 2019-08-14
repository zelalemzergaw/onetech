package com.mum.onetech.repository;

import com.mum.onetech.domain.Product;
import com.mum.onetech.domain.Review;
import com.mum.onetech.domain.Seller;
import org.hibernate.sql.Select;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAllByCategoryId(Long id);

//    @Query(value = "SELECT count(p) FROM Product p WHERE p.category.id = :catId")
    @Query(value = "SELECT COUNT(*) FROM PRODUCT p WHERE p.CATEGORY_ID = :catId", nativeQuery = true)
    Long getCountByCategoryId(@Param("catId") Long catId);

    @Query(value = "SELECT count(p) FROM Product p")
    Long getCountAll();

    @Query("SELECT p FROM Product p WHERE p.promote = :promote")
    public List<Product> findProductByStatusPromoted(@Param("promote") String promote);

    @Query("SELECT p FROM Product p WHERE p.promote = :notPromoted")
    public List<Product> findProductByStatusNotPromoted(@Param("notPromote") String promote);
}
