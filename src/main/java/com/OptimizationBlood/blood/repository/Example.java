package com.OptimizationBlood.blood.repository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

public class Example {
    // Find your Account Sid and Token at twilio.com/user/account
    private final static String ACCOUNT_SID = "ACf25404fa3da4d4986df7523deed096a0";
    private final static String AUTH_ID = "5c7fbbf758ecf6abdfaa2447affee243";



    public static void main(String[] args) {
        Twilio.init(ACCOUNT_SID, AUTH_ID);
    }

        public void getMessage() {
        Twilio.init(ACCOUNT_SID, AUTH_ID);

        Message message = Message.creator(new PhoneNumber("+258843764793"),
                new PhoneNumber("+258846771216"),
                "This is the ship that made the Kessel Run in fourteen parsecs?").create();

                 System.out.println(message.getSid());
    }

}