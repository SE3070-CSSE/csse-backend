package csse.orders;


import csse.items.Item;
import csse.requests.PurchaseRequest;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

public class PurchaseOrder {

    @Id
    private String _id;
    @DBRef
    private PurchaseRequest purchaseRequest;
    private Date createdOn;
    private String status;
    private List<OrderLineItem> orderItems;
    private double totalPrice;

    public PurchaseOrder(
            PurchaseRequest purchaseRequest, Date createdOn, String status,
            List<OrderLineItem> orderItems, double totalPrice
    ) {
        this.purchaseRequest = purchaseRequest;
        this.createdOn = createdOn;
        this.status = status;
        this.orderItems = orderItems;
        this.totalPrice = totalPrice;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public PurchaseRequest getPurchaseRequest() {
        return purchaseRequest;
    }

    public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
        this.purchaseRequest = purchaseRequest;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<OrderLineItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderLineItem> orderItems) {
        this.orderItems = orderItems;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
}
