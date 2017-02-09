package com.gurkan.web;

import com.gurkan.entity.User;
import com.gurkan.security.auth.JwtAuthenticationToken;
import com.gurkan.service.DatabaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gurkan.security.model.UserContext;

import java.util.Arrays;
import java.util.List;


@RestController
public class ProfileController {

    @Autowired
    public DatabaseUserService databaseUserService;

    @RequestMapping(value="/api/me", method=RequestMethod.GET)
    public @ResponseBody UserContext get(JwtAuthenticationToken token) {
        return (UserContext) token.getPrincipal();
    }

    @RequestMapping(value="/api/user", method=RequestMethod.POST)
    @ResponseBody
    public User createUser(String username, String password, Integer price, Integer weeklyWorkingHours) {
        price = (price == null) ? 0 : price;
        weeklyWorkingHours = (weeklyWorkingHours == null) ? 0 : weeklyWorkingHours;

        User user = new User(username, password, price, weeklyWorkingHours);
        return databaseUserService.getUserRepository().save(user);
    }
}
