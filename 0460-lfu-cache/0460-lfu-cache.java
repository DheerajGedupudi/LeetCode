class LFUCache {

    private Map<Integer, Integer> freqMap;
    private Map<Integer, LRU> lruMap;
    private int size;
    private int cap;
    private int minFreq;

    public LFUCache(int capacity) {
        this.freqMap = new HashMap<>();
        this.lruMap = new HashMap<>();
        this.size = 0;
        this.cap = capacity;
        this.minFreq = 0;
    }
    
    public int get(int key) {
        if (this.freqMap.containsKey(key))
        {
            int freq = this.freqMap.get(key);
            LRU lru = lruMap.get(freq);
            Node node = lru.get(key);
            lru.removeThis(node);
            if (lru.isEmpty())
            {
                lruMap.remove(node.freq);
                if (node.freq==minFreq)
                {
                    minFreq++;
                }
            }
            int val = node.value;
            node.freq++;
            freqMap.put(key, node.freq);
            lruMap.putIfAbsent(node.freq, new LRU(node.freq));
            LRU nextLRU = lruMap.get(node.freq);
            nextLRU.add(node.key, node.value);
            // System.out.println("------------------------- get : "+key);
            // System.out.println(freqMap);
            // System.out.println(lruMap);
            return node.value;
        }
        else
        {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        Node node = new Node(key, value, 1);
        if (this.freqMap.containsKey(key))
        {
            int freq = this.freqMap.get(key);
            LRU lru = lruMap.get(freq);
            node = lru.get(key);
            lru.removeThis(node);
            if (lru.isEmpty())
            {
                lruMap.remove(node.freq);
                if (node.freq==minFreq)
                {
                    minFreq++;
                }
            }
            node.freq++;
        }
        else
        {
            if (size==cap)
            {
                evict();
            }
            size++;
            this.minFreq = 1;
        }
        lruMap.putIfAbsent(node.freq, new LRU(node.freq));
        LRU nextLRU = lruMap.get(node.freq);
        nextLRU.add(node.key, value);
        freqMap.put(key, node.freq);
        // System.out.println("------------------------- add : "+key+" = "+value);
        // System.out.println(freqMap);
        // System.out.println(lruMap);
    }

    private void evict()
    {
        LRU lru = lruMap.get(this.minFreq);
        Node removed = lru.removeFirstAndReturn();
        if (lru.isEmpty())
        {
            lruMap.remove(removed.freq);
        }
        this.freqMap.remove(removed.key);
        // System.out.println("+++++++++++++++++++++++++++ evicted : "+removed.key);
        // System.out.println(freqMap);
        // System.out.println(lruMap);
        size--;
    }
}

class LRU
{
    private Map<Integer, Node> map;
    int freq;
    Node head;
    Node tail;

    LRU(int freq)
    {
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
        this.freq = freq;
    }

    Node get(int key)
    {
        return this.map.get(key);
    }

    void add(int key, int value)
    {
        if (this.map.containsKey(key))
        {
            Node node = this.map.get(key);
            removeThis(node);
            node.freq++;
            node.value = value;
            this.map.put(key, node);
            addLast(node);
        }
        else
        {
            Node node = new Node(key, value, this.freq);
            this.map.put(key, node);
            addLast(node);
        }
    }

    boolean isEmpty()
    {
        return this.head==null;
    }

    void remove(int key)
    {
        Node node = this.map.get(key);
        removeThis(node);
        this.map.remove(key);
    }

    void addLast(Node node)
    {
        //no nodes
        if (this.tail==null)
        {
            this.head = node;
            this.tail = this.head;
        }
        else
        {
            node.prev = this.tail;
            this.tail.next = node;
            this.tail = this.tail.next;
        }

    }

    Node removeFirstAndReturn()
    {
        //only one node
        Node toReturn = this.head;
        removeThis(this.head);
        this.map.remove(toReturn.key);
        return toReturn;
    }

    void removeThis(Node node)
    {
        if (this.head==node)
        {
            this.head = this.head.next;
            if (this.head==null)
            {
                //no nodes
                this.tail = null;
            }
            else
            {
                this.head.prev = null;
            }
            return;
        }
        if (this.tail==node)
        {
            this.tail = this.tail.prev;
            if (this.tail==null)
            {
                this.head = null;
            }
            else
            {
                this.tail.next = null;
            }
            return;
        }
        Node prev = node.prev;
        Node next = node.next;
        if (prev!=null)
        {
            prev.next = next;
        }
        if (next!=null)
        {
            next.prev = prev;
        }
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder(this.freq+" =>>> ");
        Node curr = this.head;
        while(curr!=null)
        {
            sb.append("["+curr.toString()+"], ");
            curr = curr.next;
        }
        return sb.toString();
    }
}

class Node
{
    int key;
    int value;
    int freq;
    Node next;
    Node prev;

    Node(int key, int value, int freq)
    {
        this.key = key;
        this.value = value;
        this.freq = freq;
    }

    @Override
    public String toString()
    {
        return "key : "+this.key+", val : "+this.value+", freq : "+this.freq+"";
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/*

LL for LRU

Map for LFU

[2]->[1]->Null


1=2
2=1

LL 1 => [2]
LL 2 => [1]


{
    .


}
*/