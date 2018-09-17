package csse.items;

/**
 * @author Damsith Karunaratna(dammakaru@gmail.com) on 9/17/2018.
 */
import csse.suppliers.Supplier;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;

public class Item {

    @Id
    private String _id;
    private String itemName;
    @DBRef
    private Supplier supplier;
    private String category;
    private Double price;
    private String description;

    public Item(String itemName, Supplier supplier, String category, Double price, String description) {
        this.itemName = itemName;
        this.supplier = supplier;
        this.category = category;
        this.price = price;
        this.description = description;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
