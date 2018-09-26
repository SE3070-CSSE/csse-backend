package csse.suppliers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Damsith Karunaratna(dammakaru@gmail.com) on 9/26/2018.
 */
@Service
public class SupplierService {

    private final SupplierDAO repository;

    @Autowired
    public SupplierService(SupplierDAO repository) {
        this.repository = repository;
    }

    void cleanDatabase() {
        repository.deleteAll();
    }

    void deleteSupliers(List<Supplier> suppliers) {
        this.repository.deleteAll(suppliers);
    }

    Supplier saveSupplier(Supplier i) {
        return repository.save(i);
    }

    List<Supplier> fetchAll() {
        return  repository.findAll();
    }

    Supplier updateSupplier(Supplier supplier) {
        return repository.save(supplier);
    }
}
