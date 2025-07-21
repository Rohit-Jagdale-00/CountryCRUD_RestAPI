package com.example.CountryCRUD_RestAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CountryService {

	@Autowired
	private final CountryRepo conRepo;

	public CountryService(CountryRepo conRepo) {
		this.conRepo = conRepo;
	}
	
	//fetch country by id
	  public CountryEntity getCountryById(String id) {
		return conRepo.findById(id).orElse(null);
	  }
	 
	  //fetch all country
	  public List<CountryEntity> getAllCountry(){
		  return conRepo.findAll();
	  }
	 
	  // add new country
	   public void addCountry(CountryEntity conEn) {
		  conRepo.save(conEn);
	  }
	 
	  //update country
	  public void updateCountry(CountryEntity conEn) {
		  conRepo.save(conEn);
	  }
	 
	  // delete country by id
	  public void deleteCountry(String id) {
		  conRepo.deleteById(id);
	  }
}
