class SnakeGame {

    private Snake snake;
    private int n;
    private int m;
    private int[][] food;
    private int foodIndex;
    private int score;

    public SnakeGame(int width, int height, int[][] food) {
        this.n = height;
        this.m = width;
        this.snake = new Snake(0,0,height,width);
        this.food = food;
        this.foodIndex = 0;
        this.score = 0;
    }
    
    public int move(String direction) {
        int[] loc = snake.getHeadLoc();
        int[] dir = new int[2];
        if (direction.equals("L"))
        {
            dir = new int[]{0,-1};
        }
        else if (direction.equals("R"))
        {
            dir = new int[]{0,1};
        }
        else if (direction.equals("U"))
        {
            dir = new int[]{-1,0};
        }
        else if (direction.equals("D"))
        {
            dir = new int[]{1,0};
        }
        int r = loc[0]+dir[0];
        int c = loc[1]+dir[1];
        // System.out.println(direction+" now : "+Arrays.toString(loc)+" r : "+r+" , c : "+c);
        if (r<0 || r>=n || c<0 || c>=m)
        {
            return -1;
        }
        boolean isFood = false;
        if (foodIndex<this.food.length)
        {
            int[] foodLoc = this.food[foodIndex];
            isFood = (r==foodLoc[0]) && (c==foodLoc[1]);
        }
        // snake.print(this.n, this.m);
        if (snake.move(r,c,isFood))
        {
            if (isFood)
            {
                foodIndex++;
                return ++score;
            }
            else
            {
                return score;
            }
        }
        else
        {
            return -1;
        }
    }
}

class Snake
{
    private SnakeNode head;
    private SnakeNode tail;
    private Set<SnakeNode> body = new HashSet<>();
    private int n;
    private int m;
    private boolean[][] present;

    Snake(int x, int y, int n, int m)
    {
        this.head = new SnakeNode(x, y);
        this.tail = this.head;
        this.n = n;
        this.m = m;
        this.present = new boolean[n][m];
    }

    boolean move(int x, int y, boolean food)
    {
        if (food==false)
        {
            //delete tail
            this.present[this.tail.x][this.tail.y] = false;
            deleteTail();
        }
        //add head
        SnakeNode newHead = new SnakeNode(x, y);
        if (this.present[x][y])
        {
            return false;
        }
        this.present[x][y] = true;
        addAtHead(x, y);
        return true;
    }

    void deleteTail()
    {
        if (this.tail==null)
        {
            return;
        }
        //only one node
        if (this.head==this.tail)
        {
            this.head = null;
            this.tail = null;
            return;
        }
        //two nodes
        if (this.head.next==this.tail)
        {
            this.tail = this.head;
            this.head.next = null;
            this.head.prev = null;
            this.tail.next = null;
            this.tail.prev = null;
            return;
        }
        //many nodes
        this.tail = this.tail.prev;
        this.tail.next = null;
    }

    void addAtHead(int x, int y)
    {
        SnakeNode newHead = new SnakeNode(x, y);
        //no nodes
        if (this.head==null)
        {
            this.head = newHead;
            this.tail = this.head;
            return;
        }
        //1+ nodes
        this.head.prev = newHead;
        newHead.next = this.head;
        this.head = newHead;

    }

    int[] getHeadLoc()
    {
        return new int[]{this.head.x, this.head.y};
    }

    void print(int n, int m)
    {
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                if (this.present[i][j])
                {
                    System.out.print("X, ");
                }
                else
                {
                    System.out.print("O, ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}

class SnakeNode
{
    int x;
    int y;
    SnakeNode next;
    SnakeNode prev;

    SnakeNode(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o==this)
        {
            return true;
        }
        if ((o instanceof SnakeNode)==false) {
            return false;
        }
        SnakeNode node1 = (SnakeNode) o;
        if (node1.x!=this.x)
        {
            return false;
        }
        if (node1.y!=this.y)
        {
            return false;
        }
        return true;
    }
}

/**
 * Your SnakeGame object will be instantiated and called as such:
 * SnakeGame obj = new SnakeGame(width, height, food);
 * int param_1 = obj.move(direction);
 */