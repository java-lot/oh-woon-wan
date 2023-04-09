package com.javalot.ohwoonwan.controller;

import com.javalot.ohwoonwan.dto.PostCreateRequestDto;
import com.javalot.ohwoonwan.dto.PostUpdateRequestDto;
import com.javalot.ohwoonwan.model.JsonResult;
import com.javalot.ohwoonwan.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostController {
    private final PostService postService;

    @GetMapping("/posts/{id}")
    public JsonResult findById(@PathVariable Long id) {

        return JsonResult.ok(postService.findById(id));
    }

    @GetMapping("/posts")
    public JsonResult findAllDesc() {
        return JsonResult.ok(postService.findAllDesc());
    }

    @PostMapping("/posts")
    public JsonResult create(@RequestBody PostCreateRequestDto requestDto) {
        return JsonResult.ok(postService.create(requestDto));
    }

    @DeleteMapping("/posts/{id}")
    public JsonResult delete(@PathVariable Long id) {

        return JsonResult.ok(postService.delete(id));

    }

    @PutMapping("/post/{id}")
    public JsonResult update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return JsonResult.ok(postService.update(id, requestDto));
    }
}
