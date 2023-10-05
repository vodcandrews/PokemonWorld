package PokemonWorld.domain;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
public class Pokemon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String weakness;

    private String ability;

    private Double height;

    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(255)")
    private PokemonType type;

    public Pokemon(Long id, String name, String weakness, String ability, Double height, PokemonType type) {
        this.id = id;
        this.name = name;
        this.weakness = weakness;
        this.ability = ability;
        this.height = height;
        this.type = type;
    }

    public Pokemon() {

    }

}
