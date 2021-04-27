package com.example.book.springboot.web.dto;

import com.example.book.springboot.domain.posts.Comment;
import com.example.book.springboot.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CommentsSaveRequestDto {
    private String com_content;
    private String com_writer;
    private Long com_post_id;

    @Builder
    public CommentsSaveRequestDto(String com_content,String com_writer,Long com_post_id) {
        this.com_content = com_content;
        this.com_writer = com_writer;
        this.com_post_id = com_post_id;
    }
    public Comment toEntity() {
        return Comment.builder()
                .com_content(com_content)
                .com_writer(com_writer)
                .com_post_id(com_post_id)
                .build();
    }
}

