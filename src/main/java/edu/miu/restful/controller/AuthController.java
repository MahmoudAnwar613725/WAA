package edu.miu.restful.controller;

import edu.miu.restful.entity.dto.request.LoginRequest;
import edu.miu.restful.service.AuthService;
  import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/authenticate")
@CrossOrigin
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        var loginResponse = authService.login(loginRequest);
        if(loginResponse!=null){
            return ResponseEntity.ok().body(loginResponse);
        }
        return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
    }

    /*@PostMapping("/refreshToken")
    public LoginResponse refreshToken(@RequestBody RefreshTokenRequest refreshTokenRequest){
        return authService.refreshToken(refreshTokenRequest);
    }*/

}