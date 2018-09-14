package csse.orders;


import csse.items.Item;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

public class PurchaseOrder {

    @Id
    private String _id;
    @DBRef
    private List<Item> items;
    private String supplierName;
    private String orderStatus;
    private Date orderedOn;
    private boolean isDraftPurchaseOrder;

    public PurchaseOrder(List<Item> items,
                         String supplierName,
                         String orderStatus,
                         Date orderedOn,
                         boolean isDraftPurchaseOrder) {
        this.items = items;
        this.supplierName = supplierName;
        this.orderStatus = orderStatus;
        this.orderedOn = orderedOn;
        this.isDraftPurchaseOrder = isDraftPurchaseOrder;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderedOn() {
        return orderedOn;
    }

    public void setOrderedOn(Date orderedOn) {
        this.orderedOn = orderedOn;
    }

    public boolean isDraftPurchaseOrder() {
        return isDraftPurchaseOrder;
    }

    public void setDraftPurchaseOrder(boolean draftPurchaseOrder) {
        isDraftPurchaseOrder = draftPurchaseOrder;
    }
}