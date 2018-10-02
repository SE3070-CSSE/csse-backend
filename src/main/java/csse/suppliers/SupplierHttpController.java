package csse.suppliers;

import csse.items.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SupplierHttpController {

    private final SupplierService supplierService;

    @Autowired
    public SupplierHttpController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping("/suppliers")
    public List<Supplier> getAllSuppliersEndpoint() {
        return supplierService.FetchAll();
    }

    @GetMapping("/suppliers/{name}")
    public Supplier getSupplierByNameEndpoint(@PathVariable String name) {
        return supplierService.findSupplierByName(name);
    }

    @DeleteMapping("/suppliers")
    public void dropTableEndpoint() {
        supplierService.cleanDatabase();
    }

    @PostMapping("/suppliers")
    public ResponseEntity<Object> createSupplierEndpoint(@RequestBody Supplier supplier) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.saveSupplier(supplier));
    }





}
