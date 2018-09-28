package csse.orders;

import csse.OrderFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderHttpController {

    private final IOrderFacade orderService;

    @Autowired
    public OrderHttpController(OrderFacadeImpl orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<PurchaseOrder> getAllOrdersEndpoint() {
        return orderService.getAllOrders();
    }

    @PostMapping("/orders")
    public ResponseEntity createOrderEndpoint(@RequestBody PurchaseOrder order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.createPurchaseOrder(order));
    }

}
