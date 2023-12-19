package com.marolix.dhalary.service;


import java.util.List;

import com.marolix.dhalary.dto.RoleDto;
import com.marolix.dhalary.dto.UserDto;


public interface UserService {

	public List<UserDto> getUsers();
	
	public UserDto getByUserName(String name);
    public List<RoleDto>  getByRoleName(String name);
    
    public UserDto addUsers(UserDto dto);
    public UserDto addRoleToUser(String name,RoleDto dto);
    public void removeUser(String name);
    
}
