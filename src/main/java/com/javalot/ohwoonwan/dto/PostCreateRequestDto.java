package com.javalot.ohwoonwan.dto;

import com.javalot.ohwoonwan.domain.Post;
import com.javalot.ohwoonwan.domain.User;
import com.javalot.ohwoonwan.repository.PostRepository;
import com.javalot.ohwoonwan.repository.UserRepository;
import lombok.Builder;
import lombok.Getter;

import java.util.Optional;

@Getter
public class PostCreateRequestDto {

    private String category;
    private String title;
    private String content;
    private Integer creatorId;
    private UserRepository userRepository;

    public Post toEntity() {
        Optional<User> creator = this.userRepository.findById(this.creatorId);
        return Post.builder()
                .category(this.category)
                .title(this.title)
                .content(this.content)
                .creator(creator.get())
                .build();
    }
}
