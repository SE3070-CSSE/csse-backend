package csse.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderHttpController {

    private final OrderServiceFacade orderServiceFacade;

    @Autowired
    public OrderHttpController(OrderServiceFacadeImpl orderServiceFacade) {
        this.orderServiceFacade = orderServiceFacade;
    }

    @GetMapping("/orders")
    public List<PurchaseOrder> getAllOrdersEndpoint() {
        return orderServiceFacade.getAllOrders();
    }

    @DeleteMapping("/orders")
    public void dropTableEndpoint() {
        orderServiceFacade.dropTable();
    }

    @PostMapping("/orders")
    public ResponseEntity createOrderEndpoint(@RequestBody PurchaseOrder order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderServiceFacade.createPurchaseOrder(order));
    }

}
