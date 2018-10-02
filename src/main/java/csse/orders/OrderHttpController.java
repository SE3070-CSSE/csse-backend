package csse.orders;

import csse.IOrderServicesFacade;
import csse.OrderServicesFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrderHttpController {

    private final IOrderServicesFacade orderService;

    @Autowired
    public OrderHttpController(OrderServicesFacade orderService) {
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
