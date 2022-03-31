package edu.miu.restful.service.impl;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.PostDto;
import edu.miu.restful.helper.ListMapper;
import edu.miu.restful.repo.PostRepo;
import edu.miu.restful.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {

    private final PostRepo postsRepo;
    @Autowired
    ModelMapper modelMapper;
    @Autowired
    ListMapper<Post, PostDto> listMapperProductToDto;

    @Override
    public void save(Post p) {
        postsRepo.save(p);
    }

    @Override
    public void delete(int id) {
        postsRepo.delete(id);
    }

    @Override
    public PostDto getById(int id) {
        return modelMapper.map(postsRepo.getById(id), PostDto.class);
    }

    @Override
    public List<PostDto> getAll() {
        return (List<PostDto>) listMapperProductToDto.mapList(postsRepo.findAll(), new PostDto());
    }

    @Override
    public void update(int id, Post p) {
        postsRepo.update(id, p);
    }

    @Override
    public List<PostDto> findEqualToAuthorName(String author) {
        return (List<PostDto>) listMapperProductToDto.mapList(postsRepo.findAll(author), new PostDto());

    }
}

