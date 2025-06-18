package com.example.boot.mapper;

import com.example.boot.vo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User userList();
    int joinUser(User user);
}
