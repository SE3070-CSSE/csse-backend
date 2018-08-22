package csse.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    PurchaseOrder saveOrder(PurchaseOrder i) {
        return repository.save(i);
    }

    List<PurchaseOrder> fetchAll() {
        return repository.findAll();
    }

}
