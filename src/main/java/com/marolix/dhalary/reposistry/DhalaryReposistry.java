package com.marolix.dhalary.reposistry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.marolix.dhalary.Entity.Dhalary;
import java.util.List;


public interface DhalaryReposistry extends JpaRepository<Dhalary, Long>{

	List<Dhalary> findByLocationAllIgnoreCase(String location);
	
	Dhalary findByName(String name);
	
	@Query(value = "update Dhalary d set d.mobile=?1 where d.name=?2",nativeQuery = true)
	@Modifying
	void updateMobileByName(@Param("mobile") String mobile,@Param("name") String name);
	
	@Query(value = "update Dhalary d set d.quantity=?1 where d.name=?2",nativeQuery = true)
	@Modifying
	void updateQuantityByName(@Param("quantity") String quantity,@Param("name") String name);
}
