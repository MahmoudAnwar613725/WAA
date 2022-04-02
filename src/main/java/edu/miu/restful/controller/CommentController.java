package edu.miu.restful.controller;

import edu.miu.restful.entity.Comment;
import edu.miu.restful.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/comments")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping("/users/{user_id}/posts/{post_id}")
    public void addComment(
            @PathVariable int user_id,
            @PathVariable int post_id,
            @RequestBody  Comment comment){
        commentService.addComment(post_id,comment);
    }


}
