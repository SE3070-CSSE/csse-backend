package csse.requests;

import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author Damsith Karunaratna(dammakaru@gmail.com) on 9/27/2018.
 */
public interface IRequestFacade {

    List<PurchaseRequest> getAllRequests();
    List<PurchaseRequest> getApprovedRequests();
    PurchaseRequest createRequest(PurchaseRequest request);
    List<PurchaseRequest> approveRequests(List<PurchaseRequest> purchaseRequests);
}
