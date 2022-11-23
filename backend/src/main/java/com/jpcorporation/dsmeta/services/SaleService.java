package com.jpcorporation.dsmeta.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.jpcorporation.dsmeta.entities.Sale;
import com.jpcorporation.dsmeta.repositories.SaleRepository;

@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;
 
    public Page<Sale> findSales(String minDate, String maxDate, Pageable pageable){
        
        LocalDate today = LocalDate.ofInstant(Instant.now(), ZoneId.systemDefault());
        
        LocalDate min = minDate.equals("")? today.minusYears(1) : LocalDate.parse(minDate);
        // (?) -> Caso Seja, faz uma comparação
        // (:) -> Se não 
        LocalDate max = maxDate.equals("") ? today : LocalDate.parse(maxDate);
        
        return saleRepository.findSales(min, max, pageable);
    }
    
}
