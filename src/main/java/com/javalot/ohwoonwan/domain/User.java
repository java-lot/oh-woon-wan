package com.javalot.ohwoonwan.domain;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.ColumnDefault;


@Entity // This tells Hibernate to make a table out of this class
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Getter
@ToString
@Setter
@Table(name = "user")
public class User extends TimestampEntity {
    @Builder
    public User(String name, String nickName, String phone, String password, String email, Boolean gender, Boolean isAdmin) {
        super();
        this.name = name;
        this.nickName = nickName;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.isAdmin = isAdmin;
    }
    public User() {}

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Setter(AccessLevel.PROTECTED)
    private Integer id;

    @Column(length = 50, nullable = false)
    private  String name;

    @Column(name="`nick_name`", length = 50, unique = true)
    private String nickName;

    @Column(length = 50, nullable = false, unique = true)
    private String phone;

    @Column(nullable = false)
    private String password;

    @Column(length = 50, nullable = false, unique = true)
    private String email;

    @Column(nullable = false, columnDefinition = "TINYINT", length = 1)
    private Boolean gender;

    @Column(name="`is_admin`", columnDefinition = "TINYINT", length = 1)
    @ColumnDefault("false")  // ColumnDefault: create 문에서 default 값을 정해줍니다
    private Boolean isAdmin;

    @Column(name="`is_blocked`", columnDefinition = "TINYINT", length = 1)
    @ColumnDefault("false")
    private Boolean isBlocked;

    public enum BlockReason {
        ABUSE,
        ADVERTISING
    }
    @Column(name="`block_reason`", columnDefinition = "ENUM('ABUSE','ADVERTISING')")
    @Enumerated(EnumType.STRING)
    @ColumnDefault("null")
    private BlockReason blockReason;

    @Column(name="`is_deleted`", columnDefinition = "TINYINT", length = 1)
    @ColumnDefault("false")
    private Boolean isDeleted;
}