package csse.orders;

public class OrderItem {

	private String itemId;
	private String supplierId;
	private double orderLinePrice;
	private boolean received;
	
	public OrderItem(String itemId,String supplierId,double orderLinePrice,boolean received) {
		this.itemId = itemId;
		this.supplierId =supplierId;
		this.orderLinePrice=orderLinePrice;
		this.received = received;		
	}
	
	public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
    
    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId =supplierId;
    }
    
    public double getOrderLinePrice() {
        return orderLinePrice;
    }

    public void setOrderLinePrice(int orderLinePrice) {
        this.orderLinePrice = orderLinePrice;
    }
    
    public boolean isReceived() {
        return received;
    }

    public void setReceived(boolean received) {
        this.received = received;
    }
    
}
