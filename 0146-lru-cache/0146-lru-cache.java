class LRUCache {

    private LRU lru;

    public LRUCache(int capacity) {
        this.lru = new LRU(capacity);
    }
    
    public int get(int key) {
        int x = lru.get(key);
        // System.out.println("get -> "+key);
        // this.lru.print();
        return x;
    }
    
    public void put(int key, int value) {
        this.lru.put(key, value);
        // System.out.println("put -> "+key+" : "+value);
        // this.lru.print();
    }
}

class LRU
{
    private ListNode head;
    private ListNode tail;

    private Map<Integer, ListNode> map;

    private int cap;

    LRU(int cap)
    {
        this.cap = cap;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = this.head;
    }

    int get(int key)
    {
        if (this.map.containsKey(key))
        {
            int val = this.map.get(key).val;
            remove(key);
            put(key, val);
            return val;
        }
        else
        {
            return -1;
        }
    }

    void put(int key, int val)
    {
        //already present, delete it
        remove(key);
        ListNode node = new ListNode(key, val);
        addToHead(node);
        this.map.put(key, node);
        if (this.map.size()>this.cap)
        {
            deleteTail();
        }

    }

    void deleteTail()
    {
        if (this.tail!=null)
        {
            int key = this.tail.key;
            this.map.remove(key);
            if (this.tail.prev!=null)
            {
                ListNode prev = this.tail.prev;
                prev.next = null;
                this.tail = prev;
            }
            else
            {
                this.tail = null;
                this.head = this.tail;
            }
        }
    }

    void addToHead(ListNode node)
    {
        if (this.head==null)
        {
            this.head = node;
            this.tail = node;
            return;
        }
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
    }

    void remove(int key)
    {
        if (this.map.containsKey(key))
        {
            ListNode node = this.map.get(key);
            ListNode prev = node.prev;
            ListNode next = node.next;
            if (node.prev!=null)
            {
                node.prev.next = next;
            }
            if (node.next!=null)
            {
                node.next.prev = prev;
            }
            if (node==this.head)
            {
                this.head = next;
            }
            if (node==this.tail)
            {
                this.tail = prev;
            }
            this.map.remove(key);
        }
    }

    void print()
    {
        ListNode curr = this.head;
        while(curr!=null)
        {
            System.out.print(curr.val+"->");
            curr = curr.next;
        }
        System.out.println();

        curr = this.tail;
        while(curr!=null)
        {
            System.out.print(curr.val+"<-");
            curr = curr.prev;
        }
        System.out.println();
    }

}

class ListNode
{
    int key;
    int val;
    ListNode next;
    ListNode prev;

    ListNode(int key, int val)
    {
        this.key = key;
        this.val = val;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */