package com.tech.brain.entity;


import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import com.tech.brain.model.OrderStatus;


@Entity
@Table(name = "ECOM_ORDER")
public class EcomOrder extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "total_price")
    private Double totalPrice;
    @Column(name = "order_date")
    private Date orderDate;
    @Column(name = "placed_by")
    private String placedBy;

    @Column(name = "order_status")
    private OrderStatus orderstatus;
    @OneToMany(mappedBy = "ecomOrder", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderEntry> OrderEntryList;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getPlacedBy() {
        return placedBy;
    }

    public void setPlacedBy(String placedBy) {
        this.placedBy = placedBy;
    }

    public OrderStatus getOrderstatus() {
       return orderstatus;
    }

   public void setOrderstatus(OrderStatus orderstatus) {
      this.orderstatus = orderstatus;
   }

  public List<OrderEntry> getOrderEntryList() {
       return OrderEntryList;
   }

   public void setOrderEntryList(List<OrderEntry> orderEntryList) {
       OrderEntryList = orderEntryList;
  }
}
