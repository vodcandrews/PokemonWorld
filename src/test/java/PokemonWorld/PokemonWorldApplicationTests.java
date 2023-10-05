package PokemonWorld;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import PokemonWorld.controller.PokemonController;
import PokemonWorld.service.PokemonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class PokemonWorldApplicationTests {

	@Autowired
	private PokemonController controller;

	@Autowired
	private PokemonService service;

	@Test
	public void testGreeting() {
		String greeting = service.welcomeToPokemonWorld();
		assertEquals("Welcome to the Pokemon World!", greeting);
	}
	@Test
	public void testGreetingAgain() {
		String greeting = service.welcomeToPokemonWorld();
		assertNotNull(greeting);
	}



}
