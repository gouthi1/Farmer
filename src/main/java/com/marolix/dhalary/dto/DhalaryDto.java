package com.marolix.dhalary.dto;

import java.util.List;

import com.marolix.dhalary.Entity.Crops;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DhalaryDto {

   private String name;
	
	private String quantity;
	
	private String transpotation;
	
	private String location;
	
	private String mobile;
	
	private List<Crops> crops;
	
	
}
