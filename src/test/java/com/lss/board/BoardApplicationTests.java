package com.lss.board;

import com.lss.board.member.Member;
import com.lss.board.member.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
class BoardApplicationTests {
	@Autowired
	private MemberRepository memberRepository;

	@Test
	void contextLoads() {
		Member member1 = new Member();
		member1.setUserId("test");
		member1.setPassword("test");
		member1.setRegDate(LocalDateTime.now());
		this.memberRepository.save(member1);
	}

}
