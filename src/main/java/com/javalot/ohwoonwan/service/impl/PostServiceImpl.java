package com.javalot.ohwoonwan.service.impl;

import com.javalot.ohwoonwan.domain.Post;
import com.javalot.ohwoonwan.dto.PostListResponseDto;
import com.javalot.ohwoonwan.dto.PostResponseDto;
import com.javalot.ohwoonwan.repository.PostRepository;
import com.javalot.ohwoonwan.service.PostService;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    @Transactional(readOnly = true)
    public PostResponseDto findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("Not found post id = " + id));
        return new PostResponseDto(post);
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAllDesc() {
        return postRepository.findAllByOrderByIdDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

}