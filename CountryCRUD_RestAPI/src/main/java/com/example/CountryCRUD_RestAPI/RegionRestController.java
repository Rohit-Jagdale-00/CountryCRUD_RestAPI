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
@RequestMapping("api/region/")
public class RegionRestController {

	@Autowired
	private final RegionService regSer;

	
	
	public RegionRestController(RegionService regSer) {
		this.regSer = regSer;
	}

	@GetMapping("/allRegion")
	public List<RegionEntity> listReg(){
		return regSer.getAllRegion();
	}
	
	@PostMapping("/addregion")
	public RegionEntity saveReg(@RequestBody RegionEntity reg) {
		regSer.addRegion(reg);
		return reg;  
	}
	
	@GetMapping("/id")
	public RegionEntity getRegionById(@PathVariable("id") int id) {
		RegionEntity r=regSer.getRegionById(id);
		if(r!=null) {
			System.out.println("Region :"+r);
			return r;
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Region with "+id+" not found");
	}
	
	@PutMapping("/update/{id}")
	public RegionEntity updateregion(@PathVariable("id") int id,@RequestBody RegionEntity reg) {
		RegionEntity existReg=regSer.getRegionById(id);
		if(existReg!=null) {
			existReg.setRegion_id(reg.getRegion_id());
			existReg.setRegion_name(reg.getRegion_name());
		    regSer.updateRegion(existReg);
		    return existReg;
      	}
		return null;
     }
	
	@DeleteMapping("/delete/{id}")
	public String deleteRegion(@PathVariable("id") int id) {
		return " Region with "+id+" deleted Sucessfully";
		
	}
}

