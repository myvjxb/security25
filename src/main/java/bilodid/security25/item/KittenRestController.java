package bilodid.security25.item;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
/*
@author   машуля
@project   security25
@class  ItemRestController
@version  1.0.0
@since 18.11.2025 - 21.03
*/
@RestController
@RequestMapping("/api/v1/kittens")
@AllArgsConstructor
public class KittenRestController {

    private final KittenService service;

    @GetMapping
    public List<Kitten> getItems() {
        return service.getAll();
    }@GetMapping("/{id}")
    public Kitten getOneItem(@PathVariable String id) {
        return service.getById(id);
    }@DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }
    @PostMapping
    public Kitten saveItem(@RequestBody Kitten kitten) {
        return service.create(kitten);
    }
    @PutMapping
    public Kitten update(@RequestBody Kitten kitten) {
        return service.update(kitten);
    }
}
