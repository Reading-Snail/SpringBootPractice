package com.example.springbootpractice.mapper;

import com.example.springbootpractice.model.UserVO;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.Optional;

@Mapper
public interface UserMapper {
    @Select("SELECT USER_NAME, PASSWORD FROM member WHERE USER_NAME = #{insertedUserId}")
    Optional<UserVO> findOne(String insertedUserId);

    @Insert("INSERT INTO member (USER_NAME, PASSWORD) VALUES(#{userName}, #{password})")
    void register(UserVO userVO);
}
