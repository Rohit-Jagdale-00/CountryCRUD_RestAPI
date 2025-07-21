package com.example.CountryCRUD_RestAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegionService {

	@Autowired
	private final RegionRepo regionRepo;

	public RegionService(RegionRepo regionRepo) {
		this.regionRepo = regionRepo;
	}
	
	//fetch region by id
	  public RegionEntity getRegionById(int id) {
		return regionRepo.findById(id).orElse(null);
	  }
	 
	  //fetch all region
	  public List<RegionEntity> getAllRegion(){
		  return regionRepo.findAll();
	  }
	 
	  // add new region
	   public void addRegion(RegionEntity regEn) {
		   regionRepo.save(regEn);
	  }
	 
	  //update country
	  public void updateRegion(RegionEntity regEn) {
		  regionRepo.save(regEn);
	  }
	 
	  // delete region by id
	  public void deleteRegion(int id) {
		  regionRepo.deleteById(id);
	  }
	
}
