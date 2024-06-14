package com.tech.brain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.brain.entity.EcomProduct;

@Repository
public interface EcomProductRepository extends JpaRepository<EcomProduct, Long> {

}
