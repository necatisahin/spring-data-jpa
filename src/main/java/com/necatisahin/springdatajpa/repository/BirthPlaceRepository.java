package com.necatisahin.springdatajpa.repository;

import com.necatisahin.springdatajpa.entity.BirthPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthPlaceRepository extends JpaRepository<BirthPlace, Long> {
}
