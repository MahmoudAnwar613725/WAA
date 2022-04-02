package edu.miu.restful.repo.impl;

import edu.miu.restful.entity.Post;
import edu.miu.restful.repo.PostRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl /*implements PostRepo*/ {
  /*  private static List<Post> posts;
    private static int POST_ID = 300;

    @Autowired
    PostRepo postRepo;

    static {
        posts = new ArrayList<>();
    }


    public List<Post> findAll() {
        return posts;
    }

    @Override
    public List<Post> findAll(String author) {
        return posts
                .stream()
                .filter(l -> l.getAuthor().equalsIgnoreCase(author))
                .collect(Collectors.toList());
    }

    public void save(Post p) {
        p.setId(POST_ID); // We are auto generating the id for DEMO purposes, (Normally, do not change your parameters)
        POST_ID++;
        posts.add(p);
    }


    @Override
    public void delete(int id) {
        var post = posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(post);
    }

    @Override
    public void update(int id, Post p) {
        Post toUpdate = getById(id);
        toUpdate.setAuthor(p.getAuthor());
        toUpdate.setTitle(p.getTitle());
        toUpdate.setContent(p.getContent());
    }

    @Override
    public List<Post> getAll() {
        return posts;
    }

    @Override
    public List<Post> findByTitle(String title) {
        return findByTitle(title);
    }

    public Post getById(int id) {
        return postRepo.getById(id);
        *//*posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
*//*
    }*/


}
