package com.qxlx.spingboot.controller;

import com.qxlx.spingboot.service.DbService;
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
public class DbController {

//    @Autowired
//    @Qualifier("mySQLDbService.MySQLDbServiceImpl")
//    private DbService dbService;
//    private DbService mySQLDbService;

    @RequestMapping(path = "/hiDb",method = RequestMethod.GET)
    public String hiScope() {
//        dbService.db();
        return "";
    }

}
