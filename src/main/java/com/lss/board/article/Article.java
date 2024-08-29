package com.lss.board.article;

import com.lss.board.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 100)
    private String title;

    @Column(columnDefinition = "text")
    private String content;

    @Column
    @ManyToOne
    private Member member;

    @Column
    private LocalDateTime regDate;
}
