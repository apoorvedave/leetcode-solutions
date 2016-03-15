import java.util.LinkedHashMap;

/**
   LRU CACHE using LinkedHashMap
*/
public class LRUCache {
    
	private int capacity;
	private MyCache cache;
    
    public LRUCache(final int capacity) {
        this.capacity = capacity;
        this.cache = new MyCache();
    }
    
    public int get(int key) {
        return cache.get(key)!=null?cache.get(key):-1;
    }
    
    public void set(int key, int value) {
        cache.put(key, value);
    }
    
    @SuppressWarnings("serial")
	class MyCache extends LinkedHashMap<Integer, Integer> {
    	public MyCache() {
			super(capacity, 0.75f, true);
		}
    	@Override
    	protected boolean removeEldestEntry(java.util.Map.Entry<Integer, Integer> eldest) {
    		return capacity < this.size();
    	}
    }
}
