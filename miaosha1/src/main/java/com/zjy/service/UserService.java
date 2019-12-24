package com.zjy.service;

import com.zjy.dao.UserDao;
import com.zjy.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserDao userDao;

    public User getByid(int id){
        return userDao.getById(id);
    }

}
