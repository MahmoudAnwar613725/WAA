package edu.miu.restful.controller;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(headers = "X-API-VERSION=1")
    public List<PostDto> getAllV1() {
        return postService.getAll();
    }

    @GetMapping(headers = "X-API-VERSION=2")
    public List<PostDto> getAllV2() {
        return postService.getAll();
    }

    @GetMapping("/{id}")
    public PostDto getById(@PathVariable() int id) {
        return postService.getById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public List<PostDto> getAll(@RequestParam(value = "filter", required = false) String author) {
        return author == null ? postService.getAll() : postService.findEqualToAuthorName(author);
    }

    @PostMapping
    public void save(@RequestBody Post p) {
        postService.save(p);
    }


    @DeleteMapping("/{id}")
    public void delete(@PathVariable() int id) {
        postService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int id, @RequestBody Post p) {
        postService.update(id, p);
    }
}
