//package com.marolix.dhalary.serviceimp;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.stream.Collectors;
//
//import org.modelmapper.ModelMapper;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import com.marolix.dhalary.Entity.Role;
//import com.marolix.dhalary.Entity.User;
//import com.marolix.dhalary.dto.RoleDto;
//import com.marolix.dhalary.dto.UserDto;
//import com.marolix.dhalary.reposistry.RoleReposistry;
//import com.marolix.dhalary.reposistry.UserReposistry;
//import com.marolix.dhalary.service.UserService;
//
//
//@Service
//public class UserServiceImp implements UserService{
//
//	@Autowired
//	private UserReposistry userReposistry;
//	
//	@Autowired
//	private RoleReposistry roleReposistry;
//	
//	@Autowired
//	private ModelMapper modelMapper;
//	
//	 @Autowired
//	    private PasswordEncoder passwordEncoder;
//	
//	@Override
//	public List<UserDto> getUsers() {
//		List<User> list=userReposistry.findAll();
//		List<UserDto> dto=list.stream().map(user ->modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
//		return dto;
//	}
//
//	@Override
//	public UserDto getByUserName(String name) {
//		User user=userReposistry.findByUserName(name);
//		UserDto dto=modelMapper.map(user, UserDto.class);
//		return dto;
//	}
//
//	@Override
//	public List<RoleDto> getByRoleName(String name) {
//		List<Role> list=roleReposistry.findByRoleAllIgnoreCase(name);
//		
//		List<RoleDto> dtos=list.stream().map(role ->modelMapper.map(list, RoleDto.class)).collect(Collectors.toList());
//		return dtos;
//	}
//
//	@Override
//	public UserDto addUsers(UserDto dto) {
//		
//		User user=modelMapper.map(dto, User.class);
//		String encodedPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encodedPassword);
//		
//		
//		
//		
//		userReposistry.save(user);
//		return dto;
//	}
//
//	@Override
//	public UserDto addRoleToUser(String name, RoleDto dto) {
//		Optional<User> optional=Optional.ofNullable(userReposistry.findByUserName(name));
//		
//		if(optional.isPresent())
//		{
//			User user=optional.get();
//			Role role=modelMapper.map(dto, Role.class);
//			user.getRoles().add(role);
//			userReposistry.save(user);
//		}
//		return null;
//	}
//
//	@Override
//	public void removeUser(String name) {
//		Optional<User> optional=Optional.ofNullable(userReposistry.findByUserName(name));
//		
//		if(optional.isPresent())
//		{
//			User user=optional.get();
//			userReposistry.delete(user);
//		}
//		
//	}
//
//}
