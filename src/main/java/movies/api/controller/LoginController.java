package movies.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import movies.api.dto.login.in.LoginDtoIn;
import movies.api.service.user.LoginService;

@RestController
@RequestMapping("/login")
public class LoginController {
	@Autowired
	private LoginService loginService;
	
	@PostMapping
	public ResponseEntity<String> create(@RequestBody LoginDtoIn login) {
		//return ResponseEntity.ok(loginService.login(login));
		return ResponseEntity.ok("");
	}
}
