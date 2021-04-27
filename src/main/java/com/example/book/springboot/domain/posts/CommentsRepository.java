package com.example.book.springboot.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.*;

public interface CommentsRepository extends CrudRepository<Comment,Long> {
    @Query("Select c from Comment c where c.com_post_id=:postNo and c.com_id>0 order by c.com_id ASC ")
    public List<Comment> getCommentsOfPost(@Param("postNo") Long postNo);
}
