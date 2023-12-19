package com.marolix.dhalary.serviceimp;

import java.util.Base64;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marolix.dhalary.Entity.Crops;
import com.marolix.dhalary.Entity.Dhalary;
import com.marolix.dhalary.config.ImageUtility;
import com.marolix.dhalary.dto.CropsDto;
import com.marolix.dhalary.dto.DhalaryDto;
import com.marolix.dhalary.exception.UserNotFountException;
import com.marolix.dhalary.reposistry.CropsReposistry;
import com.marolix.dhalary.reposistry.DhalaryReposistry;
import com.marolix.dhalary.service.CropsService;

import jakarta.transaction.Transactional;

@Service
public class CropsServiceImp implements CropsService {

	@Autowired
	private CropsReposistry cropsReposistry;
	
	@Autowired
	private DhalaryReposistry dhalaryReposistry;
	
	@Autowired
	private ModelMapper  modelMapper;
	
	@Override
	public CropsDto addCrops(CropsDto dto) {
		Crops crops=modelMapper.map(dto,Crops.class);
		cropsReposistry.save(crops);
		return dto;
	}

	@Override
	public DhalaryDto AddDhalary(DhalaryDto dto) {
		Dhalary dhalary=modelMapper.map(dto, Dhalary.class);
		dhalaryReposistry.save(dhalary);
		return dto;
	}

	@Override
	public List<CropsDto> getAllCrops() {
		List<Crops> list=cropsReposistry.findAll();
		return list.stream().map(crop->new CropsDto(crop.getCropName(), crop.getPrice(),
				crop.getType(),crop.getImage(), crop.getDhalaries())).collect(Collectors.toList());
	}

	@Override
	public List<DhalaryDto> getAllDhalaries() {
		List<Dhalary> list=dhalaryReposistry.findAll();
		
		return list.stream().map(dhalary->modelMapper.map(dhalary,DhalaryDto.class)).collect(Collectors.toList());
	}

	@Override
	public CropsDto getByCropName(String name) {
		Optional <Crops> optional= Optional.ofNullable(cropsReposistry.findByCropNameIgnoreCase(name));
		
		if(optional .isPresent())
		{
			Crops crops=optional.get();
			CropsDto dto=modelMapper.map(crops, CropsDto.class);
			
			return dto;
		}
		
			throw new UserNotFountException("user data is not macted"+name);
		
	}

	@Override
	public List<DhalaryDto> getByDhalaryLocation(String location) {
		Optional<List<Dhalary>> optional=Optional.ofNullable(dhalaryReposistry.findByLocationAllIgnoreCase(location));
		if(optional .isPresent())
		{
			return optional.stream().map(dhalary->modelMapper.map(dhalary, DhalaryDto.class)).collect(Collectors.toList());
		}
		else {
			throw new UserNotFountException("userData is Not Found : " +location);
		}
		
	}

	@Override
	public CropsDto addDhalaryByCropName(String name, DhalaryDto dto) {
		Optional<Crops> optional =Optional.ofNullable(cropsReposistry.findByCropNameIgnoreCase(name));
		
		if(optional .isPresent())
		{
			Crops crops=optional.get();
			
		   Dhalary dhalary=modelMapper.map(dto, Dhalary.class);
		   
		   crops.getDhalaries().add(dhalary);
		   
		   cropsReposistry.save(crops);
		   
		   CropsDto cropsDto=modelMapper.map(crops, CropsDto.class);
		   
		   return cropsDto;
		}
		else {
			throw new UserNotFountException("userData is Not Found : " +name);
		}
		
	}


	@Override
	public DhalaryDto getByDhalaryName(String name) {
		Optional<Dhalary> optional=Optional.ofNullable(dhalaryReposistry.findByName(name));
		
		if(optional.isPresent())
		{
			Dhalary dhalary=optional.get();
			DhalaryDto dhalaryDto=modelMapper.map(dhalary, DhalaryDto.class);
			
			return dhalaryDto;
		}
		else {
			throw new UserNotFountException("userData is Not Found : " +name);
		}
		
	}

	@Override
	@Transactional
	public void updatePriceByName( String name,String price) {
		
		Optional<Crops> optional=Optional.ofNullable(cropsReposistry.findByCropNameIgnoreCase(name));
		
		if(optional.isPresent())
		{
			cropsReposistry.updatepriceByName(price, name);
			
		}
		else {
			throw new RuntimeException("user data is not found"+name);
		}
		
	}

	@Override
	@Transactional
	public void updateQuantityByName( String name,String quantity) {
		Optional<Dhalary> optional=Optional.ofNullable(dhalaryReposistry.findByName(name));
		
		if(optional.isPresent())
		{
			dhalaryReposistry.updateQuantityByName(quantity, name);
		}
		else {
			throw new UserNotFountException("userData is Not Found : " +name);
		}
	}

	@Override
	@Transactional
	public void updatemobileByName( String name,String mobile) {
		
         Optional<Dhalary> optional=Optional.ofNullable(dhalaryReposistry.findByName(name));
		
		if(optional.isPresent())
		{
			dhalaryReposistry.updateMobileByName(mobile, name);
		}
		else {
			throw new UserNotFountException("userData is Not Found : " +name);
		}
	}


	@Override
	public void deleteCropByName(String name) {
		Optional<Crops> optional=Optional.ofNullable(cropsReposistry.findByCropNameIgnoreCase(name));
		
		if(optional .isPresent())
		{
			Crops crops=optional.get();
			cropsReposistry.delete(crops);
		}
		else {
			throw new UserNotFountException("userData is Not Found : " +name);
		}
		
	}

	@Override
	public void deletedhalaryByName(String name) {
         Optional<Dhalary> optional=Optional.ofNullable(dhalaryReposistry.findByName(name));
		
		if(optional .isPresent())
		{
			Dhalary dhalary=optional.get();
			dhalaryReposistry.delete(dhalary);
		}
		else {
			throw new UserNotFountException("userData is Not Found : " +name);
		}
		
	}
	public String convertToBase64(byte[] bytes) {
        return Base64.getEncoder().encodeToString(bytes);
    }
	
	
}
