package com.example.book.springboot.service.posts;

import com.example.book.springboot.domain.posts.CommentsRepository;
import com.example.book.springboot.web.dto.CommentsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CommentsService {

    private final CommentsRepository commentsRepository;

    public Long save(CommentsSaveRequestDto requestDto) {
        return commentsRepository.save(requestDto.toEntity()).getCom_id();
    }
}
