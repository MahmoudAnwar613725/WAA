package edu.miu.restful.service;


import edu.miu.restful.entity.dto.request.LoginRequest;
import edu.miu.restful.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    //LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

