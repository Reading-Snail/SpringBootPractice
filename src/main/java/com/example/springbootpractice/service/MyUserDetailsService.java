package com.example.springbootpractice.service;

import com.example.springbootpractice.model.UserVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class MyUserDetailsService implements UserDetailsService {

    private static final Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);

    private final UserService userService;

    public MyUserDetailsService(UserService userService) {
        this.userService = userService;
    }


    /*
    loadUserByUsername를 오버라이드해서 구현해주면 됩니다.
    파라미터인 insertedId 부분에는 기존에 설정해두었던 usernameParameter("userid")에 해당하는 정보가 들어오게 됩니다.
    비밀번호가 동일한지 체크는 스프링부트에서 알아서 진행하게 되므로 아이디만 가지고 DB에서 유저 정보를 가져오시면 됩니다.
     */
    @Override
    public UserDetails loadUserByUsername(String insertedUserId) throws UsernameNotFoundException {
        logger.info("insertedUserId: " + insertedUserId);
        Optional<UserVO> findOne = userService.findOne(insertedUserId);                                                 // DB에서 회원정보 불러옴
        UserVO member = findOne.orElseThrow(() -> new UsernameNotFoundException("없는 회원입니다 ㅠ"));                    // 없을 경우 예외출력

        return User.builder()
                .username(member.getUserName())
                .password(member.getPassword())
                //.roles(member.getRoles())
                .build();
    }
}