//package com.marolix.dhalary.api;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.marolix.dhalary.dto.RoleDto;
//import com.marolix.dhalary.dto.UserDto;
//import com.marolix.dhalary.service.UserService;
//
//
//@RestController
//@RequestMapping("/user")
//public class UserController {
//	
//	@Autowired
//	private UserService userService;
//	
//	@GetMapping("/user")
//	public ResponseEntity<List<UserDto>> readAllUsers()
//	{
//		List<UserDto> dto2=userService.getUsers();
//		
//		return ResponseEntity.status(HttpStatus.OK).body(dto2);
//	}
//	
//	@GetMapping("/user/{name}")
//	public ResponseEntity<UserDto> readByUserName(@PathVariable("name") String name)
//	{
//		UserDto dto2=userService.getByUserName(name);
//		return ResponseEntity.status(HttpStatus.OK).body(dto2);
//	}
//	
//	@GetMapping("/role/{name}")
//	public ResponseEntity<List<RoleDto>> readByRole(@PathVariable("name") String name)
//	{
//		List<RoleDto> dto2=userService.getByRoleName(name);
//		return ResponseEntity.status(HttpStatus.OK).body(dto2);
//	}
//	
//	@PostMapping("/user")
//	public ResponseEntity<UserDto> addUsers(@RequestBody UserDto dto)
//	{
//		UserDto dto2=userService.addUsers(dto);
//		return ResponseEntity.status(HttpStatus.CREATED).body(dto2);
//	}
//	
//	@PostMapping("/role/{name}")
//	public ResponseEntity<UserDto> addRoleByUser(@RequestBody RoleDto dto,@PathVariable("name") String name)
//	{
//		UserDto dto2=userService.addRoleToUser(name, dto);
//		return ResponseEntity.status(HttpStatus.CREATED).body(dto2);
//	}
//	
//	@DeleteMapping("/user")
//	public ResponseEntity<String> removeUser(@PathVariable("name") String name)
//	{
//		userService.removeUser(name);
//		
//		return new ResponseEntity<String>("Delete Successfully", HttpStatus.OK);
//	}
//
//}
