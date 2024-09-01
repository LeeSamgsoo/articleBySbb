package com.lss.board.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member check(String userId, String password) {
        Optional<Member> optionalMember = this.memberRepository.findByUserIdAndPassword(userId, password);
        return optionalMember.orElse(null);
    }

    public Member create(String userId, String password) {
        Optional<Member> optionalMember = this.memberRepository.findByUserId(userId);
        if (!optionalMember.isPresent()) {
           Member member = new Member();
           member.setUserId(userId);
           member.setPassword(password);
           member.setRegDate(LocalDateTime.now());
           this.memberRepository.save(member);
           return member;
        }
        return null;
    }
}
