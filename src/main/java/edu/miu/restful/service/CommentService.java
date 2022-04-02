package edu.miu.restful.service;

import edu.miu.restful.entity.Comment;

import java.util.List;

public interface CommentService {
    void addComment(int postId,Comment comment);

    Comment findCommentByPostIdByUserId(int postId, long userId, int commentId);

    List<Comment> findCommentsByPostIdByUserId(int postId, long userId);
}
