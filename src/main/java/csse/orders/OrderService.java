package csse.orders;

import csse.requests.PurchaseRequestService;
import csse.requests.RequestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class OrderService {

    private final OrderDAO repository;
    private PurchaseRequestService requestService;

    @Autowired
    public OrderService(OrderDAO repository, PurchaseRequestService requestService) {
        this.repository = repository;
        this.requestService = requestService;
    }

    void cleanDatabase() {
        repository.deleteAll();
    }

    PurchaseOrder createPurchaseOrder(PurchaseOrder purchaseOrder) {

        OrderStatus status = OrderStatus.PENDING_DELIVERY;
        purchaseOrder.setStatus(status.name());
        purchaseOrder.setCreatedOn(new Date());
        this.requestService.updateRequest(purchaseOrder.getPurchaseRequest());
        return repository.save(purchaseOrder);
    }

    List<PurchaseOrder> fetchAll() {
        return  repository.findAll();
    }

}
