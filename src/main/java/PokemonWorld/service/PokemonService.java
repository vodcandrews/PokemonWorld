package PokemonWorld.service;

import PokemonWorld.domain.Pokemon;
import PokemonWorld.domain.PokemonType;
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
        pikacu.setHeight(40.6);
        pikacu.setWeakness("Ground");
        pikacu.setType(PokemonType.ELECTRIC);
        pikacu.setAbility("Static");
        pokemons.add(pikacu);

        Pokemon eevee = new Pokemon();
        eevee.setName("Eevee");
        eevee.setHeight(30.5);
        eevee.setWeakness("Fighting");
        eevee.setType(PokemonType.NORMAL);
        eevee.setAbility("Adaptability");
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

    public Pokemon getPokemonById(Long id){
        return pokemonRepository.getReferenceById(id);
    }

    public void savePokemon(Pokemon pokemon) {
        pokemonRepository.save(pokemon);
    }

    public void deletePokemon(Long id) {
        Pokemon pokemon = getPokemonById(id);
        pokemonRepository.delete(pokemon);
    }
}
