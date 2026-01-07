class Solution {
    public int numberOfPatterns(int m, int n) {
        int sum = 0;
        for (int i=m; i<=n; i++)
        {
            sum += helper(i);
        }
        return sum;
    }

    private int helper(int times)
    {
        int sum = 0;
        boolean[] visited  = new boolean[10];
        for (int x=1; x<=9; x++)
        {
            visited[x] = true;
            sum += get(x, visited, 1, times);
            visited[x] = false;
        }
        return sum;
    }

    private int get(int x, boolean[] visited, int count, int n)
    {
        if (count>=n)
        {
            return 1;
        }
        int sum = 0;
        for (int y=1; y<=9; y++)
        {
            if (x!=y && possible(x, y, visited))
            {
                visited[y] = true;
                sum += get(y, visited, count+1, n);
                visited[y] = false;
            }
        }
        return sum;
    }

    private boolean possible(int x, int y, boolean[] visited)
    {
        if (visited[y])
        {
            return false;
        }
        int z = getMiddle(x, y);
        // System.out.println("middle of  "+x+" , "+y+" ----> "+z);
        if (z==-1)
        {
            return true;
        }
        return visited[z];
    }

    private int getMiddle(int x, int y)
    {
        int a = Math.min(x, y);
        int b = Math.max(x, y);
        //rows
        if (a==1 && b==3)
        {
            return 2;
        }
        if (a==4 && b==6)
        {
            return 5;
        }
        if (a==7 && b==9)
        {
            return 8;
        }
        //cols
        if (a==1 && b==7)
        {
            return 4;
        }
        if (a==2 && b==8)
        {
            return 5;
        }
        if (a==3 && b==9)
        {
            return 6;
        }
        //diags
        if (a==1 && b==9)
        {
            return 5;
        }
        if (a==3 && b==7)
        {
            return 5;
        }
        return -1;
    }
}