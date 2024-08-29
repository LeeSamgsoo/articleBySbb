package com.lss.board.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/member/login")
    public String login() {
        return "member_login";
    }

    @PostMapping("/member/check")
    public String check(Model model, @RequestParam(value = "username") String id,
                        @RequestParam(value = "password") String pw) {
        Member member = this.memberService.check(id, pw);
        model.addAttribute("username", member.getUserId());
        return "member_page";
    }
}
