package com.tech.brain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.brain.entity.EcomOrder;

@Repository
public interface EcomOrderRepository extends JpaRepository<EcomOrder, Long> {

}
