package com.raghu.examples.springsecurityjwt.resources;

import com.raghu.examples.springsecurityjwt.models.AuthenticationRequest;
import com.raghu.examples.springsecurityjwt.models.AuthenticationResponse;
import com.raghu.examples.springsecurityjwt.security.UserDetailsServiceImpl;
import com.raghu.examples.springsecurityjwt.security.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation

@RestController
public class HelloResource {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JWTUtil jwtUtil;

    @GetMapping("/message")
    public String getMessage(){
        return "Hello Mr.Raghuraman";
    }

}
