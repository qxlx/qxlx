package com.qxlx.spingboot.controller;

import com.qxlx.spingboot.config.ValueConfig;
import com.qxlx.spingboot.service.DbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qxlx
 * @date 2024/11/3 20:22
 */
@RestController
@Slf4j
public class DbController {

    @Autowired
    private ValueConfig valueConfig;

//    @Autowired
//    @Qualifier("mySQLDbService.MySQLDbServiceImpl")
//    private DbService dbService;
//    private DbService mySQLDbService;

    @RequestMapping(path = "/hiDb",method = RequestMethod.GET)
    public String hiScope() {
//        dbService.db();
        return "";
    }

    @RequestMapping(path = "/config",method = RequestMethod.GET)
    public String config() {
        log.info("value:",valueConfig.getPassword());
        log.info("username",valueConfig.getUsername());
        return valueConfig.getPassword()+"\t"+valueConfig.getUsername();
    }

}
