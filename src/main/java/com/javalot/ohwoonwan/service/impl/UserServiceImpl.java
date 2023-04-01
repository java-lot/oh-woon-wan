package com.javalot.ohwoonwan.service.impl;

import com.javalot.ohwoonwan.domain.User;
import com.javalot.ohwoonwan.dto.JoinUserDto;
import com.javalot.ohwoonwan.exception.BadRequestException;
import com.javalot.ohwoonwan.repository.UserRepository;
import com.javalot.ohwoonwan.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * @author hazel
 */


@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Boolean addUser(JoinUserDto joinUserDto) {

        String bcyptedPassword = BCrypt.hashpw(joinUserDto.getPassword(), BCrypt.gensalt());

        User saveUser = User.builder().
                password(bcyptedPassword).
                name(joinUserDto.getName()).
                nickName(joinUserDto.getNickName()).
                email(joinUserDto.getEmail()).
                gender(joinUserDto.getGender()).
                phone(joinUserDto.getPhone()).
                build();

        if (userRepository.existsUserByEmail(saveUser.getEmail())) {
            throw new BadRequestException("ER-1111");
        }

        if (userRepository.existsUserByPhone(saveUser.getPhone())) {
            throw new BadRequestException("ER-1112");
        }

        if (userRepository.existsUserByNickName(saveUser.getNickName())) {
            throw new BadRequestException("ER-1113");
        }

        try {
            userRepository.save(saveUser);
        } catch (Exception e) {
            log.info("addUser Error ::: {}", e.getMessage());
            throw new BadRequestException("ER-9999");
        }
        return true;
    }
}
