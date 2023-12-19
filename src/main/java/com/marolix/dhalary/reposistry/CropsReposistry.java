package com.marolix.dhalary.reposistry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marolix.dhalary.Entity.Crops;

public interface CropsReposistry extends JpaRepository<Crops, Long>{
   
	Crops findByCropNameIgnoreCase(String cropName);
	
	@Query(value = "update Crops c set c.price=?1 where c.crop_name=?2",nativeQuery = true)
	@Modifying
	void updatepriceByName(@Param("price") String price, @Param("name") String name);
}
