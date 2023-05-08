package com.javalot.ohwoonwan.domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@ToString
@Table(name = "post")
public class Post extends TimestampEntity {
    @PrePersist
    public void prePersist(){
        this.view = this.view == null ? 0 : this.view;
    }

    @Builder
    public Post(String category, String title, String content, User creator) {
        this.category = category;
        this.title = title;
        this.content = content;
        this.createdBy = creator;
    }

    public void update(String category, String title, String content) {
        this.category = category;
        this.title = title;
        this.content = content;
    }

    public void addView() {
        this.view++;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.PROTECTED)
    private Long id;

    private String category;
    private String title;
    private String content;
    private Integer view;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`created_by`", referencedColumnName = "id")
    private User createdBy;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "`updated_by`", referencedColumnName = "id")
    private User updatedBy;
}
