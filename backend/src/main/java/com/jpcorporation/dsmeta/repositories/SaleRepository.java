package com.jpcorporation.dsmeta.repositories;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.jpcorporation.dsmeta.entities.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{
    
    @Query("SELECT obj FROM Sale obj WHERE obj.date BETWEEN :min and :max ORDER BY obj.amount DESC")
    Page<Sale> findSales(@Param("min") LocalDate min,@Param("max") LocalDate max, Pageable pageable);

}
