class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int INF = (int)Math.pow(10, 8);
        int[][] mat = get(original, changed, cost);
        // System.out.println(Arrays.deepToString(mat));
        long result = 0;
        int n = source.length();
        for (int i=0; i<n; i++)
        {
            char c = source.charAt(i);
            char d = target.charAt(i);
            int x = c-'a';
            int y = d-'a';
            int cost1 = mat[x][y];
            if (cost1>=INF)
            {
                return -1;
            }
            result += cost1;
        }
        return result;
    }

    private int[][] get(char[] original, char[] changed, int[] cost)
    {
        int INF = (int)Math.pow(10, 8);
        int[][] mat = new int[26][26];
        for(int i=0; i<26; i++)
        {
            Arrays.fill(mat[i], INF);
            mat[i][i] = 0;
        }
        int m = cost.length;
        for (int i=0; i<m; i++)
        {
            int x = original[i]-'a';
            int y = changed[i]-'a';
            mat[x][y] = Math.min(mat[x][y], cost[i]);
        }
        for (int k=0; k<26; k++)
        {
            for (int i=0; i<26; i++)
            {
                for (int j=0; j<26; j++)
                {
                    int cost2 = mat[i][k]+mat[k][j];
                    if (cost2<mat[i][j] && cost2<INF)
                    {
                        mat[i][j] = cost2;
                    }
                }
            }
        }
        return mat;
    }
}