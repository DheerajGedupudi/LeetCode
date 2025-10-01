class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int empty = 0;
        int drank = 0;
        while(numBottles>0)
        {
            drank += numBottles;
            empty += numBottles;
            //exchange
            numBottles = empty/numExchange;
            empty %= numExchange;
        }
        return drank;
    }
}