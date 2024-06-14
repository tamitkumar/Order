package com.tech.brain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tech.brain.entity.OrderEntry;

@Repository
public interface OrderEntryRepository extends JpaRepository<OrderEntry, Long> {

}
