package csse.requests;

import csse.OrderFacadeImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RequestHttpController {

    private final IRequestFacade purchaseRequestService;

    @Autowired
    public RequestHttpController(OrderFacadeImpl purchaseRequestService) {
        this.purchaseRequestService = purchaseRequestService;
    }

    @GetMapping("/requests")
    public List<PurchaseRequest> getAllRequestsEndpoint() {
        return purchaseRequestService.getAllRequests();
    }

    @GetMapping("/requests/approved")
    public List<PurchaseRequest> getApprovedRequests() {
        return purchaseRequestService.getApprovedRequests();
    }

    @PostMapping("/requests")
    public ResponseEntity createRequestEndpoint(@RequestBody PurchaseRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(purchaseRequestService.createRequest(request));
    }

    @PutMapping("/requests/approve")
    public ResponseEntity<Object> approveItemEndpoint(@RequestBody List<PurchaseRequest> purchaseRequests) {
        return ResponseEntity.status(HttpStatus.OK).body(purchaseRequestService.approveRequests(purchaseRequests));
    }
}
