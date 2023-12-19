package com.marolix.dhalary.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USER_TABLE")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String userName;
	private String password;
	
	private String enable;
	
	@ManyToMany(cascade = { CascadeType.ALL, CascadeType.MERGE },fetch = FetchType.EAGER,targetEntity =Role.class)
	@JoinTable(name = "USER_FK",
	joinColumns= {@JoinColumn(name="user_id",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName = "id")})
	
	private List<Role> roles;
}
