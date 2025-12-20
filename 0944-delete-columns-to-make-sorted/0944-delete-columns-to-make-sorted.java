class Solution {
    public int minDeletionSize(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        int count = 0;
        for (int i=0; i<m; i++)
        {
            int last = -1;
            for (int j=0; j<n; j++)
            {
                int ind = strs[j].charAt(i)-'a';
                if (ind<last)
                {
                    count++;
                    break;
                }
                last = ind;
            }
        }
        return count;
    }
}