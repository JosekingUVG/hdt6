package uvg;

// Clase Factory para Map
public class PokemonFactory {
    public static Map<String, Pokemon> getMap(int tipo) {
        switch (tipo) {
            case 1:
                return new HashMapImpl<>(); // Implementación HashMap
            case 2:
                return new TreeMapImpl<>(); // Implementación TreeMap
            case 3:
                return new LinkedHashMapImpl<>(); // Implementación LinkedHashMap
            default:
                throw new IllegalArgumentException("Tipo de mapa no válido");
        }
    }
}
