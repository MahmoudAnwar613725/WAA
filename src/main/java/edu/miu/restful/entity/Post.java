package edu.miu.restful.entity;

import lombok.Data;

@Data
public class Post {
    long id;
    String title;
    String content;
    String author;

}
