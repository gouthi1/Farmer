package com.marolix.dhalary.dto;

import java.util.List;

import com.marolix.dhalary.Entity.Dhalary;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CropsDto {

    private String cropName;
	
	private String price;
	
	private String type;
	
	private byte[] image;
	
	private List<Dhalary> dhalaries;
	
	

}
