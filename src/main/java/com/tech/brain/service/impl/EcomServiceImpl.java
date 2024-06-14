package com.tech.brain.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tech.brain.entity.EcomOrder;
import com.tech.brain.entity.EcomProduct;
import com.tech.brain.entity.OrderEntry;
import com.tech.brain.repository.EcomOrderRepository;
import com.tech.brain.repository.EcomProductRepository;
import com.tech.brain.repository.OrderEntryRepository;
import com.tech.brain.service.EcomService;

@Service
public class EcomServiceImpl implements EcomService {
	private final EcomOrderRepository orderRepository;
	private final EcomProductRepository ecomProductRepository;
	private final OrderEntryRepository orderEntryRepository;
	public EcomServiceImpl(EcomOrderRepository orderRepository, EcomProductRepository ecomProductRepository,
			OrderEntryRepository orderEntryRepository) {
		this.orderRepository = orderRepository;
		this.ecomProductRepository = ecomProductRepository;
		this.orderEntryRepository = orderEntryRepository;
	}
	
	@Override
	public List<EcomOrder> getAllOrders() {
        return orderRepository.findAll();
    }

	@Override
    public Optional<EcomOrder> getEcomByOrderId(Long id) {
        return orderRepository.findById(id);
    }

	@Override
    public EcomOrder saveEcomOrder(EcomOrder ecomOrder) {
        return orderRepository.save(ecomOrder);
    }

	@Override
    public void deleteEcomOrder(Long id) {
    	orderRepository.deleteById(id);
    }
    
	@Override
    public List<OrderEntry> getAllOrderEntries() {
        return orderEntryRepository.findAll();
    }

	@Override
    public Optional<OrderEntry> getOrderEntryById(Long orderEntryId) {
        return orderEntryRepository.findById(orderEntryId);
    }

	@Override
    public OrderEntry saveOrderEntry(OrderEntry orderEntry) {
        return orderEntryRepository.save(orderEntry);
    }

	@Override
    public void deleteOrderEntry(Long orderEntryId) {
        orderEntryRepository.deleteById(orderEntryId);
    }

    // EcomProduct methods

	@Override
    public List<EcomProduct> getAllProducts() {
        return ecomProductRepository.findAll();
    }

	@Override
    public Optional<EcomProduct> getProductById(Long productCode) {
        return ecomProductRepository.findById(productCode);
    }

	@Override
    public EcomProduct saveProduct(EcomProduct ecomProduct) {
        return ecomProductRepository.save(ecomProduct);
    }

	@Override
    public void deleteProduct(Long productCode) {
        ecomProductRepository.deleteById(productCode);
    }

}
