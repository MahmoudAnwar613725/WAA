package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.User;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.entity.dto.UserDto;
import edu.miu.restful.repo.UserRepo;
import edu.miu.restful.service.PostService;
import edu.miu.restful.service.UserService;
import edu.miu.restful.util.ListMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepo userRepo;

    @Autowired
    PostService postService;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<User, UserDto> listMapperUser2Dto;
    @Autowired
    ListMapper<Post, PostDto> listMapperPost2Dto;

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>) listMapperUser2Dto.mapList((List<User>) userRepo.findAll(), new UserDto());
    }

    @Override
    public UserDto getUserById(long id) {
        return modelMapper.map(userRepo.findById(id).get(), UserDto.class);
    }

    @Override
    public User getUserAllDataById(long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public List<PostDto> getPostsOfUserById(long id) {
        return (List<PostDto>) listMapperPost2Dto.mapList(userRepo.findById(id).get().getPosts(), new PostDto());
    }



    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete(long id) {
        userRepo.deleteById(id);
    }

    @Override
    public void update(int id, UserDto userDto) {
        userRepo.save(modelMapper.map(userDto, User.class));
    }

    @Override
    public List<User> findUserHaveMoreNPosts(int postNum) {
        return userRepo.findGreaterThanNpost(postNum);
    }

    @Override
    public List<UserDto> findUserByPostTitle(String title) {
        return (List<UserDto>) listMapperUser2Dto.mapList(userRepo.findUserByPostTitle(title), new UserDto());
    }

    @Override
    public PostDto getPostByIdByUserId(int postId) {
        return postService.getById(postId);
    }

}
