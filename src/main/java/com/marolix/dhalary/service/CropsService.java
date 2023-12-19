package com.marolix.dhalary.service;

import java.util.List;

import com.marolix.dhalary.dto.CropsDto;
import com.marolix.dhalary.dto.DhalaryDto;

public interface CropsService {

	public CropsDto addCrops(CropsDto dto);
	
	public DhalaryDto AddDhalary(DhalaryDto dto);
	
	public CropsDto addDhalaryByCropName(String name ,DhalaryDto dto);
	
	public List<CropsDto> getAllCrops();
	
	public List<DhalaryDto> getAllDhalaries();
	
	public CropsDto getByCropName(String name);
	
	public DhalaryDto getByDhalaryName(String name);
	
	public List<DhalaryDto> getByDhalaryLocation(String location);
	
	public void updatePriceByName(String price, String name);
	
	public void updateQuantityByName(String quantity,String name);
	
	public void updatemobileByName(String mobile, String name);
	
	public void deleteCropByName(String name);
	
	public void deletedhalaryByName(String name);
	
	public String convertToBase64(byte[] bytes);
	
	
	
	
	
}
