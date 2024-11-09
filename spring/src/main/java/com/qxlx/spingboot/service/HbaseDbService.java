package com.qxlx.spingboot.service;

import org.springframework.stereotype.Service;

/**
 * @author qxlx
 * @date 2024/11/3 20:24
 */
@Service
public class HbaseDbService implements DbService{

    @Override
    public void db() {
        System.out.println("HbaseDB");
    }
}
