package csse.orders;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import csse.requests.PurchaseRequest;
import csse.requests.RequestDAO;
import csse.requests.RequestStatus;

@Service
public class PurchaseOrderService {

		private final OrderDAO repository;
		
		@Autowired
	    public PurchaseOrderService(OrderDAO  repository) {
	        this.repository = repository;
	    }
		
		 void cleanDatabase() {
		        repository.deleteAll();
		 }
		 
		 PurchaseOrder createRequest(PurchaseOrder purchaseOrder) {
		        OrderStatus status = OrderStatus.PENDING;
		        purchaseOrder.setRequestStatus(status.name());
		        return repository.save(purchaseOrder);
		    }

		    List<PurchaseOrder> fetchAll() {
		        return repository.findAll();
		    }
}
