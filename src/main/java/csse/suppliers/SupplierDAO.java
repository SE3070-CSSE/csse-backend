package csse.suppliers;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * @author Damsith Karunaratna(dammakaru@gmail.com) on 9/26/2018.
 */
public interface SupplierDAO  extends MongoRepository<Supplier, String> {


}
