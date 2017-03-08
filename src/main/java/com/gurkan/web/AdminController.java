package com.gurkan.web;

import com.gurkan.entity.User;
import com.gurkan.security.auth.JwtAuthenticationToken;
import com.gurkan.service.DatabaseUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gurkan.security.model.UserContext;



@RestController
@RequestMapping("/api/v1")
public class AdminController {

    @Autowired
    public DatabaseUserService databaseUserService;

    /*
    *   description : Get Token Principal
    *   method      : GET
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/me", method=RequestMethod.GET)
    @ResponseBody
    public UserContext get(JwtAuthenticationToken token) {
        return (UserContext) token.getPrincipal();
    }

    /*
    *   description : Create User
    *   method      : POST
    *   required    : String username
    *                 String password
    *   optional    : Integer price
    *                 Integer weeklyWorkingHours
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/user", method=RequestMethod.POST)
    @ResponseBody
    public User createUser(String username, String password, Integer price, Integer weeklyWorkingHours) {
        price = (price == null) ? 0 : price;
        weeklyWorkingHours = (weeklyWorkingHours == null) ? 0 : weeklyWorkingHours;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        password = bCryptPasswordEncoder.encode(password);
        User user = new User(username, password, price, weeklyWorkingHours);
        return databaseUserService.getUserRepository().save(user);
    }

    /*
    *   description : Update User
    *   method      : PUT
    *   required    : String username
    *   optional    : String password
    *                 Integer price
    *                 Integer weeklyWorkingHours
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/user", method=RequestMethod.PUT)
    @ResponseBody
    public User updateUser(String username, String password, Integer price, Integer weeklyWorkingHours) {
        User user = getUser(username);
        if (user == null)
            return user;
        price = (price == null) ? user.getPrice() : price;
        weeklyWorkingHours = (weeklyWorkingHours == null) ? user.getWeeklyWorkingHours() : weeklyWorkingHours;
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        password = (password == null) ? user.getPassword() : bCryptPasswordEncoder.encode(password);

        user.setPrice(price);
        user.setWeeklyWorkingHours(weeklyWorkingHours);

        return databaseUserService.getUserRepository().save(user);
    }

    /*
    *   description : Get User
    *   method      : GET
    *   required    : String username
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/user", method=RequestMethod.GET)
    @ResponseBody
    public User getUser(String username) {
        return databaseUserService.getUserRepository().findByUsername(username).orElse(new User());
    }


    /*
    *   description : Delete User
    *   method      : DELETE
    *   required    : String username
    *
    *   @Author Gurkan CAKIR
    *
    * */
    @RequestMapping(value="/user", method=RequestMethod.DELETE)
    @ResponseBody
    public User deleteUser(String username) {
        User user =  databaseUserService.getUserRepository().findByUsername(username).orElse(new User());
        if (user.getId() != null)
            databaseUserService.getUserRepository().delete(user);
        return user;
    }

}
