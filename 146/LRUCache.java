import java.util.LinkedHashMap;

public class LRUCache {

    int capacity;
    private LinkedHashMap<Integer, Integer> cache;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new LinkedHashMap<Integer, Integer>(capacity);
    }

    public int get(int key) {
        if (!cache.containsKey(key)){
            return -1;
        }
        int value = cache.remove(key);
        cache.put(key,value);
        return value;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            cache.remove(key);
        }
        else if (cache.size()==capacity){
            cache.remove(cache.entrySet().iterator().next().getKey());
        }
        cache.put(key, value);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.set(2, 1);
        cache.set(1,1);
        System.out.println(cache.get(2));
        cache.set(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}
