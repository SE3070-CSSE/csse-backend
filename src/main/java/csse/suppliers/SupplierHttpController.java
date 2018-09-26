package csse.suppliers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Damsith Karunaratna(dammakaru@gmail.com) on 9/26/2018.
 */
@RestController
public class SupplierHttpController {

    private SupplierService supplierService;

    @Autowired
    public SupplierHttpController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliersEndpoint() {
        return supplierService.fetchAll();
    }

    @PostMapping("/suppliers")
    public ResponseEntity<Object> createItemEndpoint(@RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.saveSupplier(supplier));
    }

}
