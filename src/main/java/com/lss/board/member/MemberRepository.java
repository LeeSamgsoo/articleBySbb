package com.lss.board.member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    Optional<Member> findByUserIdAndPassword(String userId, String password);
    Optional<Member> findByUserId(String  userId);
}
