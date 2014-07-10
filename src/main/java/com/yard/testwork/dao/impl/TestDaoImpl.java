package com.yard.testwork.dao.impl;

import com.yard.testwork.dao.TestDao;
import com.yard.testwork.model.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class TestDaoImpl implements TestDao{
    @Value("${app.admin.name}")
    private String adminName;

    @Override
    public User getUser(String userName) {
        // вместо запроса к бд...
        if (!adminName.equals(userName)) return null;

        User usr = new User();
        usr.setLogin(adminName);
        usr.setEnabled(true);
        usr.setEmail("test@northyard.ru");
        usr.setId(1);
        usr.setName("Иванов Иван Иванович");
        usr.setCreated(new Date());
        usr.setPasswordMd5("test");
        return usr;

    }
}
