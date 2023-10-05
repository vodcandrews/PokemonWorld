package PokemonWorld.controller;

import PokemonWorld.domain.Pokemon;
import PokemonWorld.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;


    @GetMapping("/")
    public List<Pokemon> getStarterPokemons(){
        return pokemonService.savePokemons();

    }

    @GetMapping("/pokemons")
    public List<Pokemon> getPokemons(){
        return pokemonService.getPokemons();

    }

    @DeleteMapping("/deletepokemon/{id}")
    public void deletePokemon(@PathVariable Long id){
        pokemonService.deletePokemon(id);
    }


    @PostMapping("/addPokemon")
    public void addPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.savePokemon(pokemon);
    }

    @PutMapping("updatePokemon/{id}")
    public Pokemon updatePokemon(@PathVariable Long id, @RequestBody Pokemon updatedPokemon){
        return pokemonService.updatePokemon(id, updatedPokemon);
    }

}

