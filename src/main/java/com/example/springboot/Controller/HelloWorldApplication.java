package com.example.springboot.Controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class HelloWorldApplication {

    @GetMapping("/")
    ModelAndView home() {
        ModelAndView mav = new ModelAndView("helloworld");
        return mav;
    }

    @GetMapping("/login")
    ModelAndView login() {
        ModelAndView mav = new ModelAndView("login");
        return mav;
    }

    @PostMapping("/login/log")
    ModelAndView loginLog(){
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @PostMapping("/login/reg")
    ModelAndView loginReg(){
        ModelAndView mav = new ModelAndView("redirect:login");
        return mav;
    }


    public static void main(String[] args) {
        SpringApplication.run(HelloWorldApplication.class, args);
    }

}