package com.app.candm.controller.member;

import com.app.candm.dto.member.MemberDTO;
import com.app.candm.service.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@RequestMapping("/member/**")
@RequiredArgsConstructor
public class MemberJoinController {
    private final MemberService memberService;

//    회원가입 페이지 이동
    @GetMapping("join")
    public String goToJoinForm(){
        return "member/join";
    }
//    회원가입
    @PostMapping("join")
    public RedirectView join(MemberDTO memberDTO){
        memberService.join(memberDTO);
        return new RedirectView("/member/login");
    }
}
