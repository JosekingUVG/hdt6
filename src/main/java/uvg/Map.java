/**
 * Interfaz Map 
 * @autor José Rivera 24376
 * Universidad del Valle
 *
 * Esta interfaz define las operaciones básicas que debe cumplir una estructura de datos de tipo mapa (diccionario),
 * donde cada elemento se almacena como un par clave-valor (K, V).
 * Permite almacenar, buscar, eliminar y manipular los elementos del mapa.
 */
package uvg;

import java.util.Set;

// Interfaz que define las operaciones básicas de un mapa (diccionario)
public interface Map<K, V> {

    /**
     * Devuelve el número de elementos (pares clave-valor) en el mapa.
     * @return Cantidad de elementos en el mapa.
     */
    int size(); 

    /**
     * Verifica si el mapa está vacío (no tiene elementos).
     * @return true si el mapa está vacío, false en caso contrario.
     */
    boolean isEmpty();

    /**
     * Verifica si una clave específica está presente en el mapa.
     * @param k Clave a buscar en el mapa.
     * @return true si la clave está en el mapa, false en caso contrario.
     */
    boolean containsKey(K k);

    /**
     * Verifica si un valor específico está presente en el mapa.
     * @param v Valor a buscar en el mapa.
     * @return true si el valor está en el mapa, false en caso contrario.
     */
    boolean containsValue(V v);

    /**
     * Obtiene el valor asociado a una clave específica.
     * @param k Clave del valor a buscar.
     * @return El valor asociado a la clave, o null si la clave no está en el mapa.
     */
    V get(K k);

    /**
     * Inserta un nuevo par clave-valor en el mapa. Si la clave ya existe, actualiza su valor.
     * @param k Clave del nuevo elemento.
     * @param v Valor asociado a la clave.
     * @return El valor anterior asociado a la clave, o null si no existía.
     */
    V put(K k, V v);

    /**
     * Elimina un par clave-valor del mapa.
     * @param k Clave del elemento a eliminar.
     * @return El valor asociado a la clave eliminada, o null si la clave no existe.
     */
    V remove(K k);

    /**
     * Inserta todos los elementos de otro mapa en este mapa.
     * @param other Otro mapa del cual se copiarán los elementos.
     */
    void putAll(Map<K, V> other);

    /**
     * Elimina todos los elementos del mapa, dejándolo vacío.
     */
    void clear();

    /**
     * Devuelve un conjunto (Set) con todas las claves del mapa.
     * @return Un conjunto con las claves del mapa.
     */
    Set<K> keySet();

    /**
     * Compara este mapa con otro objeto para determinar si son iguales.
     * @param other Objeto con el que se compara este mapa.
     * @return true si los mapas son iguales, false en caso contrario.
     */
    boolean equals(Object other);

    /**
     * Devuelve un código hash para este mapa, basado en los elementos almacenados.
     * @return Código hash del mapa.
     */
    int hashCode();

}
