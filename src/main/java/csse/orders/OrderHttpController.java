package csse.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import csse.requests.PurchaseRequest;

import java.util.List;

@RestController
public class OrderHttpController {
	
	private final PurchaseOrderService purchaseOrderService;
	
	@Autowired
	public OrderHttpController(PurchaseOrderService purchaseOrderService) {
		this.purchaseOrderService = purchaseOrderService;
	}
	
	@GetMapping("/requests")
    public List<PurchaseOrder> getAllOrdersEndpoint() {
        return purchaseOrderService.fetchAll();
    }

    @DeleteMapping("/requests")
    public void dropTableEndpoint() {
        purchaseOrderService.cleanDatabase();
    }

    @PostMapping("/requests")
    public ResponseEntity createOrderEndpoint (@RequestBody PurchaseOrder order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseOrderService.createOrder(order));
    }

}
