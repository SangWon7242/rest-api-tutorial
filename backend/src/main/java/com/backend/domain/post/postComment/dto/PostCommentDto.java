package com.backend.domain.post.postComment.dto;

import com.backend.domain.post.postComment.entity.PostComment;

import java.time.LocalDateTime;

public record PostCommentDto(
    long id,
    LocalDateTime createdDate,
    LocalDateTime modifyDate,
    String content
) {
  public PostCommentDto(PostComment postComment) {
    this(
        postComment.getId(),
        postComment.getCreateDate(),
        postComment.getModifyDate(),
        postComment.getContent()
    );
  }
}
