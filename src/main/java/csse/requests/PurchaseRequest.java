package csse.requests;

import csse.items.Item;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.Date;
import java.util.List;

/**
 * Created by DAMMA on 9/12/2018.
 */
public class PurchaseRequest {

    @Id
    private String id;
    @DBRef
    private List<Item> items;
    private String requestStatus;
    private Date requestedOn;
    private Date requiredOn;
    private boolean isDraftRequest;

    public PurchaseRequest(List<Item> items,
                         String requestStatus,
                         Date requestedOn,
                         boolean isDraftRequest) {
        this.items = items;
        this.requestStatus = requestStatus;
        this.requestedOn = requestedOn;
        this.isDraftRequest = isDraftRequest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public Date getRequestedOn() {
        return requestedOn;
    }

    public void setRequestedOn(Date requestedOn) {
        this.requestedOn = requestedOn;
    }

    public Date getRequiredOn() {
        return requiredOn;
    }

    public void setRequiredOn(Date requiredOn) {
        this.requiredOn = requiredOn;
    }

    public boolean isDraftRequest() {
        return isDraftRequest;
    }

    public void setDraftRequest(boolean draftRequest) {
        isDraftRequest = draftRequest;
    }

}
