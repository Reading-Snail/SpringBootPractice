package com.example.springbootpractice.controller;

import com.example.springbootpractice.model.UserVO;
import com.example.springbootpractice.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
@RestController
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);
    @Autowired
    UserService userService;
    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }
    @PostMapping("/login")
    public void loginAction(UserVO userVO) {
        logger.info(userVO.toString());
    }
    @GetMapping("/register")
    public ModelAndView register(){
        ModelAndView mav = new ModelAndView("register");
        return mav;
    }
    @PostMapping("/register")
    public String registerAction(UserVO userVO) {
        logger.info(userVO.toString());
        userService.regster(userVO);
        return "login";
    }
    @GetMapping("/index2")
    public ModelAndView index2(){
        ModelAndView mav = new ModelAndView("index2");
        return mav;
    }
}
