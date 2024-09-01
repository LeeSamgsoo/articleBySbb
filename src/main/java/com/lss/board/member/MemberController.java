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
    public String login() {
        return "member_login";
    }

    @PostMapping("/check")
    public String check(Model model, @RequestParam(value = "username") String id,
                        @RequestParam(value = "password") String pw) {
        Member member = this.memberService.check(id, pw);
        if (member == null) {
            model.addAttribute("loginError", "로그인에 실패했습니다. 아이디와 비밀번호를 확인하세요.");
            return "member_login";
        } else {
            model.addAttribute("member", member);
            return "member_page";
        }
    }

    @RequestMapping("/signup")
    public String signup() {
        return "member_signup";
    }

    @PostMapping("/create")
    public String create(@RequestParam(value = "username") String username,
                         @RequestParam(value = "password") String password,
                         @RequestParam(value = "confirm-password") String cPassword,
                         Model model) {
        if (!password.equals(cPassword)) {
            model.addAttribute("signupError", "비밀번호가 일치하지 않습니다.");
            return "member_signup";
        }
        Member member = this.memberService.create(username, password);
        if(member == null) {
            model.addAttribute("signupError", "이미 존재하는 아이디 입니다.");
            return "member_signup";
        } else {
            model.addAttribute("signupError", "회원가입이 완료되었습니다.");
            return "redirect:/member/login";
        }
    }

}
