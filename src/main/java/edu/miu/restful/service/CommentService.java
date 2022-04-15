package edu.miu.restful.service;

import edu.miu.restful.entity.Comment;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin()
public interface CommentService {
    void addComment(int postId,Comment comment);

    Comment findCommentByPostIdByUserId(int postId, long userId, int commentId);

    List<Comment> findCommentsByPostIdByUserId(int postId, long userId);
    List<Comment> findCommentsByPostId(int postId);
}
