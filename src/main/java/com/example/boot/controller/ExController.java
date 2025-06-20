package com.example.boot.controller;

import com.example.boot.svc.UserSvc;
import com.example.boot.vo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class ExController {
    @Autowired
    UserSvc svc;

    @GetMapping({"/", "/index"}) // 클라이언트가 url요청한 주소
    public String index() {
        /* 스프링 부트의 viewResolver가 가지고 있는 것
         *  prefix : 프로젝트명(애플리케이션명) "boot/src/main/resources/templates/"
         *  suffix : ".html"
         *  "boot/src/main/resources/templates/" + "index" + ".html"
         * */
        return "index"; // 클라이언트에게 보내줄 페이지 주소
    }

    //회원가입 폼 페이지 열기
    @GetMapping("/joinform")
    public String joinform() {
        return "joinform";
    }

    //회원가입 데이터베이스에 넣기
    @PostMapping("/joinform") // 동일한 메소드 방식의 동일한 url패턴이 2개 이상 존재하면 안됨.
    public String joinform(User user) {
        System.out.println(user);
        svc.joinUs(user);
        return "joinresult";
    }

    //회원 전체 목록 보기
    @GetMapping("/userList")
    public String userList(Model model, HttpSession session) {
        String logid = (String) session.getAttribute("loginid");
        if (logid != null) {
            List<User> list = svc.userList();

            for (User user : list) {
                System.out.println(user);
            }
            // model객체는 request객체이다.
            // 형식 : model.addAttribute("속성명(키명)", 속성값);
            model.addAttribute("userList", list);
            return "userlist";
        } else {
            return "login";
        }
    }

    //로그인 창
    @RequestMapping(value = "/userlogin", method = RequestMethod.GET)
    public String userlogin() {
        return "login";
    }

    @RequestMapping(value = "/userlogin", method = RequestMethod.POST)
    public String userlogin(User user, HttpSession session) {
        System.out.println("로그인의 user: " + user);
        User vo = svc.userLogin(user);
        if (vo != null) {
            System.out.println("로그인 성공");
            session.setAttribute("loginid", user.getUid());
            return "index";
        } else {
            System.out.println("로그인 실패");
            return "login";
        }

    }

    //로그아웃 처리하기
    @GetMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("로그아웃 성공");
        session.invalidate();
        return "index";
    }

    @GetMapping("/userdelete")
    public String userDeleteForm() {
        return "userdelete";
    }

    @PostMapping("/userDelete")
    public String userDelete(HttpServletRequest request) {
        String uid = (String) request.getSession().getAttribute("loginid");
        svc.userDelete(uid);
        request.getSession().invalidate();
        return "index";
    }

    //회원정보 수정 폼 - 데이터 담아가기
    @GetMapping("/userUpdate")
    public String userUpdate(HttpSession session, Model model){
        String uid = (String) session.getAttribute("loginid");
        model.addAttribute("user", svc.userOne(uid));
        return "userupdate";
    }

    // 회원정보 수정하기
    @PostMapping("/userUpdate")
    public String userUpdate(HttpSession session, User user){
        user.setUid((String) session.getAttribute("loginid"));
        System.out.println(user);
//        svc.userUpdate(user);
        return "redirect:/userUpdate";
    }

}
