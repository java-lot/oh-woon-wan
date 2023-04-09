package com.javalot.ohwoonwan.dto;

import com.javalot.ohwoonwan.domain.Post;
import com.javalot.ohwoonwan.domain.User;
import com.javalot.ohwoonwan.repository.PostRepository;
import com.javalot.ohwoonwan.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class PostCreateRequestDto {

    private String category;
    private String title;
    private String content;
    private Integer creatorId;

    public Post toPost(User user) {
        User creator = user;
        return new Post(category, title, content, creator);
    }
}
