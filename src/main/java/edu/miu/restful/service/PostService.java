package edu.miu.restful.service;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.PostDto;

import java.util.List;

public interface PostService {

    void save(Post p);

    void delete(int id);

    PostDto getById(int id);

    List<PostDto> getAll();

    void update(int id,Post p);

    List<PostDto> findEqualToAuthorName(String author);
}
