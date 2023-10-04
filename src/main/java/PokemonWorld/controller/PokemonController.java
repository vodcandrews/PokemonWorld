package PokemonWorld.controller;

import PokemonWorld.domain.Pokemon;
import PokemonWorld.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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



    @PostMapping("/addPokemon")
    public void addPokemon(@RequestBody Pokemon pokemon) {
        pokemonService.savePokemon(pokemon);
    }

}
