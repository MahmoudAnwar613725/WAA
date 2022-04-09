package edu.miu.restful.service;

import edu.miu.restful.entity.User;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAll();
    UserDto getUserById(long id);
    User getUserAllDataById(long id);
     List<PostDto> getPostsOfUserById(long id);
    void save(User user);
    void delete(long id);
    void update(int id, UserDto p);
    List<User> findUserHaveMoreNPosts(int postN);

    List<UserDto> findUserByPostTitle(String title);

    PostDto getPostByIdByUserId(int postId);
}
