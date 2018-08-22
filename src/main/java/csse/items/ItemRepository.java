package csse.items;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {

    Item findByItemName(String itemName);

    List<Item> findByCategory(String category);

}
