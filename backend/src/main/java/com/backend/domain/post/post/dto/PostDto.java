package com.backend.domain.post.post.dto;

import com.backend.domain.post.post.entity.Post;

import java.time.LocalDateTime;

public record PostDto(
    long id,
    LocalDateTime createdDate,
    LocalDateTime modifyedDate,
    String subject,
    String content
) {

  public PostDto(Post post) {
    this(
        post.getId(),
        post.getCreateDate(),
        post.getModifyDate(),
        post.getTitle(),
        post.getContent()
    );
  }
}