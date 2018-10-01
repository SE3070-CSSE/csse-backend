package csse.logs;

import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import csse.orders.OrderStatus;
import csse.orders.PurchaseOrder;

public class Message {
	
	@Id
	private String _id;
	
	@NotNull	
	@Indexed(unique=true)
	private String deliveryID;
	
	@NotNull
	@DBRef
	private PurchaseOrder order;
	
	@NotNull
	private double dQty;
	
	@NotNull
	public OrderStatus status;

	@JsonCreator
	public Message(@JsonProperty("deliveryID") String deliveryID, 
			@JsonProperty("order") PurchaseOrder order, 
			@JsonProperty("dQty") double dQty,
			@JsonProperty("status") OrderStatus status) {
		this.deliveryID = deliveryID;
		this.order = order;
		this.dQty = dQty;
		this.status = status;
	}

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getDeliveryID() {
		return deliveryID;
	}

	public void setDeliveryID(String deliveryID) {
		this.deliveryID = deliveryID;
	}

	public PurchaseOrder getOrder() {
		return order;
	}

	public void setOrder(PurchaseOrder order) {
		this.order = order;
	}

	public double getdQty() {
		return dQty;
	}

	public void setdQty(double dQty) {
		this.dQty = dQty;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Message [_id=" + _id + ", deliveryID=" + deliveryID + ", order=" + order + ", dQty=" + dQty
				+ ", status=" + status + "]";
	}		
}
