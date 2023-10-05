package PokemonWorld;

import static org.assertj.core.api.Assertions.assertThat;

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
	public void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}
