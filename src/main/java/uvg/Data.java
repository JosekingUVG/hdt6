/**
 * @autor José Rivera 24376
 * Universidad del Valle
 * esta clase se encarga de las operaciones del csv guardandolos en
 * diccionarios con el nombre del pokemon como llave y sus atributos son los valores
 */
package uvg;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;


class Data {
    private Map<String, Pokemon> listaPokemon;
    private Map<String, Pokemon> coleccionUsuario;

    /*
     * Constructor inicializa los diccionarios y carga los datos del csv
     * @param tipoMapa
     */
    public Data(int tipoMapa) {
        this.listaPokemon = new PokemonFactory().getMap(tipoMapa);
        this.coleccionUsuario = new PokemonFactory().getMap(tipoMapa);
        cargarDatos("src/main/resources/pokemon_data_pokeapi.csv");
    }

    /**
     * Carga los datos del archivo CSV y los almacena en el mapa listaPokemon.
     *
     * @param ruta Ruta del archivo CSV a cargar.
     */
    private void cargarDatos(String ruta) {
        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            String linea;
            br.readLine(); // Omitir la cabecera del CSV

            while ((linea = br.readLine()) != null) {
                // Procesar la línea respetando comas dentro de comillas
                List<String> datos = new ArrayList<>();
                StringBuilder campo = new StringBuilder();
                boolean enComillas = false;

                for (char c : linea.toCharArray()) {
                    if (c == '"') {
                        enComillas = !enComillas;
                    } else if (c == ',' && !enComillas) {
                        datos.add(campo.toString().trim());
                        campo.setLength(0); // Limpiar el StringBuilder
                    } else {
                        campo.append(c);
                    }
                }
                datos.add(campo.toString().trim());

                if (datos.size() == 10) {
                    Pokemon pokemon = new Pokemon(
                        datos.get(0), // Name
                        Integer.parseInt(datos.get(1)), // Pokedex Number
                        datos.get(2), // Type1
                        datos.get(3), // Type2
                        datos.get(4), // Classification
                        Double.parseDouble(datos.get(5)), // Height (m)
                        Double.parseDouble(datos.get(6)), // Weight (kg)
                        Arrays.asList(datos.get(7).replace("\"", "").split(";")), // Abilities
                        Integer.parseInt(datos.get(8)), // Generation
                        datos.get(9).equalsIgnoreCase("Yes") // Legendary Status
                    );
                    listaPokemon.put(datos.get(0), pokemon);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Obtiene el mapa con todos los Pokemon cargados.
     *
     * @return Un mapa con el nombre del Pokemon como clave y el objeto Pokemon como valor.
     */
    public Map<String, Pokemon> getListaPokemon() {
        return listaPokemon;
    }

    /**
     * Imprime todos los pokemones en la lista
     */
    public void imprimirTodosLosPokemon() {
        for (String key : listaPokemon.keySet()) {
            System.out.println(listaPokemon.get(key));
        }
    }


    /**
     * Agrega un Pokemon a la colección del usuario.
     *
     * @param nombre Nombre del Pokemon a agregar.
     */
    public void agregarPokemonColeccion(String nombre) {
        if (!listaPokemon.containsKey(nombre)) {
            System.out.println("Error: El Pokémon no se encuentra en los datos.");
            return;
        }

        if (coleccionUsuario.containsKey(nombre)) {
            System.out.println("Error: El Pokémon ya está en la colección del usuario.");
        } else {
            coleccionUsuario.put(nombre, listaPokemon.get(nombre));
            System.out.println("Pokémon agregado exitosamente: " + listaPokemon.get(nombre));
        }
    }

    /**
     * Muestra los datos de un Pokemon en la colección del usuario.
     *
     * @param nombre Nombre del Pokemon a mostrar.
     */
    public void mostrarPokemonColeccion(String nombre) {
        if (coleccionUsuario.isEmpty() || !coleccionUsuario.containsKey(nombre)) {
            System.out.println("Error: El Pokémon no está en la colección del usuario.");
            return;
        }
        System.out.println("Datos del Pokémon: " + coleccionUsuario.get(nombre));
    }

    /**
     * Muestra los Pokemon en la colección del usuario ordenados por Tipo1.
     */
    public void mostrarPokemonPorTipo() {
        if (coleccionUsuario.isEmpty()) {
            System.out.println("La colección del usuario está vacía.");
            return;
        }
    
        // Crear una lista de claves y ordenarla
        List<String> claves = new ArrayList<>(coleccionUsuario.keySet());
        claves.sort(Comparator.comparing(key -> coleccionUsuario.get(key).getTipo1()));
    
        // Imprimir los resultados
        System.out.println("Pokémon en la colección ordenados por Tipo1:");
        for (String clave : claves) {
            Pokemon pokemon = coleccionUsuario.get(clave);
            System.out.println("Nombre: " + pokemon.getNombre() + ", Tipo1: " + pokemon.getTipo1());
        }
    }

    /**
     * Muestra todos los Pokemon en la colección del usuario ordenados por Tipo1.
     */
    public void mostrarTodoPokemonPorTipo() {
        if (listaPokemon.isEmpty()) {
            System.out.println("La colección del usuario está vacía.");
            return;
        }
    
        // Crear una lista de claves y ordenarla
        List<String> claves = new ArrayList<>(listaPokemon.keySet());
        claves.sort(Comparator.comparing(key -> listaPokemon.get(key).getTipo1()));
    
        // Imprimir los resultados
        System.out.println("Pokémon en la colección ordenados por Tipo1:");
        for (String clave : claves) {
            Pokemon pokemon = listaPokemon.get(clave);
            System.out.println("Nombre: " + pokemon.getNombre() + ", Tipo1: " + pokemon.getTipo1());
        }
    }

    /**
     * Muestra el nombre del Pokemon que tiene la habilidad indicada por el usuario.
     *
     * @param habilidad Habilidad a buscar en los Pokemon.
     */
    public void mostrarPokemonPorHabilidad(String habilidad) {
        boolean encontrado = false;
    
        // Obtener todas las claves del mapa
        Set<String> claves = listaPokemon.keySet();
    
        // Normalizar la habilidad ingresada (eliminar espacios y convertir a minúsculas)
        habilidad = habilidad.trim().toLowerCase();
    
        // Iterar sobre todas las claves del mapa
        for (String clave : claves) {
            Pokemon pokemon = listaPokemon.get(clave);
    
            // Iterar sobre todas las habilidades del Pokémon
            for (String habilidadPokemon : pokemon.getHabilidades()) {
                // Normalizar las habilidades para asegurar comparación precisa
                if (habilidadPokemon.trim().toLowerCase().equals(habilidad)) {
                    System.out.println("Pokémon: " + pokemon.getNombre());
                    encontrado = true;
                    break; // Si encontramos una coincidencia, salimos del loop de habilidades
                }
            }
        }
    
        // Si no se encontraron Pokémon con la habilidad solicitada
        if (!encontrado) {
            System.out.println("No se encontraron Pokémon con la habilidad: " + habilidad);
        }
    }
    
    
    
    
    



}

