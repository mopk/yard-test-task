package com.yard.testwork.service;

import com.yard.testwork.dao.TestDao;
import com.yard.testwork.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

@Service
public class TestService {
    @Autowired
    TestDao testDao;

    public User login(String login, String passwordMd5) throws LoginException {
        User user = testDao.getUser(login);

        if (user == null) {
            throw new LoginException("Указанный пользователь не существует");
        }

        if (!user.isEnabled()) {
            throw new LoginException("Пользователь отключен");
        }

        if (!user.getPasswordMd5().equals(passwordMd5)) {
            throw new LoginException("Неверный пароль");
        }

        return user;
    }

}
