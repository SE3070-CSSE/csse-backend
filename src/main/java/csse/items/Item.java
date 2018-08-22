package csse.items;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Item {

    @Id
    private String _id;
    private String itemName;
    private String category;
    private Double price;
    private String deliveryInformation;
    private boolean isRestricted;

    public Item(String itemName, String category, Double price,
                String deliveryInformation, boolean isRestricted) {
        this._id = _id;
        this.itemName = itemName;
        this.category = category;
        this.price = price;
        this.deliveryInformation = deliveryInformation;
        this.isRestricted = isRestricted;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDeliveryInformation() {
        return deliveryInformation;
    }

    public void setDeliveryInformation(String deliveryInformation) {
        this.deliveryInformation = deliveryInformation;
    }

    public boolean isRestricted() {
        return isRestricted;
    }

    public void setRestricted(boolean restricted) {
        isRestricted = restricted;
    }
}
