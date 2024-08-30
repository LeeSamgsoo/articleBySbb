package com.lss.board.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@Controller
@RequiredArgsConstructor
@RequestMapping("/member")
public class MemberController {
    private final MemberService memberService;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("wrong", "notWrong");
        return "member_login";
    }

    @PostMapping("/check")
    public String check(Model model, @RequestParam(value = "username") String id,
                        @RequestParam(value = "password") String pw) {
        Member member = this.memberService.check(id, pw);
        if (member == null) {
            model.addAttribute("wrong", "wrong");
            return "member_login";
        } else {
            model.addAttribute("member", member);
            return "member_page";
        }
    }
}
