package com.javalot.ohwoonwan.controller;

import com.javalot.ohwoonwan.dto.JoinUserDto;
import com.javalot.ohwoonwan.model.JsonResult;
import com.javalot.ohwoonwan.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hazel
 */
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("")
    public JsonResult addUser(@RequestBody JoinUserDto joinUserDto){
        return JsonResult.ok(userService.addUser(joinUserDto));
    }



}
