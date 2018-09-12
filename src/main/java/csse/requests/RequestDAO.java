package csse.requests;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface RequestDAO extends MongoRepository<PurchaseRequest, String> {

}
