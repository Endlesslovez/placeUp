package com.nxm.palceup.service;

import com.nxm.palceup.entities.Bill;

public interface SendMailService {
    void SendEmail(String user, String pass,Integer idchange);

    void SendEmailStatus(String user, String pass,Integer status ,Integer idBill);

    void SendEmailChangePass(String user, String pass ,String mail);

    void sendEmailBill(String User, String pass,String mail,String fullName, Bill bill);
}
