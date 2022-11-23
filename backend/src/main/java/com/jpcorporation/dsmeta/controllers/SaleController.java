package com.jpcorporation.dsmeta.controllers;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jpcorporation.dsmeta.entities.Sale;
import com.jpcorporation.dsmeta.services.SaleService;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@RestController
@RequestMapping(value = "/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

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

    @GetMapping("/notification")
    public void notifySms() {
        Twilio.init("ACe2c9afa1754376cbcb52cd55a3b423c3", "fb554377f2877915445fb541f1047e97");
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber("+5511971271592"),
                new com.twilio.type.PhoneNumber("+14256007840"),//5511971271592
                "Sou Foda")
                .create();

        System.out.println(message.getSid());
    }
    
    
    @GetMapping("/call")
    public void call() throws URISyntaxException {
        Twilio.init("ACe2c9afa1754376cbcb52cd55a3b423c3", "fb554377f2877915445fb541f1047e97");
        

        String from = "+14256007840";
        String to = "+5512996387061";

        Call call = Call.creator(new PhoneNumber(to), new PhoneNumber(from),
                new URI("http://demo.twilio.com/docs/voice.xml")).create();
                System.out.println(call.getSid());
    }
}

    
        
    

