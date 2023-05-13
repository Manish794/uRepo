package com.manish.spring.model;


import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;

@Component
@ConfigurationProperties(prefix = "db")

@Data
@ToString
public class DBDetails implements Serializable {

    private String name;
    private String url;
    private String username;
    private String password;
    private boolean mySqlDB;

}
