package bilodid.security25.item;

import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @GetMapping("/hello/user")
    @PreAuthorize("hasAnyRole('USER')")
    public String helloUser() {
        return "Hello User!";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("hello/admin")
    public String helloAdmin() {
        return "Hello Admin!";
    }

    @PreAuthorize("hasAnyRole('USER', 'ADMIN')")
    @GetMapping("hello/unknown")
    public String helloUnknown() {
        return "Hello Unknown!";
    }

    @GetMapping("hello/stranger")
    public String helloStranger() {
        return "Hello Stranger!";
    }
    @PreAuthorize("hasRole('SUPERADMIN')")
    @GetMapping("hello/superadmin")
    public String helloSuperAdmin() {
        return "Hello SuperAdmin!";
    }
}
