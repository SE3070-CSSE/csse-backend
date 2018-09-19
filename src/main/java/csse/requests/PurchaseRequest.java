package csse.requests;

import csse.orders.PurchaseOrder;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

public class PurchaseRequest {

    @Id
    private String id;
    @DBRef
    private List<RequestItem> requestLineItems;
    private List<PurchaseOrder> purchaseOrders;
    private String requestStatus;
    private String requestedBy;
    private String deliveryAddress;
    private Date createdOn;
    private Date neededOn;
    private boolean isDraftRequest;

    public PurchaseRequest(
            List<RequestItem> requestLineItems, List<PurchaseOrder> purchaseOrders,
            String requestStatus, String requestedBy, String deliveryAddress,
            Date createdOn, Date neededOn, boolean isDraftRequest
    ) {
        this.requestLineItems = requestLineItems;
        this.purchaseOrders = purchaseOrders;
        this.requestStatus = requestStatus;
        this.requestedBy = requestedBy;
        this.deliveryAddress = deliveryAddress;
        this.createdOn = createdOn;
        this.neededOn = neededOn;
        this.isDraftRequest = isDraftRequest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<RequestItem> getRequestLineItems() {
        return requestLineItems;
    }

    public void setRequestLineItems(List<RequestItem> requestLineItems) {
        this.requestLineItems = requestLineItems;
    }

    public List<PurchaseOrder> getPurchaseOrders() {
        return purchaseOrders;
    }

    public void setPurchaseOrders(List<PurchaseOrder> purchaseOrders) {
        this.purchaseOrders = purchaseOrders;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestedBy() {
        return requestedBy;
    }

    public void setRequestedBy(String requestedBy) {
        this.requestedBy = requestedBy;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getNeededOn() {
        return neededOn;
    }

    public void setNeededOn(Date neededOn) {
        this.neededOn = neededOn;
    }

    public boolean isDraftRequest() {
        return isDraftRequest;
    }

    public void setDraftRequest(boolean draftRequest) {
        isDraftRequest = draftRequest;
    }

}