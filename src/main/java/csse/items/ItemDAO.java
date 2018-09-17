package csse.items;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * @author Damsith Karunaratna(dammakaru@gmail.com) on 9/17/2018.
 */
public interface ItemDAO extends MongoRepository<Item, String> {

    Item findByItemName(String itemName);
    List<Item> findByCategory(String category);

}
