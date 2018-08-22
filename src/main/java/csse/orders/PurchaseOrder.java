package csse.orders;


import csse.items.Item;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

public class PurchaseOrder {

    @Id
    private ObjectId _id;

    @DBRef
    private List<Item> items;

    private String supplierName;


    public PurchaseOrder(List<Item> items, String supplierName) {
        this.items = items;
        this.supplierName = supplierName;
    }

    public ObjectId get_id() {
        return _id;
    }

    public void set_id(ObjectId _id) {
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
}
