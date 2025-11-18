package bilodid.security25.item;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
/*
@author   машуля
@project   security25
@class  ItemService
@version  1.0.0
@since 18.11.2025 - 21.04
*/
@Service
@AllArgsConstructor
public class KittenService {

    private final KittenRepository Repository;

    private List<Kitten> kittens;

    @PostConstruct
    void init() {
        kittens.add(new Kitten("1","Mikki","Black"));
        kittens.add(new Kitten("2","Minnie","White"));
        kittens.add(new Kitten("3","Mouse","Brown"));
        Repository.saveAll(kittens);
    }

    public List<Kitten> getAll() {
        return Repository.findAll();
    }

    public Kitten getById(String id) {
        return Repository.findById(id).orElse(null);
    }

    public void deleteById(String id) {
        Repository.deleteById(id);
    }

    public Kitten create(Kitten kitten) {
        return Repository.save(kitten);
    }

    public Kitten update(Kitten kitten) {
        return Repository.save(kitten);
    }
}
