package edu.miu.restful.repo;

import edu.miu.restful.entity.Comment;
import edu.miu.restful.entity.Post;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends CrudRepository<Comment, Integer> {


    @Query("SELECT c from Comment c , Post p,Users u where c.id=:commentId and c.post.id=p.id")
    Comment findCommentByPostIdByUserId(int commentId);

    @Query("SELECT c from Comment c ,Post p,Users u where p.id=:postId and c.post.id=p.id")
    List<Comment> findCommentsByPostIdByUserId(int postId);


}
