class Solution {
    public boolean isStrobogrammatic(String num) {
        int n = num.length();
        int low = 0;
        int high = n-1;
        while(low<=high)
        {
            if (flipSame(num.charAt(low), num.charAt(high))==false)
            {
                return false;
            }
            low++;
            high--;
        }
        return true;
    }

    private boolean flipSame(char c, char d)
    {
        if (c==d)
        {
            return c=='0'||c=='1'||c=='8';
        }
        if (c=='6'&&d=='9')
        {
            return true;
        }
        if (c=='9'&&d=='6')
        {
            return true;
        }
        return false;
    }
}