package com.javalot.ohwoonwan.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
public class Post extends TimestampEntity {
    public Post(String category, String title, String content, User creator) {
        super();
        this.category = category;
        this.title = title;
        this.content = content;
        this.createdBy = creator;
    }
    public Post() {}

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Integer id;

    private String category;
    private String title;
    private String content;
    private Integer view;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "created_by", referencedColumnName = "id")
    private User createdBy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "updated_by", referencedColumnName = "id")
    private User updatedBy;
}
