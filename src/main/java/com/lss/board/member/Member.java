package com.lss.board.member;

import com.lss.board.article.Article;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, length = 100)
    private String userId;

    @Column(length = 100)
    private String password;

    @Column
    private LocalDateTime regDate;

    @Column
    @OneToMany(mappedBy = "article", cascade = CascadeType.REMOVE)
    private List<Article> articles;
}
