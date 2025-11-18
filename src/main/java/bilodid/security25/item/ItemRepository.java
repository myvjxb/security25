package bilodid.security25.item;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/*
@author   машуля
@project   security25
@class  ItemRepository
@version  1.0.0
@since 18.11.2025 - 21.02
*/
@Repository
public interface ItemRepository extends MongoRepository<Item, String> {
}
