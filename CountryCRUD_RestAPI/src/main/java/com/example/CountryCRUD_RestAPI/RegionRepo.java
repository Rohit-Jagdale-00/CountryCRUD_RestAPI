package com.example.CountryCRUD_RestAPI;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionRepo extends JpaRepository<RegionEntity, Integer> {

}
