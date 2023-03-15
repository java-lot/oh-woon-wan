package com.javalot.ohwoonwan.service;

import com.javalot.ohwoonwan.dto.PostListResponseDto;
import com.javalot.ohwoonwan.dto.PostResponseDto;

import java.util.List;


public interface PostService {
    public PostResponseDto findById(Long id);
    public List<PostListResponseDto> findAllDesc();

}
