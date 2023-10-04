package PokemonWorld.domain;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Generated;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Pokemon {

    @Getter
    @Setter
    @Id
    private Long id;

    @Setter
    @Getter
    private String name;

    public Pokemon(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Pokemon() {

    }

}
