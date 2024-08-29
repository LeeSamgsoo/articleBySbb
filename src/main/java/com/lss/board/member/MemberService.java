package com.lss.board.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public Member check(String userId, String password) {
        return this.memberRepository.findByUserIdAndPassword(userId, password);
    }
}
