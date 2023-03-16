package com.javalot.ohwoonwan.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostUpdateRequestDto {
    private String category;
    private String title;
    private String content;

    @Builder
    public PostUpdateRequestDto(String category, String title, String content) {
        this.category = category;
        this.title = title;
        this.content = content;
    }
}
