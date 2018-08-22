package csse.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository repository;

    @Autowired
    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    void cleanDatabase() {
        repository.deleteAll();
    }

    PurchaseOrder saveOrder(PurchaseOrder purchaseOrder) {
        OrderStatus status = OrderStatus.PENDING;
        purchaseOrder.setOrderStatus(status.name());
        purchaseOrder.setOrderedOn(new Date());
        return repository.save(purchaseOrder);
    }

    List<PurchaseOrder> fetchAll() {
        return  repository.findAll();
    }

}
