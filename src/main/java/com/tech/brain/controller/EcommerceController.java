package com.tech.brain.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tech.brain.entity.EcomOrder;
import com.tech.brain.entity.EcomProduct;
import com.tech.brain.entity.OrderEntry;
import com.tech.brain.service.EcomService;

@RestController
@RequestMapping("/tech/ecommerce")
public class EcommerceController {

	private final EcomService ecomService;
	
	public EcommerceController(EcomService ecomService) {
		this.ecomService = ecomService;
	}
	
	@GetMapping("/orders")
    public List<EcomOrder> getAllOrders() {
        return ecomService.getAllOrders();
    }

    @GetMapping("/orders/{orderId}")
    public ResponseEntity<EcomOrder> getOrderById(@PathVariable Long orderId) {
        Optional<EcomOrder> order = ecomService.getEcomByOrderId(orderId);
        return order.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/orders")
    public EcomOrder createOrder(@RequestBody EcomOrder ecomOrder) {
    	ecomOrder.getOrderEntryList().forEach(orderEntry -> {
            EcomProduct product = orderEntry.getEcomProduct();
            if (product != null && product.getProductCode() == null) {
            	ecomService.saveProduct(product);
            }
        });
        return ecomService.saveEcomOrder(ecomOrder);
    }

    @PutMapping("/orders/{orderId}")
    public ResponseEntity<EcomOrder> updateOrder(@PathVariable Long orderId, @RequestBody EcomOrder orderDetails) {
        Optional<EcomOrder> order = ecomService.getEcomByOrderId(orderId);
        if (order.isPresent()) {
            EcomOrder existingOrder = order.get();
            // Update existingOrder fields here
            return ResponseEntity.ok(ecomService.saveEcomOrder(existingOrder));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/orders/{orderId}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long orderId) {
        ecomService.deleteEcomOrder(orderId);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for OrderEntry

    @GetMapping("/entries")
    public List<OrderEntry> getAllOrderEntries() {
        return ecomService.getAllOrderEntries();
    }

    @GetMapping("/entries/{entryId}")
    public ResponseEntity<OrderEntry> getOrderEntryById(@PathVariable Long entryId) {
        Optional<OrderEntry> orderEntry = ecomService.getOrderEntryById(entryId);
        return orderEntry.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/entries")
    public OrderEntry createOrderEntry(@RequestBody OrderEntry orderEntry) {
        return ecomService.saveOrderEntry(orderEntry);
    }

    @PutMapping("/entries/{entryId}")
    public ResponseEntity<OrderEntry> updateOrderEntry(@PathVariable Long entryId, @RequestBody OrderEntry orderEntryDetails) {
        Optional<OrderEntry> orderEntry = ecomService.getOrderEntryById(entryId);
        if (orderEntry.isPresent()) {
            OrderEntry existingOrderEntry = orderEntry.get();
            // Update existingOrderEntry fields here
            return ResponseEntity.ok(ecomService.saveOrderEntry(existingOrderEntry));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/entries/{entryId}")
    public ResponseEntity<Void> deleteOrderEntry(@PathVariable Long entryId) {
        ecomService.deleteOrderEntry(entryId);
        return ResponseEntity.noContent().build();
    }

    // Endpoints for EcomProduct

    @GetMapping("/products")
    public List<EcomProduct> getAllProducts() {
        return ecomService.getAllProducts();
    }

    @GetMapping("/products/{productCode}")
    public ResponseEntity<EcomProduct> getProductById(@PathVariable Long productCode) {
        Optional<EcomProduct> product = ecomService.getProductById(productCode);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/products")
    public EcomProduct createProduct(@RequestBody EcomProduct ecomProduct) {
        return ecomService.saveProduct(ecomProduct);
    }

    @PutMapping("/products/{productCode}")
    public ResponseEntity<EcomProduct> updateProduct(@PathVariable Long productCode, @RequestBody EcomProduct productDetails) {
        Optional<EcomProduct> product = ecomService.getProductById(productCode);
        if (product.isPresent()) {
            EcomProduct existingProduct = product.get();
            // Update existingProduct fields here
            return ResponseEntity.ok(ecomService.saveProduct(existingProduct));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/products/{productCode}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long productCode) {
        ecomService.deleteProduct(productCode);
        return ResponseEntity.noContent().build();
    }
}
