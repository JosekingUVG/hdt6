package uvg;

// Clase Main para ejecutar el programa
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Seleccione la implementación de Map: ");
        System.out.println("1. HashMap");
        System.out.println("2. TreeMap");
        System.out.println("3. LinkedHashMap");

        int tipo = scanner.nextInt();

        // Obtener la implementación adecuada del Map
        Map<String, Pokemon> pokemonMap = PokemonFactory.getMap(tipo);

        System.out.println("Mapa creado con éxito: " + pokemonMap.getClass().getSimpleName());

        Boolean bandera = true;
        while (bandera != false) {
            System.out.println("Selecciona una opción:\n"+
                               "1. Agregar un pokemon a la colección del usuario\n"+
                               "2. Mostrar los datos de un pokemon\n"+
                               "3. Mostrar el nombre, tipo1 de tu colección\n"+
                               "4. Mostrar el nombre y tipo1 de todos los pokemon existentes\n"+
                               "5. Mostrar el nombre del pokemon que tiene la habilidad indicada por el usuario\n"+
                               "6. Salir del programa");

            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                System.out.println("Ingrese el nombre del pokemon a agregar:");
                String nombre = scanner.next();
                data.agregarPokemonColeccion(nombre, tipo);
                
                break;
                case 2:
                System.out.println("Ingrese el nombre del pokemon a mostrar:");
                nombre = scanner.next();
                data.mostrarPokemonColeccion(nombre);
                break;
                case 6:
                bandera = false;
                break;
        }

        
        data.mostrarTodos();
    }
}
}
