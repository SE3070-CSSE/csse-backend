package csse.orders;

import csse.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class OrderHttpController {

    private final OrderService orderService;

    @Autowired
    public OrderHttpController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/orders")
    public List<PurchaseOrder> retrieveAllItems() {
        return orderService.fetchAll();
    }

    @DeleteMapping("/orders")
    public void dropTable() {
        orderService.cleanDatabase();
    }

    @PostMapping("/orders")
    public ResponseEntity createItem(@RequestBody PurchaseOrder order) {
        return ResponseEntity.status(HttpStatus.CREATED).body(orderService.saveOrder(order));
    }

}
