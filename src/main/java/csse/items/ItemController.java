package csse.items;

import csse.customer.Customer;
import csse.customer.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> retrieveAllItems() {
        return itemService.fetchAll();
    }

    @GetMapping("/items/{name}")
    public Item retrieveItem(@PathVariable String name) {
        return itemService.fetchByItemName(name);
    }

    @DeleteMapping("/items")
    public void dropTable() {
        itemService.cleanDatabase();
    }

    @PostMapping("/items")
    public ResponseEntity<Object> createItem(@RequestBody Item item) {
        Item savedItem = itemService.saveItem(item);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedItem.get_id()).toUri();

        return ResponseEntity.created(location).build();

    }

}
