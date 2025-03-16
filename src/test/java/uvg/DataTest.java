package uvg;

import java.util.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class DataTest {

    @Test
    public void testAgregarPokemonColeccion() {
        Data data = new Data(1);
        data.agregarPokemonColeccion("Pikachu");
        assertTrue(data.getListaPokemon().containsKey("Pikachu"), "Pikachu debería estar en la colección");
    }

    @Test
    public void testMostrarPokemonColeccion() {
        Data data = new Data(1);
        data.agregarPokemonColeccion("Pikachu");
        data.mostrarPokemonColeccion("Pikachu");
    }

    @Test
    public void testMostrarPokemonPorTipo() {
        Data data = new Data(1);
        data.agregarPokemonColeccion("Pikachu");
        data.mostrarPokemonPorTipo();
    }

    @Test
    public void testMostrarPokemonPorHabilidad() {
        Data data = new Data(1);
        data.mostrarPokemonPorHabilidad("Static");
    }
}
