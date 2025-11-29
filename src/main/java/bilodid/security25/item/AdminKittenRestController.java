package bilodid.security25.item;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
/*
@author   машуля
@project   security25
@class  AdminKittenRestController
@version  1.0.0
@since 19.11.2025 - 22.35
*/

@RestController
@RequestMapping("/api/v1/admin/kittens")
@AllArgsConstructor
public class AdminKittenRestController {
    private final KittenService service;

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        service.deleteById(id);
    }

    @PostMapping
    public Kitten createCat(@RequestBody Kitten kitten) {
        return service.create(kitten);
    }

    @PutMapping
    public Kitten update(@RequestBody Kitten kitten) {
        return service.update(kitten);
    }

    @GetMapping("admin")
    public String HelloAdmin(){
        return "Hello Admin!";
    }
}
