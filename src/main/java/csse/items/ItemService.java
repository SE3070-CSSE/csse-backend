package csse.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository repository;

    @Autowired
    public ItemService(ItemRepository repository) {
        this.repository = repository;
    }

    void cleanDatabase() {
        repository.deleteAll();
    }

    Item saveItem(Item i) {
        return repository.save(i);
    }

    List<Item> fetchAll() {
        return  repository.findAll();
    }

    Item fetchByItemName(String itemName) {
        return repository.findByItemName(itemName);
    }

    public List<Item> fetchByCategory(String category) {
        return repository.findByCategory(category);
    }
}
