package com.example.book.springboot.domain.posts;

import com.example.book.springboot.domain.BaseTimeEntity;
import lombok.*;
import javax.persistence.*;

@Table(name="COMMENT")
@EqualsAndHashCode(of="COMMENT_NO")
@Getter
@Setter
@ToString(exclude="post")
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment extends BaseTimeEntity {

    @Id
    @GeneratedValue
    @Column(name = "comment_id")
    private Long com_id;

    private String com_content;
    private String com_writer;

    private Long com_post_id;

    @Builder
    public Comment(String com_content,String com_writer,Long com_post_id){
        this.com_content = com_content;
        this.com_writer = com_writer;
        this.com_post_id = com_post_id;
    }
}
