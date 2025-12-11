package com.backend.domain.post.post.controller;

import com.backend.domain.post.post.dto.PostDto;
import com.backend.domain.post.post.entity.Post;
import com.backend.domain.post.post.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class ApiV1PostController {
  private final PostService postService;

  @GetMapping
  @Transactional(readOnly = true)
  public List<PostDto> getItems() {
    List<Post> items = postService.findAll();

    return items
        .stream()
        .map(PostDto::new) // PostDto로 변환
        .toList();
  }

  @GetMapping("/{id}")
  @Transactional(readOnly = true)
  public PostDto getItem(@PathVariable Long id) {
    Post post = postService.findById(id).get();

    return new PostDto(post);
  }

  @GetMapping("/{id}/delete")
  @Transactional
  public PostDto delete(@PathVariable Long id) {
    Post post = postService.findById(id).get();

    postService.delete(post);

    return new PostDto(post);
  }
}
