package edu.miu.restful.controller;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin")
@CrossOrigin
public class AdminController {

    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    public String adminCall(){
        return "This admin page";
    }
}
