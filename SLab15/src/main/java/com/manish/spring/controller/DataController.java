package com.manish.spring.controller;

import com.manish.spring.model.DBDetails;
import com.manish.spring.model.IPDetails;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/data")
@Slf4j
public class DataController {

    private DBDetails dbDetails;
    private IPDetails ipDetails;

    @Value("${spring.profiles.active: default}")
    private String profileName;

    @Autowired
    public DataController(DBDetails dbDetails, IPDetails ipDetails) {
        this.dbDetails = dbDetails;
        this.ipDetails = ipDetails;
    }

    @GetMapping(value="/ip",produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public IPDetails readIPData(){
        log.info("DataController -> showDetails ");
        log.info("Active Profile "+ profileName);
        log.info(""+ipDetails);
        return ipDetails;
    }

    @GetMapping(value="/db", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public DBDetails readDBData(){
        log.info("DataController -> showDetails ");
        log.info("Active Profile "+ profileName);
        log.info(""+dbDetails);
        return dbDetails;
    }
}
