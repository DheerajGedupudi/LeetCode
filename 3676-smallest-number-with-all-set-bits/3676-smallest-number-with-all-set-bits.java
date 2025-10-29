class Solution {
    public int smallestNumber(int n) {
        int num = 1;
        int ans = num;
        while(num<n)
        {
            num = num << 1;
            num |= (1>>0);
            ans = num;
        }
        return ans;
    }
}