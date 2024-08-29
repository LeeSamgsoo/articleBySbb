package com.lss.board.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemberController {
    @GetMapping("/member/login")
    @ResponseBody
    public String login() {
        return "login";
    }
}
