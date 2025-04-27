class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int m = queries.length;
        boolean[] ans = new boolean[m];
        UnionFind uf = new UnionFind(n, nums, maxDiff);
        for (int i=1; i<n-1; i++)
        {
            int low = nums[i]-maxDiff;
            int high = nums[i]+maxDiff;
            if (nums[i-1]>=low)
            {
                uf.union(i-1, i);
            }
            if (nums[i+1]<=high)
            {
                uf.union(i+1, i);
            }
        }
        for (int i=0; i<m; i++)
        {
            ans[i] = uf.isConnected(queries[i][0], queries[i][1]);
        }
        // uf.print();
        return ans;
    }

    int ceil(int[] arr, int target)
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int best = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (arr[mid]>target)
            {
                high = mid-1;
            }
            else
            {
                low = mid+1;
                best = mid;
            }
        }
        return best;
    }

    int floor(int[] arr, int target)
    {
        int n = arr.length;
        int low = 0;
        int high = n-1;
        int best = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (arr[mid]<target)
            {
                low = mid+1;
            }
            else
            {
                high = mid-1;
                best = mid;
            }
        }
        return best;
    }
}

class UnionFind
{
    int[] parent;
    int[] size;
    int[] nums;
    int maxDiff;

    UnionFind(int n, int[] nums, int maxDiff)
    {
        this.parent = new int[n];
        for (int i=0; i<n; i++)
        {
            this.parent[i] = i;
        }
        this.size = new int[n];
        Arrays.fill(this.size, 1);
        this.nums = nums;
        this.maxDiff = maxDiff;
    }

    void union(int a, int b)
    {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA==rootB)
        {
            return;
        }
        if (this.size[a]>this.size[b])
        {
            this.parent[b] = rootA;
        }
        else
        {
            this.parent[a] = rootB;
        }
    }

    int find(int a)
    {
        if (this.parent[a] != a) {
            this.parent[a] = find(this.parent[a]);  // Path compression
        }
        return this.parent[a];
    }

    boolean isConnected(int a, int b)
    {
        int diff = Math.abs(nums[a]-nums[b]);
        if (diff<=maxDiff)
        {
            union(a, b);
        }
        return find(a)==find(b);
    }

    void print()
    {
        System.out.println(Arrays.toString(this.parent));
    }
}