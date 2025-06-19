package com.example.boot.controller;

import com.example.boot.svc.UserSvc;
import com.example.boot.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ExController {
    @Autowired
    UserSvc svc;

    @GetMapping({"/", "/index"}) // 클라이언트가 url요청한 주소
        public String index(){
            /* 스프링 부트의 viewResolver가 가지고 있는 것
            *  prefix : 프로젝트명(애플리케이션명) "boot/src/main/resources/templates/"
            *  suffix : ".html"
            *  "boot/src/main/resources/templates/" + "index" + ".html"
            * */
            return "index"; // 클라이언트에게 보내줄 페이지 주소
    }
    //회원가입 폼 페이지 열기
    @GetMapping("/joinform")
        public String joinform(){
        return "joinform";
    }

    //회원가입 데이터베이스에 넣기
    @PostMapping("/joinform") // 동일한 메소드 방식의 동일한 url패턴이 2개 이상 존재하면 안됨.
        public String joinform(User user){
        System.out.println(user);
        svc.joinUs(user);
        return "joinresult";
    }

    //회원 전체 목록 보기
    @GetMapping("/userList")
    public String userList(Model model){
        List<User> list = svc.userList();
        for(User user:list){
            System.out.println(user);
        }
        // model객체는 request객체이다.
        // 형식 : model.addAttribute("속성명(키명)", 속성값);
        model.addAttribute("userList",list);
        return "userlist";
    }
}
