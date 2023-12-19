package com.marolix.dhalary.dto;

import java.util.List;

import com.marolix.dhalary.Entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

	private String role;
	
	private List<User> users;
}
