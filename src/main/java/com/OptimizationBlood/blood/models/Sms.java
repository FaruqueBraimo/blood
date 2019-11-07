package com.OptimizationBlood.blood.models;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

import com.telesign.MessagingClient;
import com.telesign.RestClient;



public class Sms {


    String customerId = "9BAE1DD9-D035-4919-A935-655CE3FCB85D";
    String apiKey = "YCtpodyHVCAkpVw+ABkNn7z631zWSEXpLwFiSMWzRz73z/WtqwmnD3223ueLCbs8sdVv+WxkC0gNL+bc55IWNw==";
    String phoneNumber = "258847427855";
    String message = "Agendamento  confirmado!!!.";
    String messageType = "ARN";


    public void sms() {
        try {
            MessagingClient messagingClient = new MessagingClient(customerId, apiKey);
            RestClient.TelesignResponse telesignResponse = messagingClient.message(phoneNumber, message, messageType, null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    }


