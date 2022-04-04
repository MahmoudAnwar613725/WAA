package edu.miu.restful.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Post> posts;

    @OneToMany(mappedBy = "principle", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Exception> exceptions;

    @OneToMany(mappedBy = "principle", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Logger> logList;

    public  static Users getLoggedInUser(){
        return new Users(1,"logged in",null,null,null);
    }
}
