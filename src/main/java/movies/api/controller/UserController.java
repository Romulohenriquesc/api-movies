package movies.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import movies.api.domain.model.User;
import movies.api.dto.user.in.UserCreateDtoIn;
import movies.api.dto.user.in.UserUpdateDtoIn;
import movies.api.dto.user.out.UserDtoOut;
import movies.api.service.user.UserCreateService;
import movies.api.service.user.UserDeleteService;
import movies.api.service.user.UserGetService;
import movies.api.service.user.UserListService;
import movies.api.service.user.UserUpdateService;

@RestController
@RequestMapping("/users")
public class UserController {
	@Autowired
	private UserListService userListService;
	
	@Autowired
	private UserGetService userGetService;
	
	@Autowired
	private UserCreateService userCreateService;
	
	@Autowired
	private UserDeleteService userDeleteService;
	
	@Autowired
	private UserUpdateService userUpdateService;
	
	@GetMapping
	public ResponseEntity<List<UserDtoOut>> list(@RequestParam(required = false) String orderName, Integer take, Integer page){
		
		if(take == null) {
			take = 20;
		}
		if(page == null) {
			page = 0;
		}
		List<UserDtoOut> userOut = userListService.listOrderName(orderName, take, page)
				.stream()
				.map(UserDtoOut::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok(userOut);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UserDtoOut> getById(@PathVariable Long id){
		User user = userGetService.getById(id);
		if(user != null) {
			UserDtoOut userOut = new UserDtoOut(userGetService.getById(id));
			return ResponseEntity.ok(userOut);
		}
		return ResponseEntity.noContent().build();	
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id){
		userDeleteService.remove(id);
		return ResponseEntity.noContent().build();		
	}
	
	@PostMapping
	public ResponseEntity<UserDtoOut> create(@RequestBody UserCreateDtoIn user) {
		System.out.println("antes");
		UserDtoOut userOut = new UserDtoOut(userCreateService.create(user.toUser()));
		System.out.println("depois");
		return ResponseEntity.ok(userOut);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<UserDtoOut> update(@RequestBody UserUpdateDtoIn user, @PathVariable Long id) {
		UserDtoOut userOut = new UserDtoOut(userUpdateService.update(user.toUser(), id));
		return ResponseEntity.ok(userOut);
	}
}
