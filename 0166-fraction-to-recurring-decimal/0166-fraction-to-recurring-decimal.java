import java.math.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        int scale = 2*(int)Math.pow(10, 4);
        BigDecimal numBD = new BigDecimal(numerator);
        BigDecimal denBD = new BigDecimal(denominator);
        BigDecimal result = numBD.divide(denBD, scale, RoundingMode.HALF_EVEN).stripTrailingZeros();
        String s = result.toPlainString();
        int index = s.indexOf('.');
        if (index==-1)
        {
            return s;
        }
        if (s.length()<scale-5)
        {
            return s;
        }
        String integer = s.substring(0,index);
        String dec = s.substring(index+1);
        return integer+"."+check(dec);
    }

    private String check(String dec)
    {
        int len = dec.length();
        for (int first=0; first<len; first++)
        {
            String part1 = dec.substring(0,first);
            String part2 = dec.substring(first,len);
            String checked = repeatCheck(part2);
            // System.out.println(part1+" & "+checked);
            if (checked.equals(part2)==false)
            {
                return part1+checked;
            }
        }
        return dec;
    }

    private String repeatCheck(String dec)
    {
        int len = dec.length();
        for (int window=1; window<len/2; window++)
        {
            if (isRepeating(dec, window))
            {
                return "("+dec.substring(0, window)+")";
            }
        }
        return dec;
    }

    private boolean isRepeating(String dec, int window)
    {
        int len = dec.length();
        String sub = dec.substring(0, window);
        String sub2 = dec.substring(window, window+window);
        if (sub.equals(sub2)==false)
        {
            return false;
        }
        // System.out.println("sub : "+sub);
        for (int i=window; i+window<=len; i+=window)
        {
            String nextSub = dec.substring(i,i+window);
            // System.out.println("-------------- next sub : "+nextSub);
            if (sub.equals(nextSub)==false)
            {
                return false;
            }
        }
        // System.out.println("now trueeeeeeeeeeeee : "+sub);
        return true;
    }
}