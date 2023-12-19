package com.marolix.dhalary.api;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.marolix.dhalary.Entity.Dhalary;
import com.marolix.dhalary.config.ImageUtility;
import com.marolix.dhalary.dto.CropsDto;
import com.marolix.dhalary.dto.DhalaryDto;
import com.marolix.dhalary.exception.EmptyDataException;
import com.marolix.dhalary.service.CropsService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/crops")
@Validated
@CrossOrigin("*")
public class CropsApi {

	@Autowired
	private CropsService cropsService;
	
	@PostMapping("/crops")
	public ResponseEntity<CropsDto> addCrops(@Valid @RequestParam("name") String name,
	        @RequestParam("price") String price,
	        @RequestParam("type") String type,
	        @RequestParam("image") MultipartFile image,
	        @RequestParam("dhalaries") List<Dhalary> dhalaries) throws IOException 
	{
		
		
	    
		byte[] imageData=image.getBytes();
	
		CropsDto dto=new CropsDto(name, price, type, imageData, dhalaries);
		CropsDto dto2=cropsService.addCrops(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto2);
	}
	
	@PostMapping("/dhalary")
	public ResponseEntity<DhalaryDto> addDhalary(@RequestBody DhalaryDto dto)
	{
		DhalaryDto dto2=cropsService.AddDhalary(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(dto2);
	}

	@PostMapping("{name}/dhalary")
	public ResponseEntity<CropsDto> addDhalaryByCrops(@PathVariable("name") String name,@RequestBody DhalaryDto dhalaryDto)
	{
		CropsDto cropsDto=cropsService.addDhalaryByCropName(name, dhalaryDto);
		return ResponseEntity.status(HttpStatus.CREATED).body(cropsDto);
	}
	
	@GetMapping("/crops")
	public ResponseEntity<List<CropsDto>> getAllCrops()
	{
		List<CropsDto> dtos= cropsService.getAllCrops();
		if(dtos.isEmpty())
		{
			throw new EmptyDataException("there is no data");
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		}
		
	}

	@GetMapping("/dhalaries")
	public ResponseEntity<List<DhalaryDto>> getAllDhalaries()
	{
		List<DhalaryDto> dtos=cropsService.getAllDhalaries();
		if(dtos.isEmpty())
		{
			throw new EmptyDataException("there is no data");
		}
		else {
			return ResponseEntity.status(HttpStatus.OK).body(dtos);
		}
	}
	
	@GetMapping("/crops/{name}")
	public ResponseEntity<CropsDto> getByCropName(@PathVariable("name") String name)
	{
		CropsDto cropsDto=cropsService.getByCropName(name);
		return ResponseEntity.status(HttpStatus.OK).body(cropsDto);
	}
	
	@GetMapping("/location/{location}")
	public ResponseEntity<List<DhalaryDto>> getByLocation(@PathVariable("location") String location)
	{
		List<DhalaryDto> dhalaryDto=cropsService.getByDhalaryLocation(location);
		return ResponseEntity.status(HttpStatus.OK).body(dhalaryDto);
	}

	@GetMapping("/dhalary/{name}")
	public ResponseEntity<DhalaryDto> getByDhalaryName(@PathVariable("name") String name)
	{
		DhalaryDto dhalaryDto=cropsService.getByDhalaryName(name);
		return ResponseEntity.status(HttpStatus.OK).body(dhalaryDto);
	}

	@PutMapping("/price/{name}")
	public ResponseEntity<String> updatePrice( @PathVariable("name") String name,@RequestBody CropsDto dto )
	{
		cropsService.updatePriceByName(name,dto.getPrice());
		return new ResponseEntity<String>("update successfully",HttpStatus.OK);
	}
	
	@PutMapping("/quantity/{name}")
	public ResponseEntity<String> updateQuantiy(@PathVariable("name") String name,@RequestBody DhalaryDto dto)
	{
		cropsService.updateQuantityByName(name,dto.getQuantity());
		return new ResponseEntity<String>("update successfully",HttpStatus.OK);
	}
	
	@PutMapping("/mobile/{name}")
	public ResponseEntity<String> updateMobile(@PathVariable("name") String name,@RequestBody DhalaryDto dto)
	{
		cropsService.updatemobileByName(name,dto.getMobile());
		return new ResponseEntity<String>("update successfully",HttpStatus.OK);
	}

	@DeleteMapping("/delete/crop/{name}")
	public ResponseEntity<String> deleteCropByName(@PathVariable("name") String name)
	{
		cropsService.deleteCropByName(name);
		return new ResponseEntity<String>("deleted Successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/dhalary/{name}")
	public ResponseEntity<String> deleteDhalaryByName(@PathVariable("name") String name)
	{
		cropsService.deletedhalaryByName(name);
		return new ResponseEntity<String>("deleted Successfully", HttpStatus.OK);
	}

}
