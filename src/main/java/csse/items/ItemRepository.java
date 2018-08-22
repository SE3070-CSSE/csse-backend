package csse.items;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ItemRepository extends MongoRepository<Item, String> {

    public Item findByItemName(String itemName);
    public List<Item> findByCategory(String category);

}
