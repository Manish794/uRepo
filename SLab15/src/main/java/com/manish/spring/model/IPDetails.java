package com.manish.spring.model;


import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "myserver")

@Data
@ToString
public class IPDetails implements Serializable {

    private List<String> ip;

}
