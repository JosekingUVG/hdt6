package uvg;

import java.io.*;
import java.util.*;

public class Data {
    private List<Pokemon> listaPokemon;
    private Map<String, Pokemon> coleccionUsuario;

    public Data() {
        this.listaPokemon = new ArrayList<>();
        
        cargarDatos("src/main/resources/pokemon_data_pokeapi.csv");
    }

    private void cargarDatos(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            br.readLine(); // Omitir la cabecera del CSV

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 10) {
                    Pokemon pokemon = new Pokemon(
                        datos[0], // Name
                        Integer.parseInt(datos[1]), // Pokedex Number
                        datos[2], // Type1
                        datos[3], // Type2
                        datos[4], // Classification
                        Double.parseDouble(datos[5]), // Height (m)
                        Double.parseDouble(datos[6]), // Weight (kg)
                        Arrays.asList(datos[7].replace("\"", "").split(";")), // Abilities
                        Integer.parseInt(datos[8]), // Generation
                        datos[9].trim().equalsIgnoreCase("Yes") // Legendary Status
                    );
                    listaPokemon.add(pokemon);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Pokemon> getListaPokemon() {
        return listaPokemon;
    }

    public void mostrarTodos() {
        for (Pokemon p : listaPokemon) {
            System.out.println(p);
        }
    }

    public void agregarPokemonColeccion(String nombre, int tipoMapa) {
        if (coleccionUsuario == null) {
            coleccionUsuario = new PokemonFactory().getMap(tipoMapa);
        }

        Pokemon encontrado = null;
        for (Pokemon p : listaPokemon) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = p;
                break;
            }
        }

        if (encontrado == null) {
            System.out.println("Error: El Pokémon no se encuentra en los datos.");
            return;
        }

        if (coleccionUsuario.containsKey(nombre)) {
            System.out.println("Error: El Pokémon ya está en la colección del usuario.");
        } else {
            coleccionUsuario.put(nombre, encontrado);
            System.out.println("Pokémon agregado exitosamente: " + encontrado);
        }
    }

    public void mostrarPokemonColeccion(String nombre) {
        if (coleccionUsuario == null || !coleccionUsuario.containsKey(nombre)) {
            System.out.println("Error: El Pokémon no está en la colección del usuario.");
            return;
        }
        System.out.println("Datos del Pokémon: " + coleccionUsuario.get(nombre));
    }

} 