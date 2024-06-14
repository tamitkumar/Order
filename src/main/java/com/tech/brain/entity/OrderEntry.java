package com.tech.brain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ORDER_ENTRY")
public class OrderEntry extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "entry_id")
    private Long orderEntryId;
    @Column(name = "entry_price")
    private Double orderEntryPrice;

    @OneToOne(mappedBy = "orderEntry")
    private EcomProduct ecomProduct;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ecomOrder", referencedColumnName = "order_id")
    private EcomOrder ecomOrder;


    public Long getOrderEntryId() {
        return orderEntryId;
    }

    public void setOrderEntryId(Long orderEntryId) {
        this.orderEntryId = orderEntryId;
    }

    public Double getOrderEntryPrice() {
        return orderEntryPrice;
    }

    public void setOrderEntryPrice(Double orderEntryPrice) {
        this.orderEntryPrice = orderEntryPrice;
    }

    public EcomProduct getEcomProduct() {
        return ecomProduct;
    }

    public void setEcomProduct(EcomProduct ecomProduct) {
        this.ecomProduct = ecomProduct;
    }

    public EcomOrder getEcomOrder() {
        return ecomOrder;
    }

    public void setEcomOrder(EcomOrder ecomOrder) {
        this.ecomOrder = ecomOrder;
    }
}
