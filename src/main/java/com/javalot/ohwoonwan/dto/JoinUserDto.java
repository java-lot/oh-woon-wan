package com.javalot.ohwoonwan.dto;

import com.javalot.ohwoonwan.domain.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author hazel
 */

@Getter
@Setter
@NoArgsConstructor
public class JoinUserDto {
    private String name;
    private String nickName;
    private String email;
    private String password;
    private Boolean gender;
    private String phone;


    //dto -> entity
    public User toEntity(JoinUserDto userDto) {
        return User.builder().
                name(userDto.name).
                nickName(userDto.nickName).
                email(userDto.email).
                password(userDto.password).
                gender(userDto.gender).
                phone(userDto.phone).
                build();
    }

}
