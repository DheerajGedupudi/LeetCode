class FirstUnique {

    LL l1;
    LL l2;

    public FirstUnique(int[] nums) {
        this.l1 = new LL();
        this.l2 = new LL();
        for (int x : nums)
        {
            add(x);
        }
    }
    
    public int showFirstUnique() {
        return l1.getFirst();
    }
    
    public void add(int value) {
        if (l1.contains(value) || l2.contains(value))
        {
            if (l1.contains(value))
            {
                l1.remove(value);
            }
            l2.add(value);
        }
        else
        {
            l1.add(value);
        }
        // System.out.println(l1);
        // System.out.println(l2);
    }
}

class LL
{
    private Map<Integer, Queue<Node>> map;
    private Node head;
    private Node tail;

    LL()
    {
        this.head = null;
        this.tail = null;
        this.map = new HashMap<>();
    }

    public boolean contains(int n)
    {
        return this.map.containsKey(n);
    }

    public int getFirst()
    {
        if (this.head==null)
        {
            return -1;
        }
        return this.head.val;
    }

    public void add(int n)
    {
        Node node = new Node(n);
        this.map.putIfAbsent(node.val, new LinkedList<>());
        this.map.get(node.val).add(node);
        //add to last
        if (this.head==null)
        {
            //no nodes
            this.head = node;
            this.tail = node;
        }
        else
        {
            //nodes
            this.tail.next = node;
            node.prev = this.tail;
            this.tail = node;
        }
    }

    public void remove(int n)
    {
        Node node = this.map.get(n).poll();
        if (this.map.get(n).isEmpty())
        {
            this.map.remove(n);
        }
        Node prevNode = node.prev;
        Node nextNode = node.next;
        if (node.prev!=null)
        {
            node.prev.next = nextNode;
        }
        if (node.next!=null)
        {
            node.next.prev = prevNode;
        }
        if (this.head==node)
        {
            this.head = this.head.next;
        }
        if (this.tail==node)
        {
            this.tail = this.tail.prev;
        }
    }

    @Override
    public String toString()
    {
        return this.map.toString();
    }
}

class Node
{
    int val;
    Node next;
    Node prev;

    Node(int val)
    {
        this.val = val;
        this.next = null;
        this.prev = null;
    }

    @Override
    public String toString()
    {
        return "["+this.val+"], ";
    }
}

/**
 * Your FirstUnique object will be instantiated and called as such:
 * FirstUnique obj = new FirstUnique(nums);
 * int param_1 = obj.showFirstUnique();
 * obj.add(value);
 */