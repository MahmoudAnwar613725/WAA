package edu.miu.restful.controller;

import edu.miu.restful.entity.Users;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.UserDto;
import edu.miu.restful.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
public class UserController {


    @Autowired
    UserService userService;


    @GetMapping
    public List<UserDto> getUsers(){
        return userService.findAll();
    }

    @GetMapping("/moreone")
    public List<Users> getUsersHaveMoreOnePost(){
        return userService.findUserHaveMoreOnePosts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getById(@PathVariable int id) {
        var user = userService.getUserById(id);
        return ResponseEntity.ok(user);
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


    
}
