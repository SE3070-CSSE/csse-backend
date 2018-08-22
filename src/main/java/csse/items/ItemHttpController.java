package csse.items;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class ItemHttpController {

    private final ItemService itemService;

    @Autowired
    public ItemHttpController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/items")
    public List<Item> getAllItemsEndpoint() {
        return itemService.fetchAll();
    }

    @GetMapping("/items/{name}")
    public Item getItemByNameEndpoint(@PathVariable String name) {
        return itemService.fetchByItemName(name);
    }

    @DeleteMapping("/items")
    public void dropTableEndpoint() {
        itemService.cleanDatabase();
    }

    @PostMapping("/items")
    public ResponseEntity<Object> createItemEndpoint(@RequestBody Item item) {
        return ResponseEntity.status(HttpStatus.CREATED).body(itemService.saveItem(item));
    }

}
