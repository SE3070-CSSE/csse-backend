package csse.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderDAO repository;

    @Autowired
    public OrderService(OrderDAO repository) {
        this.repository = repository;
    }

    void cleanDatabase() {
        repository.deleteAll();
    }

    PurchaseOrder saveOrder(PurchaseOrder purchaseOrder) {
        OrderStatus status = OrderStatus.PENDING_DELIVERY;
        purchaseOrder.setStatus(status.name());
        purchaseOrder.setCreatedOn(new Date());
        return repository.save(purchaseOrder);
    }

    List<PurchaseOrder> fetchAll() {
        return  repository.findAll();
    }

}
