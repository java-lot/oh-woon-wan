package com.javalot.ohwoonwan.dto;

import com.javalot.ohwoonwan.domain.Post;
import com.javalot.ohwoonwan.domain.User;
import lombok.Getter;

@Getter
public class PostResponseDto {

    private Long id;
    private String category;
    private String title;
    private String content;
    private Integer view;
    private User created_by;

    public PostResponseDto(Post entity) {
        this.id = entity.getId();
        this.category = entity.getCategory();
        this.title = entity.getTitle();
        this.content = entity.getContent();
        this.view = entity.getView();
        this.created_by = entity.getCreatedBy();
    }
}
