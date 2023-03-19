package com.javalot.ohwoonwan.controller;

import com.javalot.ohwoonwan.model.JsonResult;
import com.javalot.ohwoonwan.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("post/{id}")
    public JsonResult findById(@PathVariable Long id) {
        return JsonResult.ok(postService.findById(id));
    }

    @GetMapping("/posts")
    public JsonResult findAllDesc() {
        return JsonResult.ok(postService.findAllDesc());
    }

}
