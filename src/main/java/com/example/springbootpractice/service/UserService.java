package com.example.springbootpractice.service;

import com.example.springbootpractice.mapper.UserMapper;
import com.example.springbootpractice.model.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    public Optional<UserVO> findOne(String insertedUserId) {
        Optional<UserVO> userVO = userMapper.findOne(insertedUserId);
        logger.info(userVO.toString());
        return userVO;
    }

    public void regster(UserVO userVO){
        logger.info("Before encryption: " + userVO.toString());
        userVO = UserVO.createUser(userVO.getUserName(), userVO.getPassword(), passwordEncoder);    //비밀번호 암호화
        logger.info("After encryption: " + userVO.toString());
        userMapper.register(userVO);                                                                //DB에 저장
    }
}
