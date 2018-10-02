package csse.grn;

import csse.orders.OrderService;
import csse.orders.PurchaseOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GrnHttpController {

    private final GrnService grnService;

    @Autowired
    public GrnHttpController(GrnService grnService) {
        this.grnService = grnService;
    }

    @GetMapping("/Grn")
    public List<grn> getAllGRNEndpoint() {
        return grnService.fetchAll();
    }

    @DeleteMapping("/Grn")
    public void dropTableEndpoint() {
        grnService.cleanDatabase();
    }

    @PostMapping("/Grn")
    public ResponseEntity createGrnEndpoint(@RequestBody grn grn) {
        return ResponseEntity.status(HttpStatus.CREATED).body(grnService.saveGrn(grn));
    }
}
