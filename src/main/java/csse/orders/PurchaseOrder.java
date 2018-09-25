package csse.orders;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import csse.requests.RequestItem;

import java.util.Date;
import java.util.List;

public class PurchaseOrder {
	
	@Id
	private String id;
	@DBRef
    private List<OrderItem> orderLineItems;
    private String orderStatus;
	private String supplierName;
    private Date orderedOn;
    private boolean isDraft;
    
    public PurchaseOrder(
    		List<OrderItem> orderLineItems, String orderStatus,
    		String SupplierName, Date orderedOn, boolean isDraft
    		) {
    	this.orderLineItems = orderLineItems;
    	this.orderStatus = orderStatus;
    	this.supplierName = supplierName;
    	this.orderedOn = orderedOn;
    	this.isDraft = isDraft;
    	
    }
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public List<OrderItem> getOrderLineItems() {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderItem> orderLineItems) {
        this.orderLineItems = orderLineItems;
    }
    
    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }
 
    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public Date getOrderedOn() {
        return orderedOn;
    }

    public void setOrderedOn(Date orderedOn) {
        this.orderedOn = orderedOn;
    }

    public boolean isDraft() {
        return isDraft;
    }

    public void setDraft(boolean draft) {
        isDraft = draft;
    }

}
