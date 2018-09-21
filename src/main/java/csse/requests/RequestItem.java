package csse.requests;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Damma on 14-Sep-18.
 */
public class RequestItem {

    private String itemName;
    private int quantity;
    private boolean POCreated;

    @JsonCreator
    public RequestItem(
            @JsonProperty("itemName") String itemName,
            @JsonProperty("quantity") int quantity,
            @JsonProperty("POCreated") boolean POCreated) {
        this.itemName = itemName;
        this.quantity = quantity;
        this.POCreated = POCreated;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isPOCreated() {
        return POCreated;
    }

    public void setPOCreated(boolean POCreated) {
        this.POCreated = POCreated;
    }
}
