package movies.api.configurations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import movies.api.configurations.models.AuthenticationRequest;
import movies.api.configurations.models.AuthenticationResponse;
import movies.api.configurations.service.MyUserDetailsService;
import movies.api.configurations.util.JwtUtil;
import movies.api.domain.model.Actor;
import movies.api.service.user.LoginService;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private MyUserDetailsService userDetailsService;
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private JwtUtil jwtTokenUtil;

	@PostMapping
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		if(loginService.login(authenticationRequest)) {
			final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
			
			final String jwt = jwtTokenUtil.generateToken(userDetails);
			
			return ResponseEntity.ok(new AuthenticationResponse(jwt));	
		}
//		try {
//			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
//					authenticationRequest.getUsername(), 
//					authenticationRequest.getPassword()));
//			
//		} catch (BadCredentialsException e) {
//			throw new Exception("Incorrect username or password", e);
//		}
		
		
	}
	

}
