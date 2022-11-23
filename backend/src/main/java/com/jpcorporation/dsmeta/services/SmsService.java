// package com.jpcorporation.dsmeta.services;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.stereotype.Service;

// import com.twilio.Twilio;
// import com.twilio.rest.api.v2010.account.Message;
// import com.twilio.type.PhoneNumber;

// @Service
// public class SmsService {

//     //@Value -> Se Comunica com o aplication.proprieties, Crio Variaveis que se comunicam por lá
// 	@Value("${twilio.sid}")
// 	private String twilioSid;

// 	@Value("${twilio.key}")
// 	private String twilioKey;

// 	@Value("${twilio.phone.from}")
// 	private String twilioPhoneFrom;

// 	@Value("${twilio.phone.to}")
// 	private String twilioPhoneTo;

// 	public void sendSms() {

// 		Twilio.init(twilioSid, twilioKey);

// 		PhoneNumber to = new PhoneNumber(twilioPhoneTo);
// 		PhoneNumber from = new PhoneNumber(twilioPhoneFrom);

// 		Message message = Message.creator(to, from, "Deu Certo, Sou Foda! :3").create();

// 		System.out.println(message.getSid());
// 	}
// }

