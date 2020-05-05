package com.glc.loginregister.controller;


import com.glc.loginregister.entity.Result;
import com.glc.loginregister.entity.User;
import com.glc.loginregister.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 注册
     * @param user
     * @return
     */
    @PostMapping("/register")
    public Result register(@RequestBody User user){
        return userService.rgister(user);
    }

    @PostMapping("/login")
    public Result login(@RequestBody User user){
        return userService.login(user);
    }



}
