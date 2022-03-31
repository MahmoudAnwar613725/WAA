package edu.miu.restful.repo.impl;

import edu.miu.restful.entity.Post;
import edu.miu.restful.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PostRepoImpl implements PostRepo {
    private static List<Post> posts;
    private static int POST_ID = 300;

    static {
        posts = new ArrayList<>();
      /*  Review r1a = new Review(123, "I love it", 5);
        Review r1b = new Review(145, "It is ordinary", 4);
        List<Review> reviews1 = Arrays.asList(r1a, r1b);

        Review r2a = new Review(223, "Not that good", 3);
        Review r2b = new Review(245, "It does the job", 4);
        List<Review> reviews2 = Arrays.asList(r2a, r2b);

        Product p1 = new Product(111, "iPhone13", 1100, reviews1);
        Product p2 = new Product(112, "galaxy", 1050, reviews2);
        posts.add(p1);
        posts.add(p2);*/
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

    public Post getById(int id) {
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);

    }


}
