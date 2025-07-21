package com.example.CountryCRUD_RestAPI;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("api/country/")
public class CountryRestController {

	@Autowired
	private final CountryService conSer;

	public CountryRestController(CountryService conSer) {
		this.conSer = conSer;
	}
	
	@GetMapping("/allCountry")
	public List<CountryEntity> listCon(){
		return conSer.getAllCountry();
	}
	
	@PostMapping("/addcountry")
	public CountryEntity saveCon(@RequestBody CountryEntity con) {
		conSer.addCountry(con);
		return con;  
	}
	
	@GetMapping("/id")
	public CountryEntity getCountryById(@PathVariable("id") String id) {
		CountryEntity c=conSer.getCountryById(id);
		if(c!=null) {
			System.out.println("Country :"+c);
			return c;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Country with "+id+" not found");
	}
	
	@PutMapping("/update/{id}")
	public CountryEntity updatecountry(@PathVariable("id") String id,@RequestBody CountryEntity con) {
		CountryEntity existCon=conSer.getCountryById(id);
		if(existCon!=null) {
			existCon.setCountry_id(con.getCountry_id());
			existCon.setCountry_name(con.getCountry_name());
			existCon.setRegion_id(con.getRegion_id());
		    conSer.updateCountry(existCon);
		    return existCon;
      	}
		return null;
     }
	
	@DeleteMapping("/delete/{id}")
	public String deleteCon(@PathVariable("id") String id) {
		return " Country with "+id+" deleted Sucessfully";
		
	}
}
