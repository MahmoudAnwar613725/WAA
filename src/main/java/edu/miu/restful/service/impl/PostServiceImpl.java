package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.Users;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.PostRepo;
import edu.miu.restful.repo.UserRepo;
import edu.miu.restful.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postsRepo;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper<Post, PostDto> listMapperProductToDto;


    @Override
    public void save(Post p) {
        postsRepo.save(p);
    }

    @Override
    public void save(int userId, Post p) {
        Users user = userRepo.findById(Long.valueOf(userId)).orElse(null);
        if (user != null) {
            p.setUser(user);
            postsRepo.save(p);
        }
    }


    @Override
    public void delete(int id) {
        Post post = postsRepo.findById(id);
        postsRepo.delete(post);
    }

    @Override
    public PostDto getById(int id) {
        return modelMapper.map(postsRepo.findById(id), PostDto.class);
    }

    @Override
    public List<PostDto> getAll() {
        return (List<PostDto>) listMapperProductToDto.mapList(postsRepo.findAll(), new PostDto());
    }

    @Override
    public void update(int id, Post p) {
        //   postsRepo.save(id, p);
        postsRepo.save(p);
    }

    @Override
    public List<PostDto> findEqualToAuthorName(String author) {
        return (List<PostDto>) listMapperProductToDto.mapList(postsRepo.findPostsByAuthor(author), new PostDto());

    }

    @Override
    public List<PostDto> findEqualToTitle(String title) {
        return (List<PostDto>) listMapperProductToDto.mapList(postsRepo.findPostsByTitle(title), new PostDto());
    }

    @Override
    public PostDto findPostByUserIde(int postId, long userId) {
        return modelMapper.map(postsRepo.findPostByUserId(postId, userId), PostDto.class);
    }
}

