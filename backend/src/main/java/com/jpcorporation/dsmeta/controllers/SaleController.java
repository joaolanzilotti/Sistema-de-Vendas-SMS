package com.jpcorporation.dsmeta.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpcorporation.dsmeta.entities.Sale;
import com.jpcorporation.dsmeta.services.SaleService;
import com.jpcorporation.dsmeta.services.SmsService;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;
    
    @Autowired
    private SmsService smsService;

    // @Autowired
    // private SmsService smsService;
    //Page retorna uma lista em forma de Pagina
    @GetMapping
    public Page<Sale> findSales(
            @RequestParam(value = "minDate", defaultValue = "") String minDate,
            @RequestParam(value = "maxDate", defaultValue = "") String maxDate,
            Pageable pageable) {
        return saleService.findSales(minDate, maxDate, pageable);
    }

    @GetMapping("/{id}/notification")
    public void notifySms(@PathVariable Long id) {
        smsService.sendSms(id);
    }
    
    @GetMapping("/call")
    public void call() throws URISyntaxException {
    	smsService.call();
    }

    

}

    
        
    

