package com.akshit.sale.pojo;

import javax.persistence.*;

@Entity
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int item;
    @Column(nullable = false)
    private int orderpojoid;
    @Column(nullable = false)
    private int productpojoid;
    @Column(nullable = false)
    private int quantity;
    @Column(nullable = false)
    private double mrp;

    public double getMrp() {
        return mrp;
    }

    public void setMrp(double mrp) {
        this.mrp = mrp;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getOrder_id() {
        return orderpojoid;
    }

    public void setOrder_id(int order_id) {
        this.orderpojoid = order_id;
    }

    public int getProduct_id() {
        return productpojoid;
    }

    public void setProduct_id(int product_id) {
        this.productpojoid = product_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}
