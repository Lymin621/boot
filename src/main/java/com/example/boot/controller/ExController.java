package com.example.boot.controller;

import com.example.boot.vo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ExController {
    @GetMapping({"/", "/index"}) // 클라이언트가 url요청한 주소
        public String index(){
            /* 스프링 부트의 viewResolver가 가지고 있는 것
            *  prefix : 프로젝트명(애플리케이션명) "boot/src/main/resources/templates/"
            *  suffix : ".html"
            *  "boot/src/main/resources/templates/" + "index" + ".html"
            * */
            return "index"; // 클라이언트에게 보내줄 페이지 주소
    }
    @GetMapping("/joinform")
        public String joinform(){
        return "joinform";
    }
    @PostMapping("/joinform") // 동일한 메소드 방식의 동일한 url패턴이 2개 이상 존재하면 안됨.
        public String joinform(User user){
        System.out.println(user);
        return "joinresult";
    }
}
