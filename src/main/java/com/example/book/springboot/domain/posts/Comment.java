package com.example.book.springboot.domain.posts;

import javax.persistence.*;

@Entity
public class Comment {

    @Id @GeneratedValue
    @Column(name = "comment_id")
    private Long Id;

    private String title;
    private String content;

    private String writer;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Posts post;

}
