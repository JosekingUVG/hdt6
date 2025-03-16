
// Implementación usando HashMap
package uvg;
import java.util.*;

public class HashMapImpl<K, V> implements Map<K, V> {
    private java.util.Map<K, V> map = new HashMap<>();

    public int size() { return map.size(); }
    public boolean isEmpty() { return map.isEmpty(); }
    public boolean containsKey(K k) { return map.containsKey(k); }
    public boolean containsValue(V v) { return map.containsValue(v); }
    public V get(K k) { return map.get(k); }
    public V put(K k, V v) { return map.put(k, v); }
    public V remove(K k) { return map.remove(k); }
    public void putAll(Map<K, V> other) {
        for (K key : other.keySet()) {
            map.put(key, other.get(key));
        }
    }
    public void clear() { map.clear(); }
    public Set<K> keySet() { return map.keySet(); }
    public boolean equals(Object other) { return map.equals(other); }
    public int hashCode() { return map.hashCode(); }
    
}
