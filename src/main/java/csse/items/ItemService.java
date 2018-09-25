package csse.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Damsith Karunaratna(dammakaru@gmail.com)
 */
@Service
public class ItemService {

    private final ItemDAO repository;

    @Autowired
    public ItemService(ItemDAO repository) {
        this.repository = repository;
    }

    void cleanDatabase() {
        repository.deleteAll();
    }

    void deleteItems(List<Item> items) {
        this.repository.deleteAll(items);
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

    Item updateItem(Item item) {
        return repository.save(item);
    }
}
