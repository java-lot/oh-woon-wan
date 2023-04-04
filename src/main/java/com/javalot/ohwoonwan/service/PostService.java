package com.javalot.ohwoonwan.service;

import com.javalot.ohwoonwan.dto.PostCreateRequestDto;
import com.javalot.ohwoonwan.dto.PostListResponseDto;
import com.javalot.ohwoonwan.dto.PostResponseDto;
import com.javalot.ohwoonwan.dto.PostUpdateRequestDto;

import java.util.List;


public interface PostService {
    public PostResponseDto findById(Long id);
    public List<PostListResponseDto> findAllDesc();
    public Long create(PostCreateRequestDto requestDto);
    public Object delete(Long id);
    public Object update(Long id, PostUpdateRequestDto requestDto);

}
