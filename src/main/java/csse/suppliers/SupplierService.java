package csse.suppliers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierDAO repository;

    @Autowired
    public SupplierService(SupplierDAO repository){this.repository=repository;}

    void cleanDatabase() {
        repository.deleteAll();
    }

    Supplier saveSupplier(Supplier s) {
        return repository.save(s);
    }

    List<Supplier> FetchAll(){ return  repository.findAll();}

    Supplier findSupplierByName(String supplierName){
        return repository.findSupplierByName(supplierName);
    }


}
