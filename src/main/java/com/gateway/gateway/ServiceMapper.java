package com.gateway.gateway;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties
public class ServiceMapper {
    private String mService = "http://localhost:808";

    public String getMserviceUrl(String msCode) {
        return mService.concat(msCode);
    }
}
