class Solution {
    public int numRabbits(int[] answers) {
        int[] count = new int[1001];
        for (int x : answers)
        {
            count[x]++;
        }
        int result = 0;
        for (int i=0; i<1001; i++)
        {
            int howManySaid = count[i];
            int howManyThere = i+1;
            while (howManySaid>0)
            {
                result += howManyThere;
                howManySaid -= howManyThere;

            }
        }
        return result;
    }
}