package com.javalot.ohwoonwan.service.impl;

import com.javalot.ohwoonwan.domain.Post;
import com.javalot.ohwoonwan.domain.User;
import com.javalot.ohwoonwan.dto.PostCreateRequestDto;
import com.javalot.ohwoonwan.dto.PostListResponseDto;
import com.javalot.ohwoonwan.dto.PostResponseDto;
import com.javalot.ohwoonwan.dto.PostUpdateRequestDto;
import com.javalot.ohwoonwan.repository.PostRepository;
import com.javalot.ohwoonwan.repository.UserRepository;
import com.javalot.ohwoonwan.service.PostService;
import jakarta.validation.constraints.NotNull;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Transactional
    public PostResponseDto findById(Long id) {
        Post post = postRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("Not found post id = " + id));
        increaseView(post);
        return new PostResponseDto(post);
    }

    private void increaseView(@NotNull Post post) {
        post.addView();
    }

    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAllDesc() {
        return postRepository.findAllByOrderByIdDesc().stream()
                .map(PostListResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional
    public Object create(PostCreateRequestDto requestDto) {
        User user = getUser(requestDto.getCreatorId());
        postRepository.save(requestDto.toPost(user));
        return null;
    }

    private User getUser(Integer creatorId) {
        return userRepository.findById(creatorId)
                .orElseThrow(() -> new IllegalArgumentException("Not found creator id = " + creatorId));
    }

    @Transactional
    public Object delete(Long id) {
        Post post = postRepository.findById(id).orElseThrow
                (() -> new IllegalArgumentException("Not found post id = " + id));
        postRepository.delete(post);
        return null;
    }

    @Transactional
    public Object update(Long id, PostUpdateRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("Not found post id = " + id));

        post.update(requestDto.getCategory(),
                requestDto.getTitle(),
                requestDto.getContent());
        return id;
    }

}