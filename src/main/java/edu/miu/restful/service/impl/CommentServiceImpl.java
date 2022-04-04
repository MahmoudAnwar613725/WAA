package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Comment;
import edu.miu.restful.entity.Post;
import edu.miu.restful.repo.CommentRepo;
import edu.miu.restful.repo.PostRepo;
import edu.miu.restful.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;
    @Autowired
    PostRepo postRepo;


    @Override
    public void addComment(int postId, Comment comment) {
        Post post = postRepo.findById(postId);
        if (post != null) {
            comment.setPost(post);
            commentRepo.save(comment);
        }
    }

    @Override
    public Comment findCommentByPostIdByUserId(int postId, long userId, int commentId) {
        return commentRepo.findCommentByPostIdByUserId(postId, userId, commentId);
    }

    @Override
    public List<Comment> findCommentsByPostIdByUserId(int postId, long userId) {
        return commentRepo.findCommentsByPostIdByUserId(postId, userId);
    }
}
