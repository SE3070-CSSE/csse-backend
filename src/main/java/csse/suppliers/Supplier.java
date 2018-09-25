package csse.suppliers;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import csse.items.Item;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.List;

/**
 * Created by Damma on 14-Sep-18.
 */
public class Supplier {

    @Id
    private String _id;
    private String supplierName;
    private String email;
    private String address;
    private String contactNumber;
    @DBRef
    private List<Item> items;

    @JsonCreator
    public Supplier(
            @JsonProperty("supplierName") String supplierName,
            @JsonProperty("email") String email,
            @JsonProperty("address") String address,
            @JsonProperty("contactNumber") String contactNumber,
            @JsonProperty("items") List<Item> items) {
        this.supplierName = supplierName;
        this.email = email;
        this.address = address;
        this.contactNumber = contactNumber;
        this.items = items;
    }

    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }
}
