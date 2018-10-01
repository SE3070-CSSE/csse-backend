package csse.logs;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogDAO extends MongoRepository<Log, String>{

}
