package csse.requests;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestHttpController {

    private final PurchaseRequestService purchaseRequestService;

    @Autowired
    public RequestHttpController(PurchaseRequestService purchaseRequestService) {
        this.purchaseRequestService = purchaseRequestService;
    }

    @GetMapping("/requests")
    public List<PurchaseRequest> getAllRequestsEndpoint() {
        return purchaseRequestService.fetchAll();
    }

    @DeleteMapping("/requests")
    public void dropTableEndpoint() {
        purchaseRequestService.cleanDatabase();
    }

    @PostMapping("/requests")
    public ResponseEntity createRequestEndpoint (@RequestBody PurchaseRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseRequestService.createRequest(request));
    }
}
