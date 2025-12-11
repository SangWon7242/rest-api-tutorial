package com.backend.global.rsData;

import com.backend.domain.post.post.dto.PostDto;

public record ForPostRsData(String resultCode, String msg, PostDto data) {
}
