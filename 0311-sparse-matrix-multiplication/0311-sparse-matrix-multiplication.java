class Solution {
    public int[][] multiply(int[][] mat1, int[][] mat2) {
        int n = mat1.length;
        int k = mat1[0].length;
        int m = mat2[0].length;
        int[][] answer = new int[n][m];
        for (int i=0; i<n; i++)
        {
            for (int j=0; j<m; j++)
            {
                //mat1 : i is row number, k is col number
                //mat2 : j is col numberm k is row number
                int sum = 0;
                for (int p=0; p<k; p++)
                {
                    sum += (mat1[i][p]*mat2[p][j]);
                }
                answer[i][j] = sum;
            }
        }
        return answer;
    }
}