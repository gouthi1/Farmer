package com.marolix.dhalary.reposistry;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marolix.dhalary.Entity.Role;




public interface RoleReposistry extends JpaRepository<Role, Integer>{
  List<Role>  findByRoleAllIgnoreCase(String role);
}
