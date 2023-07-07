package com.example.springbootpractice.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
@ToString
public class UserVO {
    private String userName;
    private String password;

    public UserVO(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public static UserVO createUser(String userName, String password, PasswordEncoder passwordEncoder) {
        return new UserVO(userName, passwordEncoder.encode(password));
    }
}
