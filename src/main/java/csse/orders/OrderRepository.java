package csse.orders;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<PurchaseOrder, String> {

}
