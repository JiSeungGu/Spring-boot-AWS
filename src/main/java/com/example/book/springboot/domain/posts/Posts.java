package com.example.book.springboot.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Posts {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //GeneratedValue
    // -> PK의 생성 규칙 표시   GenerationType.IDENTITY 를 사용해야지만 Auto_Increment 설정
    private Long id;

    @Column(length=500, nullable = false)
    private String title;

    // @Column 을 굳이 선언하지 않더라도 해당 클래스의 필드는 모두 칼럼으로 표시
    // 사용하는 이유, 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용
    //  -> 사이즈를 늘리고싶거나 타입을 변경하고 싶을때
    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title,String content,String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title,String content){
        this.title = title;
        this.content = content;
    }
}
