package edu.miu.restful.service.impl;


import edu.miu.restful.entity.dto.request.LoginRequest;
import edu.miu.restful.entity.dto.response.LoginResponse;
import edu.miu.restful.service.AuthService;
import edu.miu.restful.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
 import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            var result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(),
                            loginRequest.getPassword())
            );
            if(result.isAuthenticated()){
                final UserDetails userDetails = userDetailsService
                        .loadUserByUsername(loginRequest.getEmail());

                final String accessToken = jwtUtil.generateToken(userDetails);
                final String refreshToken = jwtUtil.generateRefreshToken(loginRequest.getEmail());
                var loginResponse = new LoginResponse(accessToken, refreshToken);
                return loginResponse;
            }

        } catch (BadCredentialsException e) {
            log.info("Bad Credentials");
        }
    return null;

    }

    /*@Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        boolean isRefreshTokenValid = jwtUtil.validateToken(refreshTokenRequest.getRefreshToken());
        if (isRefreshTokenValid) {
            final String accessToken = jwtUtil.doGenerateToken( jwtUtil.getSubject(refreshTokenRequest.getRefreshToken()));
            var loginResponse = new LoginResponse(accessToken, refreshTokenRequest.getRefreshToken());
            return loginResponse;
        }
        return new LoginResponse();
    }*/
}