package csse.grn;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface GrnDAO extends MongoRepository<grn, String> {
}
