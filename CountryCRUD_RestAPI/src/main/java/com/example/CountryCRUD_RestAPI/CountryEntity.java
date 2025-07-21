package com.example.CountryCRUD_RestAPI;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name="countries")

public class CountryEntity {

@Id
@Column(name="country_id", length=2)
private String country_id;

@Column(name="country_name", length=40)
private String country_name;

@Column(name="region_id")
private int region_id;

	public CountryEntity() {}
	

	public CountryEntity(String country_id, String country_name, int region_id) {
		this.country_id = country_id;
		this.country_name = country_name;
		this.region_id = region_id;
	}


	public String getCountry_id() {
		return country_id;
	}

	public void setCountry_id(String country_id) {
		this.country_id = country_id;
	}

	public String getCountry_name() {
		return country_name;
	}

	public void setCountry_name(String country_name) {
		this.country_name = country_name;
	}

	public int getRegion_id() {
		return region_id;
	}

	public void setRegion_id(int region_id) {
		this.region_id = region_id;
	}


	@Override
	public int hashCode() {
		return Objects.hash(country_id, country_name, region_id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CountryEntity other = (CountryEntity) obj;
		return Objects.equals(country_id, other.country_id) && Objects.equals(country_name, other.country_name)
				&& region_id == other.region_id;
	}
	
	
	
}
