package edu.miu.restful.controller;

import edu.miu.restful.aspect.annotation.ExecutionTime;
import edu.miu.restful.entity.Comment;
import edu.miu.restful.entity.Users;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.UserDto;
import edu.miu.restful.service.CommentService;
import edu.miu.restful.service.PostService;
import edu.miu.restful.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;


    @Autowired
    CommentService commentService;

    @GetMapping
    public List<UserDto> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/filterPosts/{postNum}")
    public List<Users> getUsersHaveMoreNPost(@PathVariable int postNum) {
        return userService.findUserHaveMoreNPosts(postNum);
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id) {
        var user = userService.getUserById(id);
        return ResponseEntity.ok(user);
    }*/

    @ExecutionTime
    @GetMapping("/{id}")
    public Users getUsers(@PathVariable long id) {
        var user = userService.getUserAllDataById(id);
        return user;
    }

    @ExecutionTime
    @GetMapping("/test")
    public void testException() {
        int x = 5 / 0;
    }


    @GetMapping("/{id}/posts")
    public ResponseEntity<List<PostDto>> getPostsByUserId(@PathVariable int id) {
        var post = userService.getPostsOfUserById(id);
        return ResponseEntity.ok(post);
    }

    @PostMapping
    public void save(@RequestBody Users user) {
        userService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        userService.delete(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable("id") int postId, @RequestBody UserDto uDto) {
        userService.update(postId, uDto);
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/filter_post_title")
    public List<UserDto> getAll(@RequestParam(value = "filter", required = false) String filter) {
        return filter == null ? userService.findAll() : userService.findUserByPostTitle(filter);
    }


    @GetMapping("/{id}/posts/{post_id}")
    public ResponseEntity<PostDto> getPostByUserId(@PathVariable("id") long userId, @PathVariable("post_id") int postId) {
        var post = postService.findPostByUserIde(postId, userId);
        return ResponseEntity.ok(post);
    }

    @GetMapping("/{id}/posts/{post_id}/comments/{comment_id}")
    public Comment getCommentByIdByPostIdByUserId(@PathVariable("id") long userId,
                                                  @PathVariable("post_id") int postId,
                                                  @PathVariable("comment_id") int commentId) {
        return commentService.findCommentByPostIdByUserId(postId, userId, commentId);
    }

    @GetMapping("/{id}/posts/{post_id}/comments")
    public List<Comment> getCommentsByPostIdByUserId(@PathVariable("id") long userId,
                                                     @PathVariable("post_id") int postId) {
        return commentService.findCommentsByPostIdByUserId(postId, userId);
    }
}
