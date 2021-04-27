package com.example.book.springboot.service.posts;

import java.util.*;
import com.example.book.springboot.domain.posts.Posts;
import com.example.book.springboot.domain.posts.PostsRepository;
import com.example.book.springboot.web.dto.PostsListResponseDto;
import com.example.book.springboot.web.dto.PostsResponseDto;
import com.example.book.springboot.web.dto.PostsSaveRequestDto;
import com.example.book.springboot.web.dto.PostsUpdateRequestDto;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.stream.*;

@RequiredArgsConstructor
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    public Long save(PostsSaveRequestDto requestDto) {
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getTitle(),requestDto.getContent());

        return id;
    }
    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id ));
        return new PostsResponseDto(entity);
    }
    @Transactional(readOnly = true)
    public List<PostsListResponseDto> findAllDesc() {
        return postsRepository.findAllDesc().stream()
                // Posts의 Stream을 Map을 통해 PostsListResponseDto 변환 -> List로 변환하는 메소드
                .map(PostsListResponseDto::new)
                .collect(Collectors.toList());
    }
    @Transactional
    public void delete(Long id){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new
                        IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
                postsRepository.delete(posts);
    }
}
