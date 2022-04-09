package edu.miu.restful.entity;

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
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    String name;
    private String email;
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Role> roles;


    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JsonManagedReference
    List<Post> posts;

    @OneToMany(mappedBy = "principle", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Exception> exceptions;

    @OneToMany(mappedBy = "principle", cascade = CascadeType.ALL)
    @JsonManagedReference
    List<Logger> logList;

    public  static User getLoggedInUser(){
        return new User(1,"","","logged in",null,null,null,null);
    }
}
