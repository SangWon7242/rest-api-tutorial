package com.backend.domain.post.postComment.controller;

import com.backend.domain.post.post.entity.Post;
import com.backend.domain.post.post.service.PostService;
import com.backend.domain.post.postComment.dto.PostCommentDto;
import com.backend.domain.post.postComment.entity.PostComment;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts/{postId}/comments")
@RequiredArgsConstructor
public class ApiV1PostCommentController {
  private final PostService postService;

  @GetMapping
  @Transactional(readOnly = true)
  public List<PostCommentDto> getItems(@PathVariable long postId) {
    Post post = postService.findById(postId).get();

    return post.getComments()
        .stream()
        .map(PostCommentDto::new)
        .toList();
  }

  @GetMapping("/{id}")
  @Transactional(readOnly = true)
  public  PostCommentDto getItem(@PathVariable long postId, @PathVariable long id) {
    Post post = postService.findById(postId).get();
    PostComment postComment = post.findCommentById(id).get();

    return new PostCommentDto(postComment);
  }

  @GetMapping("/{id}/delete")
  @Transactional(readOnly = true)
  public String delete(@PathVariable long postId, @PathVariable long id) {
    Post post = postService.findById(postId).get();

    PostComment postComment = post.findCommentById(id).get();

    postService.deleteComment(post, postComment);

    return "%d번 댓글이 삭제되었습니다.".formatted(id);
  }
}
