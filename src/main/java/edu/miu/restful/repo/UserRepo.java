package edu.miu.restful.repo;

import edu.miu.restful.entity.Users;
import edu.miu.restful.entity.dto.UserDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends CrudRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.posts.size>:postNum ")
    List<Users> findGreaterThanNpost(int postNum);

    @Query("SELECT u FROM Users u, Post p WHERE p.title =:title and u.id = p.user.id ")
    List<Users> findUserByPostTitle(String title);
}
