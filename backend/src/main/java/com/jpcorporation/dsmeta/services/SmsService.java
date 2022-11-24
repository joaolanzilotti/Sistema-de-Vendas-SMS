package com.jpcorporation.dsmeta.services;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jpcorporation.dsmeta.entities.Sale;
import com.jpcorporation.dsmeta.repositories.SaleRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

@Service
public class SmsService {

    //@Value -> Se Comunica com o aplication.proprieties, Crio Variaveis que se comunicam por lá
	@Value("${twilio.sid}")
	private String twilioSid;

	@Value("${twilio.key}")
	private String twilioKey;

	@Value("${twilio.phone.from}")
	private String twilioPhoneFrom;

	@Value("${twilio.phone.to}")
	private String twilioPhoneTo;
	
	@Autowired
	private SaleRepository saleRepository;

	public void sendSms(Long saleId) {
		
		Sale sale = saleRepository.findById(saleId).get();
		
		String date = sale.getDate().getMonthValue() + "/" + sale.getDate().getYear();
		
		String msg = "O Vendedor: " + sale.getSellerName() + " Foi Destaque em: " + date 
				+ " com um total de R$ " + String.format("%.2f", sale.getAmount());

		Twilio.init(twilioSid, twilioKey);

		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

		Message message = Message.creator(to, from, msg).create();

	}
	
  public void call() throws URISyntaxException {
      Twilio.init(twilioSid, twilioKey);
      

      PhoneNumber from = new PhoneNumber(twilioPhoneFrom);
      PhoneNumber to = new PhoneNumber(twilioPhoneTo);

      Call call = Call.creator(to, from,
              new URI("http://demo.twilio.com/docs/voice.xml")).create();
  }
}

