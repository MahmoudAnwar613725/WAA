package edu.miu.restful.service;

import edu.miu.restful.entity.Post;
import edu.miu.restful.entity.dto.PostDto;

import java.util.List;

public interface PostService  {

    void save(Post p);

    void delete(int id);

    PostDto getById(int id);

    List<PostDto> getAll();

    void update(int id,Post p);

    List<PostDto> findEqualToAuthorName(String author);
    List<PostDto> findEqualToTitle(String title);

    void save(int user_id, Post comment);

    PostDto findPostByUserIde(int postId, long userId);
}
