package com.example.boot.svc;

import com.example.boot.mapper.UserMapper;
import com.example.boot.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserSvc {

    @Autowired
    UserMapper mapper;

    //회원 전체 목록 보기
    public List<User> userList(){
        return mapper.userList();
    }

    //회원 가입 관련
    public int joinUs(User user){
        return mapper.joinUser(user);
    }

    //    회원 정보 수정
    public int userUpdate(User user){
        return mapper.userUpdate(user);
    }

    //    회원 탈퇴
    public int userDelete(String uid){
        return mapper.userDelete(uid);
    }

    //    회원 일부 목록
    public List<User> userSelList(String searchStr){
        return mapper.userSelList(searchStr);
    }

    //    나의 정보 보기
    public User userOne(String uid){
        return mapper.userOne(uid);
    }

    // 로그인 정보
    public User userLogin(User user){
        return mapper.userLogin(user);
    }
}
