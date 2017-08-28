package com.db.never_use_switch;

import org.fluttercode.datafactory.impl.DataFactory;

public class Main {
    public static void main(String[] args) throws Exception {
        DataFactory dataFactory = new DataFactory();
        MailSender mailSender = new MailSender();
        while (true) {
            MailInfo mailInfo = new MailInfo(dataFactory.getNumberBetween(1, 4));
            mailSender.sendMail(mailInfo);
            Thread.sleep(1000);
        }
    }
}
