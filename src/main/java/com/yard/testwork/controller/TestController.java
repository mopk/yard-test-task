package com.yard.testwork.controller;

import com.yard.testwork.model.User;
import com.yard.testwork.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.security.auth.login.LoginException;

@Controller
@RequestMapping(value = "/rest/test", produces = "application/json;charset=UTF-8")
public class TestController {

    @Autowired
    TestService testService;

    @RequestMapping(value = "/ping", method = RequestMethod.GET)
    public ResponseEntity<String> Test() {
        ResponseEntity<String> ret = new ResponseEntity<String>("ok", HttpStatus.OK);

        return ret;
    }

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ResponseEntity<User> Login(@RequestParam("login") String login, @RequestParam("md5") String passWordMd2) {
        User user;
        try {
            user = testService.login(login, passWordMd2);
        } catch (LoginException e) {
            return new ResponseEntity<User>(HttpStatus.UNAUTHORIZED);
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }
}
