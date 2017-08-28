package com.db.httpCodes;

public class HttpServiceImpl implements HttpService{
    @Override
    public void handleHttpCode(int code){
        HttpCodeEnum.findByCode(code).handle();
    }
}
