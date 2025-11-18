package bilodid.security25.item;

/*
@author   машуля
@project   security25
@class  Item
@version  1.0.0
@since 18.11.2025 - 21.01
*/
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString

public class Kitten {

    @Id
    private String id;
    private String name;
    private String description;

    public Kitten(String name, String description) {
        this.name = name;
        this.description = description;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof Kitten kitten)) return false;

        return getId().equals(kitten.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();

}}
