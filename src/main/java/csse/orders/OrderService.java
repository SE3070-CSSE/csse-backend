package csse.orders;

import csse.requests.PurchaseRequest;
import csse.requests.PurchaseRequestService;
import csse.requests.RequestItem;
import csse.requests.RequestStatus;
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

        purchaseOrder.setStatus(OrderStatus.PENDING_DELIVERY.name());
        purchaseOrder.setCreatedOn(new Date());
        if (ordersCreatedForAllRequestItems(purchaseOrder.getPurchaseRequest())) {
            purchaseOrder.getPurchaseRequest().setRequestStatus(RequestStatus.ORDERED.name());
        }
        this.requestService.updateRequest(purchaseOrder.getPurchaseRequest());
        return repository.save(purchaseOrder);
    }

    private boolean ordersCreatedForAllRequestItems(PurchaseRequest request) {
        for (RequestItem item : request.getRequestLineItems()) {
            if (!item.isPOCreated()) return false;
        }
        return true;
    }

    List<PurchaseOrder> fetchAll() {
        return repository.findAll();
    }

}
