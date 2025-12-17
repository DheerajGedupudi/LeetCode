class Solution {
    public double myPow(double x, int n) {
        if (n==0)
        {
            return 1;
        }
        double sqrt = myPow(x, n/2);
        sqrt *= sqrt;
        if (n%2==-1)
        {
            return sqrt*1/x;
        }
        if (n%2==1)
        {
            sqrt *= x;
        }
        return sqrt;
    }
}