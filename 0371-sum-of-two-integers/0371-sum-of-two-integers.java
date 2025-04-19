class Solution {
    public int getSum(int a, int b) {
        if (Math.abs(a)<Math.abs(b))
        {
            return getSum(b, a);
        }
        //at this point, |a| >= |b|;
        String s1 = Integer.toBinaryString(Math.abs(a));
        String s2 = Integer.toBinaryString(Math.abs(b));
        boolean aPos = (a>=0);
        boolean bPos = (b>=0);
        if (aPos && bPos)
        {
            return Integer.parseInt(add(s1, s2), 2);
        }
        else if (aPos==false && bPos==false)
        {
            return (Integer.parseInt(add(s1, s2), 2))*-1;
        }
        if (s1.equals(s2))
        {
            return 0;
        }
        int x = Integer.parseInt(subtract(s1, s2), 2);
        if (aPos==false && bPos)
        {
            // -a+b , |a| >= |b|
            return x*-1;
        }
        else
        {
            //a-b, |a| >= |b|
            return x;
        }
    }

    private String add(String s1, String s2)
    {
        StringBuilder sb = new StringBuilder();
        s1 = (new StringBuilder(s1)).reverse().toString();
        s2 = (new StringBuilder(s2)).reverse().toString();
        int i=0;
        int n = s1.length();
        int m = s2.length();
        int carry = 0;
        while (i<n || i<m)
        {
            int x = 0;
            int y = 0;
            if (i<n)
            {
                x = Character.getNumericValue(s1.charAt(i));
            }
            if (i<m)
            {
                y = Character.getNumericValue(s2.charAt(i));
            }
            int current = 0;
            if (x==1 && y==1)
            {
                if (carry==1)
                {
                    // 1,1,1 = 11
                    current = 1;
                }
                else
                {
                    //1,1,0 = 10
                    carry = 1;
                }
            }
            else if (x==0 && y==0)
            {
                if (carry==1)
                {
                    //1,0,0 = 01
                    carry = 0;
                    current = 1;
                }
                else
                {
                    //0,0,0 = 00
                }
            }
            else 
            {
                if (carry==1)
                {
                    //1,1,0 = 10
                }
                else
                {
                    //1,0,0 = 01
                    current = 1;
                }
            }
            i++;
            sb.append(current);
        }
        if (carry==1)
        {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    private String subtract(String s1, String s2)
    {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        for (char c : s2.toCharArray())
        {
            if (c=='0')
            {
                sb3.append('1');
            }
            else
            {
                sb3.append('0');
            }
        }
        sb3.reverse();
        while(sb3.length()<s1.length())
        {
            sb3.append('1');
        }
        s1 = (new StringBuilder(s1)).reverse().toString();
        // s2 = complement of s2
        s2 = sb3.toString();
        int i=0;
        int n = s1.length();
        int m = s2.length();
        int carry = 0;
        while (i<n || i<m)
        {
            int x = 0;
            int y = 0;
            if (i<n)
            {
                x = Character.getNumericValue(s1.charAt(i));
            }
            if (i<m)
            {
                y = Character.getNumericValue(s2.charAt(i));
            }
            int current = 0;
            if (x==1 && y==1)
            {
                if (carry==1)
                {
                    // 1,1,1 = 11
                    current = 1;
                }
                else
                {
                    //1,1,0 = 10
                    carry = 1;
                }
            }
            else if (x==0 && y==0)
            {
                if (carry==1)
                {
                    //1,0,0 = 01
                    carry = 0;
                    current = 1;
                }
                else
                {
                    //0,0,0 = 00
                }
            }
            else 
            {
                if (carry==1)
                {
                    //1,1,0 = 10
                }
                else
                {
                    //1,0,0 = 01
                    current = 1;
                }
            }
            i++;
            sb.append(current);
        }
        // if (carry==1)
        // {
        //     sb.append(1);
        // }
        String s3 = sb.reverse().toString();
        // System.out.println(s3);
        return add(s3,"1");
    }
}