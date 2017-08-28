package com.db.never_use_switch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum MailCodeEnum {
    WELCOME(1, new WelcomeMailGenerator()),
    DONT_CALL_US(2, new DontCallMailGenerator()),
    ADVERT(3, new AdvertMailGenerator());

    private int code;

    @Getter
    @Setter
    private MailGenerator generator;

    public void generator(){
        generator.generate();
    }

    public static MailCodeEnum findByCode(int code) throws Exception {
        for (MailCodeEnum value : values()) {
            if (value.code == code) {
                return value;
            }
        }
        throw new UnsupportedOperationException("Code " + code + " not found!");
    }
}
