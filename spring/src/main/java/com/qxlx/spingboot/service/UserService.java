package com.qxlx.spingboot.service;

import com.qxlx.spingboot.pojo.User;
import com.qxlx.spingboot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author jiabaobao
 * @date 2023/11/5 9:04 PM
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    public void saveUserDb() {
        User user = new User();
        user.setLoginName(Math.random()+System.currentTimeMillis()+"");
        user.setPassword(Math.random()+System.currentTimeMillis()+"");
        user.setName("qxlx"+System.currentTimeMillis());
        try {
            userRepository.save(user);
            TimeUnit.MILLISECONDS.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
