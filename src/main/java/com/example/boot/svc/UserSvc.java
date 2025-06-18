package com.example.boot.svc;

import com.example.boot.mapper.UserMapper;
import com.example.boot.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSvc {

    @Autowired
    UserMapper mapper;

    public int joinUs(User user){
        return mapper.joinUser(user);
    }
}
