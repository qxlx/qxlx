package com.qxlx.spingboot.service;

import org.springframework.stereotype.Service;

/**
 * @author qxlx
 * @date 2024/11/3 20:23
 */
@Service
public class MySQLDbService implements DbService{

    @Override
    public void db() {
        System.out.println("mysql init");
    }

    @Service
    public static class MySQLDbServiceImpl implements DbService{
        @Override
        public void db() {
            System.out.println("mysql init");
        }
    }
}
