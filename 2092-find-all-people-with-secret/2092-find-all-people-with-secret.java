class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        Map<Integer, List<int[]>> bucketMap = new HashMap<>();
        for (int[] meeting : meetings)
        {
            int time = meeting[2];
            bucketMap.putIfAbsent(time, new ArrayList<>());
            bucketMap.get(time).add(meeting);
        }
        UnionFind uf = new UnionFind(n);
        uf.union(0, firstPerson);
        List<Integer> times = new ArrayList<>(bucketMap.keySet());
        Collections.sort(times);
        for (int time : times)
        {
            propagate(n, bucketMap.get(time), uf);
        }
        List<Integer> result = new ArrayList<>();
        for (int i=0; i<n; i++)
        {
            if (uf.connected(0, i))
            {
                result.add(i);
            }
        }
        return result;
    }

    private void propagate(int n, List<int[]> meets, UnionFind uf)
    {
        for (int[] meet : meets)
        {
            uf.union(meet[0], meet[1]);
        }
        for (int[] meet : meets)
        {
            if (uf.connected(0, meet[0])==false)
            {
                uf.reset(meet[0]);
            }
            if (uf.connected(0, meet[1])==false)
            {
                uf.reset(meet[1]);
            }
        }
    }
}

class UnionFind
{
    private int[] parent;
    private int[] size;

    UnionFind(int n)
    {
        this.parent = new int[n];
        for (int i=0; i<n; i++)
        {
            this.parent[i] = i;
        }
        this.size = new int[n];
        Arrays.fill(this.size, 1);
    }

    void union(int x, int y)
    {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX==rootY)
        {
            return;
        }
        int sizeX = this.size[x];
        int sizeY = this.size[y];
        if (sizeX<sizeY)
        {
            this.parent[rootX] = rootY;
            this.size[rootX]++;
        }
        else
        {
            this.parent[rootY] = rootX;
            this.size[rootY]++;
        }
    }

    int find(int x)
    {
        int parentX = this.parent[x];
        if (parentX!=x)
        {
            return this.parent[x] = find(parentX);
        }
        return parentX;
    }

    boolean connected(int x, int y)
    {
        return find(x)==find(y);
    }

    void reset(int x)
    {
        this.parent[x] = x;
        this.size[x] = 1;
    }
}