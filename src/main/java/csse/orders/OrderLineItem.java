package csse.orders;

import csse.items.Item;
import org.springframework.data.mongodb.core.mapping.DBRef;

/**
 * Created by Damma on 14-Sep-18.
 */
public class OrderLineItem {

    @DBRef
    private Item item;
    private int quantity;
    private double orderLinePrice;
    private boolean received;

    public OrderLineItem(Item item, int quantity, double orderLinePrice, boolean received) {
        this.item = item;
        this.quantity = quantity;
        this.orderLinePrice = orderLinePrice;
        this.received = received;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getOrderLinePrice() {
        return orderLinePrice;
    }

    public void setOrderLinePrice(double orderLinePrice) {
        this.orderLinePrice = orderLinePrice;
    }

    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }
}
