package com.marolix.dhalary.reposistry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marolix.dhalary.Entity.User;


public interface UserReposistry extends JpaRepository<User, Integer>{

	User  findByUserName(String userName);
}
