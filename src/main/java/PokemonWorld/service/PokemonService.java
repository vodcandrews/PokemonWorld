package PokemonWorld.service;

import PokemonWorld.domain.Pokemon;
import PokemonWorld.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PokemonService {
    @Autowired
    private PokemonRepository pokemonRepository;


    private static List<Pokemon> pokemons = new ArrayList<Pokemon>();

    static {
        Pokemon pikacu = new Pokemon();
        pikacu.setName("Pikacu");
        pikacu.setId(1L);
        pokemons.add(pikacu);

        Pokemon eevee = new Pokemon();
        eevee.setId(2L);
        eevee.setName("Eevee");
        pokemons.add(eevee);

    }

    public List<Pokemon> getPokemons(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemonRepository.findAll().forEach(pokemons::add);
        return pokemons;
    }

    public List<Pokemon> savePokemons(){
        pokemonRepository.saveAll(pokemons);
        return pokemons;
    }

    public void savePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }
}
