package csse.grn;

import csse.orders.OrderDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class GrnService  {

    private final GrnDAO repository;

    @Autowired
    public GrnService(GrnDAO repository) {
        this.repository = repository;
    }

    void cleanDatabase() {
        repository.deleteAll();
    }

    grn saveGrn(grn grn) {
        GrnStatus status = GrnStatus.PENDING_PAYMENT;
        grn.setPaymentStatus(status.name());
        grn.setRecievedOn(new Date());
        return repository.save(grn); }

    List<grn> fetchAll() {
        return  repository.findAll();
    }
}
