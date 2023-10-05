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

    public List<Pokemon> getPokemons(){
        List<Pokemon> pokemons = new ArrayList<>();
        pokemonRepository.findAll().forEach(pokemons::add);
        return pokemons;
    }

    public String welcomeToPokemonWorld(){
        return "Welcome to the Pokemon World!";
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

    public Pokemon updatePokemon(Long id, Pokemon updatedPokemon) {
        Pokemon existingPokemon = pokemonRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pokemon not found with id: " + id));

        existingPokemon.setName(updatedPokemon.getName());
        existingPokemon.setHeight(updatedPokemon.getHeight());
        existingPokemon.setWeakness(updatedPokemon.getWeakness());
        existingPokemon.setType(updatedPokemon.getType());
        existingPokemon.setAbility(updatedPokemon.getAbility());

        return pokemonRepository.save(existingPokemon);

    }
}
