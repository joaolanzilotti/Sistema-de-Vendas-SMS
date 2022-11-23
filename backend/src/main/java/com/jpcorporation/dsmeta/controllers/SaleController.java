package com.jpcorporation.dsmeta.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jpcorporation.dsmeta.entities.Sale;
import com.jpcorporation.dsmeta.services.SaleService;

@RestController
@RequestMapping(value="/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;
   
    @GetMapping
    public List<Sale> findSales(){
        return saleService.findSales();
    }
    
}
