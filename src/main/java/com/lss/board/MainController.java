package com.lss.board;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {
    @GetMapping("/jump")
    @ResponseBody
    public String printSpring() {
        return "점프 투 스프링 부트";
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/member/login";
    }
}
