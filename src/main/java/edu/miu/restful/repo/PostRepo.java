package edu.miu.restful.repo;

import edu.miu.restful.entity.Post;

import java.util.List;

public interface PostRepo {

    public List<Post> findAll();
    public List<Post> findAll(String author);

    public Post getById(int id);

    public void save(Post p);

    public void delete(int id);

    public void update(int id, Post p);


    List<Post> getAll();
}
