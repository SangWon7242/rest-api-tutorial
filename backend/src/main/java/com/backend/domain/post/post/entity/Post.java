package com.backend.domain.post.post.entity;

import com.backend.domain.post.postComment.entity.PostComment;
import com.backend.global.jpa.entity.BaseEntity;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static jakarta.persistence.CascadeType.PERSIST;
import static jakarta.persistence.CascadeType.REMOVE;
import static jakarta.persistence.FetchType.LAZY;

@Entity
@Getter
@NoArgsConstructor
public class Post extends BaseEntity {
  private String subject;
  private String content;

  // orphanRemoval : 자식 엔티티가 삭제되면 부모 엔티티에서도 자식 엔티티를 제거
  @OneToMany(mappedBy = "post", fetch = LAZY, cascade = {PERSIST, REMOVE}, orphanRemoval = true)
  private List<PostComment> comments = new ArrayList<>();

  public Post(String subject, String content) {
    this.subject = subject;
    this.content = content;
  }

  public void modify(String title, String content) {
    this.title = title;
    this.content = content;
  }

  public PostComment addComment(String content) {
    PostComment postComment = new PostComment(this, content);
    comments.add(postComment);

    return postComment;
  }

  public Optional<PostComment> findCommentById(long id) {
    return comments
        .stream()
        .filter(comment -> comment.getId() == id)
        .findFirst();
  }

  public boolean deleteComment(PostComment postComment) {
    if(postComment == null) return false;

    return comments.remove(postComment);
  }
}
