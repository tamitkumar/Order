package com.tech.brain.service;

import java.util.List;
import java.util.Optional;

import com.tech.brain.entity.EcomOrder;
import com.tech.brain.entity.EcomProduct;
import com.tech.brain.entity.OrderEntry;

public interface EcomService {

	List<EcomOrder> getAllOrders();

	EcomProduct saveProduct(EcomProduct ecomProduct);

	void deleteProduct(Long productCode);

	Optional<EcomProduct> getProductById(Long productCode);

	List<EcomProduct> getAllProducts();

	void deleteOrderEntry(Long orderEntryId);

	OrderEntry saveOrderEntry(OrderEntry orderEntry);

	Optional<OrderEntry> getOrderEntryById(Long orderEntryId);

	List<OrderEntry> getAllOrderEntries();

	void deleteEcomOrder(Long id);

	EcomOrder saveEcomOrder(EcomOrder ecomOrder);

	Optional<EcomOrder> getEcomByOrderId(Long id);

}
