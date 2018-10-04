package csse.suppliers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private final SupplierDAO repository;

    @Autowired
    public SupplierService(SupplierDAO repository){this.repository=repository;}

    public void cleanDatabase() {
        repository.deleteAll();
    }

    public Supplier saveSupplier(Supplier s) {
        return repository.save(s);
    }

    public List<Supplier> FetchAll(){ return  repository.findAll();}

    public Supplier findSupplierByName(String supplierName){
        return repository.findBySupplierName(supplierName);
    }


}
