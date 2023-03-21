package com.javalot.ohwoonwan.service;


import com.javalot.ohwoonwan.dto.JoinUserDto;
import org.springframework.stereotype.Service;

/**
 * @author hazel
 */

@Service
public interface UserService {

    Boolean addUser(JoinUserDto joinUserDto);
}
