public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        String s =  Integer.toBinaryString(n);
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        while(sb.length()<32)
        {
            sb.append('0');
        }
        return (int)(Long.parseLong(sb.toString(), 2));
    }
}