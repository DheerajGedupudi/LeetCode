
import java.util.SequencedMap;class LFUCache {

    private Map<Integer, Integer> freqMap;
    private Map<Integer, LRUCache> lruMap;
    private int capacity;
    private int size;
    private int minFreq;

    public LFUCache(int capacity) {
        this.freqMap = new HashMap<>();
        this.lruMap = new HashMap<>();
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 1;
    }
    
    public int get(int key) {
        if (this.freqMap.containsKey(key))
        {
            int freq = this.freqMap.get(key);
            int value = lruMap.get(freq).get(key);
            lruMap.get(freq).removeKey(key);
            if (lruMap.get(freq).isEmpty())
            {
                lruMap.remove(freq);
                if (this.minFreq==freq)
                {
                    this.minFreq = freq+1;
                }
            }
            freq++;
            this.freqMap.put(key, freq);
            lruMap.putIfAbsent(freq, new LRUCache());
            lruMap.get(freq).add(key, value);
            // System.out.println("\n --+-+++++++++++++-get : "+key+" v : "+value);
            // System.out.println(" freq map : "+freqMap);
            // System.out.println(" lru map : "+lruMap);
            return value;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        int freq = 1;
        if (this.freqMap.containsKey(key))
        {
            freq = this.freqMap.get(key);
            lruMap.get(freq).removeKey(key);
            if (lruMap.get(freq).isEmpty())
            {
                lruMap.remove(freq);
                if (this.minFreq==freq)
                {
                    this.minFreq = freq+1;
                }
            }
            freq++;
        }
        else
        {
            //only here, we adding to or removing from the cache
            //remove Eldest is size == capacity
            if (this.size==this.capacity)
            {
                LRUCache minLRU = lruMap.get(this.minFreq);
                int toRemove = minLRU.removeRU();
                if (minLRU.isEmpty())
                {
                    lruMap.remove(this.minFreq);
                    this.minFreq = 1;
                }
                this.freqMap.remove(toRemove);
                this.size--;
            }
            this.size++;
        }
        this.freqMap.put(key, freq);
        lruMap.putIfAbsent(freq, new LRUCache());
        this.minFreq = Math.min(this.minFreq, freq);
        lruMap.get(freq).add(key, value);
        // System.out.println("\n -----------------------put : "+key+" v : "+value);
        // System.out.println(" freq map : "+freqMap);
        // System.out.println(" lru map : "+lruMap);
    }
}

class LRUCache
{
    private SequencedMap<Integer, Integer> cache;

    LRUCache()
    {
        this.cache = new LinkedHashMap<>();
    }

    public boolean isEmpty()
    {
        return this.cache.size()==0;
    }

    public boolean containsKey(int key)
    {
        return this.cache.containsKey(key);
    }

    public int get(int key)
    {
        return this.cache.get(key);
    }

    public void removeKey(int key)
    {
        this.cache.remove(key);
    }

    public int removeRU()
    {
        Map.Entry<Integer, Integer> entry = cache.pollFirstEntry();
        return entry.getKey();
    }

    public void add(int key, int value)
    {
        this.cache.remove(key);
        this.cache.putLast(key, value);
    }

    @Override
    public String toString()
    {
        return this.cache.toString();
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */