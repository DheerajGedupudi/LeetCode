class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int empty = 0;
        int count = 0;
        while(numBottles>0)
        {
            //keep drinking
            empty += numBottles;
            count += numBottles;
            numBottles = 0;
            //keep exchanging
            while(empty>=numExchange)
            {
                numBottles++;
                empty -= numExchange;
                numExchange++;
            }
        }
        return count;
    }
}