package com.example.boot.mapper;

import com.example.boot.vo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    // 회원 전체 목록 조회
    User userList();
    //회원 가입
    int joinUser(User user);
    //회원 정보 수정
    int userUpdate(User user);
    //회원 탈퇴
    int userDelete(String uid);
    //회원 일부 목록 죄회
    User userSelList(User user);
    //나의 정보 보기
    User userOne(String user);
}
