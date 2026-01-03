class Solution {
    public int numOfWays(int n) {
        int MOD = (int)Math.pow(10, 9)+7;
        long aba = 6;
        long abc = 6;
        for (int i=1; i<n; i++)
        {
            long resultABA = (aba*3) + (abc*2);
            long resultABC = (aba*2) + (abc*2);
            aba = resultABA % MOD;
            abc = resultABC % MOD;
        }
        return (int)((aba+abc)%MOD);
    }
}

/*

rgb


aba

rgr 01
rbr 02
grg 03
gbg 04
brb 05
bgb 06

abc

rgb 11
rbg 12
grb 13
gbr 14
brg 15
bgr 16


for 01, we have 03, 04, 05, 13, 15

for 11, we have 03, 04, 14, 15

*/