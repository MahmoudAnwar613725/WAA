package edu.miu.restful.service;

import edu.miu.restful.entity.Users;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto getUserById(long id);
    List<PostDto> getPostsOfUserById(long id);
    void save(Users user);
    void delete(long id);
    void update(int id, UserDto p);
    List<Users> findUserHaveMoreOnePosts();
}
