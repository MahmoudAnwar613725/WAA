package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.Users;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.repo.PostRepo;
import edu.miu.restful.repo.UserRepo;
import edu.miu.restful.service.PostService;
import edu.miu.restful.util.ListMapper;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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
    public void save(long userId, Post p) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username;

        if (principal instanceof UserDetails) {
            username = ((UserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }
        Users user = userRepo.findByEmail(username);
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

