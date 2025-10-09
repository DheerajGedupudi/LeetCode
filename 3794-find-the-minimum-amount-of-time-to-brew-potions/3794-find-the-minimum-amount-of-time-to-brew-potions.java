class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length;
        int m = mana.length;
        long[] firstRow = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            firstRow[i] = (skill[i - 1] * mana[0]) + firstRow[i - 1];
        }
        for (int j = 1; j < m; j++) {
            long[] secondRow = new long[n + 1];
            for (int i = 1; i <= n; i++) {
                long startTime = secondRow[i - 1];
                if (startTime < firstRow[i]) {
                    startTime = firstRow[i];
                }
                secondRow[i] = (skill[i - 1] * mana[j]) + startTime;
            }
            for (int i = n - 1; i >= 0; i--) {
                secondRow[i] = secondRow[i + 1] - (skill[i] * mana[j]);
            }
            // System.out.println(Arrays.toString(secondRow));
            firstRow = secondRow;
        }
        return firstRow[n];
    }
}

/*
 * 
 * [1,5,2,4] [5]
 * 0-> [5,30,40,60]
 * 
 * [1,5,2,4] [1]
 * 52-> [53,58,60,64]
 * 
 * [1,5,2,4] [4]
 * 30-> [39,60,68,64]
 * 
 * 
 */