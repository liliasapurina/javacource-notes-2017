package com.db.httpCodes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public enum HttpCodeEnum {

    INFORMATIONAL(100, 199, new InformationalHandler()),
    SUCCESS(200, 299, new SuccessHandler()),
    REDIRECT(300, 399, new RedirectHandler()),
    CLIENT_ERROR(400, 499, new ClientHandler()),
    SERVER_ERROR(500, 599, new ServerHandler());

    private int min;
    private int max;
    @Getter
    @Setter
    private HttpCodeHandler handler;

    public void handle(){
        handler.handle();
    }

    public static HttpCodeEnum findByCode(int code) {
        HttpCodeEnum[] values = values();
        for (HttpCodeEnum value : values) {
            if (value.min <= code && code <= value.max) {
                return value;
            }
        }
        return null;
    }
}
