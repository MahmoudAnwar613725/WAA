package edu.miu.restful.repo;

import edu.miu.restful.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {

    @Query("SELECT u FROM User u WHERE u.posts.size>:postNum ")
    List<User> findGreaterThanNpost(int postNum);

    @Query("SELECT u FROM User u, Post p WHERE p.title =:title and u.id = p.user.id ")
    List<User> findUserByPostTitle(String title);

    User findByEmail(String username);

}
