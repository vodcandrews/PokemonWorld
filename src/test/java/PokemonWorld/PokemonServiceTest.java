package PokemonWorld;
import PokemonWorld.domain.Pokemon;
import PokemonWorld.domain.PokemonType;
import PokemonWorld.repository.PokemonRepository;
import PokemonWorld.service.PokemonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PokemonServiceTest     {


    @InjectMocks
    private PokemonService pokemonService;

    @Mock
    private PokemonRepository pokemonRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);

        // Mock the behavior of the PokemonRepository
        when(pokemonRepository.findAll()).thenReturn(getMockedPokemons());
        when(pokemonRepository.getReferenceById(1L)).thenReturn(getMockedPokemon(1L));
    }


    @Test
    public void testSavePokemons() {
        List<Pokemon> savedPokemons = pokemonService.savePokemons();
        verify(pokemonRepository, times(1)).saveAll(any());
        assertEquals(2, savedPokemons.size());
        // You can add more assertions here if needed.
    }

    @Test
    public void testGetPokemonById() {
        Pokemon pokemon = pokemonService.getPokemonById(1L);
        assertEquals("Pikacu", pokemon.getName());
        // You can add more assertions to check the properties of the returned Pokemon.
    }

    // Add more test methods for other service methods as needed

    private List<Pokemon> getMockedPokemons() {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(getMockedPokemon(1L));
        pokemons.add(getMockedPokemon(2L));
        return pokemons;
    }

    private Pokemon getMockedPokemon(Long id) {
        Pokemon pokemon = new Pokemon();
        pokemon.setId(id);
        pokemon.setName("Eevee");
        pokemon.setHeight(30.5);
        pokemon.setWeakness("Fighting");
        pokemon.setType(PokemonType.NORMAL);
        pokemon.setAbility("Adaptability");
        // Set other properties as needed for testing
        return pokemon;
    }

}
