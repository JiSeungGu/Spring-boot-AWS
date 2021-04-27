package com.example.book.springboot.web;

import com.example.book.springboot.domain.posts.Posts;
import com.example.book.springboot.service.posts.CommentsService;
import com.example.book.springboot.service.posts.PostsService;
import com.example.book.springboot.web.dto.CommentsSaveRequestDto;
import com.example.book.springboot.web.dto.PostsResponseDto;
import com.example.book.springboot.web.dto.PostsSaveRequestDto;
import com.example.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    private final PostsService postsService;
    private final CommentsService CommentsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto){
        System.out.println("이건 나오나 "+requestDto.getTitle());
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        System.out.println(requestDto.getContent());
        return postsService.update(id,requestDto);
    }
    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById (@PathVariable Long id){
        return postsService.findById(id);
    }

    @DeleteMapping("/api/v1/posts/{id}")
    public Long delete(@PathVariable Long id){
        postsService.delete(id);
        return id;
    }

    @PostMapping("/api/v1/commentSave")
    public Long CommentSave(@PathVariable Long com_post_id, @RequestBody CommentsSaveRequestDto commentDto){
        System.out.println("나오는지 test :"+commentDto.getCom_content());
        System.out.println("나오는지 test :"+commentDto.getCom_post_id());
        return CommentsService.save(commentDto);
    }
}
