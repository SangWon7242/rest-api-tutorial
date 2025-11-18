package com.backend.domain.post.post.dto;

import com.backend.domain.post.post.entity.Post;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class PostDto {
  private Long id;
  private LocalDateTime createDate;
  private LocalDateTime modifyDate;
  private String title;
  private String content;

  public PostDto(Post post) {
    this.id = post.getId();
    this.createDate = post.getCreateDate();
    this.modifyDate = post.getModifyDate();
    this.title = post.getTitle();
    this.content = post.getContent();
  }
}
