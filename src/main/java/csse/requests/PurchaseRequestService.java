package csse.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseRequestService {

    private final RequestDAO repository;

    @Autowired
    public PurchaseRequestService(RequestDAO repository) {
        this.repository = repository;
    }

    void cleanDatabase() {
        repository.deleteAll();
    }

    PurchaseRequest createRequest(PurchaseRequest purchaseRequest) {
        RequestStatus status = RequestStatus.PENDING;
        purchaseRequest.setRequestStatus(status.name());
        purchaseRequest.setCreatedOn(new Date());
        return repository.save(purchaseRequest);
    }

    List<PurchaseRequest> fetchAll() {
        return  repository.findAll();
    }

}
