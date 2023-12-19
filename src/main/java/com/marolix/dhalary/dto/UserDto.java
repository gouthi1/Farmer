package com.marolix.dhalary.dto;

import java.util.List;

import com.marolix.dhalary.Entity.Role;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

	private String userName;
	private String password;
	private String enable;
	private List<Role> roles;
}
