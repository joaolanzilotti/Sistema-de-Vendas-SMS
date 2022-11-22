package com.jpcorporation.repository;

import com.jpcorporation.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<Long, Sale>{
    
}
