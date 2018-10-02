package csse.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderDAO repository;

    @Autowired
    public OrderService(OrderDAO repository) {
        this.repository = repository;
    }

    public void cleanDatabase() {
        repository.deleteAll();
    }


    public PurchaseOrder saveOrder(PurchaseOrder purchaseOrder) {
        return repository.save(purchaseOrder);
    }

    public List<PurchaseOrder> fetchAll() {
        return repository.findAll();
    }

}
