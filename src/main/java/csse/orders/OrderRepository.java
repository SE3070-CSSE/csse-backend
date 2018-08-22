package csse.orders;

import csse.items.Item;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface OrderRepository extends MongoRepository<PurchaseOrder, String> {

}
