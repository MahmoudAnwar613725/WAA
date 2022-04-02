package edu.miu.restful.repo;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepo extends CrudRepository<Post,Integer> {


    List<Post> findAll();


    Post findById(int id);



    @Query("SELECT  p FROM Post p WHERE p.author=:author")
    List<Post> findPostsByAuthor(String author);

    @Query("SELECT  p FROM Post p WHERE p.title =:title")
    List<Post> findPostsByTitle(String title);

    @Query("SELECT p FROM Post p ,Users u where p.id=:postId and u.id=:userId")
    Post findPostByUserId(int postId,long userId);

}
