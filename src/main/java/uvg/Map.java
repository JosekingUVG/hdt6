package uvg;

import java.util.Set;

// Interfaz Map simplificada
public interface Map<K, V> {
    int size();
    boolean isEmpty();
    boolean containsKey(K k);
    boolean containsValue(V v);
    V get(K k);
    V put(K k, V v);
    V remove(K k);
    void putAll(Map<K, V> other);
    void clear();
    Set<K> keySet();
    boolean equals(Object other);
    int hashCode();
    Object values();
}