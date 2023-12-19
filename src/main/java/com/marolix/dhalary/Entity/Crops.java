package com.marolix.dhalary.Entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Crops {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	

    @NotBlank(message = "Name cannot be null")
	private String cropName;
	
    @NotBlank(message = "Name cannot be null")
	private String price;
	
    @NotBlank(message = "Name cannot be null")
	private String type;
	
	@Lob
	@Column(columnDefinition = "BLOB")
	private byte[] image;
	
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE },targetEntity = Dhalary.class)
	@JoinTable(name = "crops_dhalaries",
	joinColumns = {@JoinColumn(name="crop_id",referencedColumnName = "id")},
	inverseJoinColumns = {@JoinColumn(name="dhalary_id",referencedColumnName = "id")})
	@JsonIgnore
	private List<Dhalary> dhalaries;
}
