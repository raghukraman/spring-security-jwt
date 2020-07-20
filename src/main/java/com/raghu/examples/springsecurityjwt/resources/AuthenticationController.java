package com.raghu.examples.springsecurityjwt.resources;

import com.raghu.examples.springsecurityjwt.models.AuthenticationRequest;
import com.raghu.examples.springsecurityjwt.models.AuthenticationResponse;
import com.raghu.examples.springsecurityjwt.security.UserDetailsServiceImpl;
import com.raghu.examples.springsecurityjwt.security.util.JWTUtil;
import io.jsonwebtoken.Jws;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value="/authenticate",method = RequestMethod.POST)
    public ResponseEntity<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest authenticationRequest) throws AuthenticationException {
        System.out.println("hello");
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),authenticationRequest.getPassword()));
        UserDetails userDetails = new UserDetailsServiceImpl().loadUserByUsername(authenticationRequest.getPassword());
        //why not -- new JWTUtil() in below statement....will it work....
        return ResponseEntity.ok(new AuthenticationResponse(jwtUtil.generateToken(userDetails)));
    }
}
