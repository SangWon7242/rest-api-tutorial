package com.backend.global.rsData;

import com.backend.domain.post.postComment.dto.PostCommentDto;

public record RsData(String resultCode, String msg, PostCommentDto data) {
}
