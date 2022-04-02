package edu.miu.restful.controller;

import edu.miu.restful.entity.Comment;
import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.service.CommentService;
import edu.miu.restful.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/posts")
public class PostController {

    PostService postService;
    CommentService commentService;

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
    @GetMapping("/filter_author")
    public List<PostDto> getAll(@RequestParam(value = "filter", required = false) String filter) {
        return filter == null ? postService.getAll() : postService.findEqualToAuthorName(filter);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter_title")
    public List<PostDto> getAllPostsByTitle(@RequestParam(value = "filter", required = false) String title) {
        return title == null ? postService.getAll() : postService.findEqualToTitle(title);
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


    @PostMapping("/users/{user_id}/posts")
    public void savePost(
            @PathVariable int user_id,
            @RequestBody  Post comment){
        postService.save(user_id,comment);
    }

}
