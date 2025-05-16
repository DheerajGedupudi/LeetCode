class Solution {
    public int calculate(String s) {
        s = s.replace(" ","");
        return computeWithBrackets(s,0,s.length());
    }

    private int computeWithBrackets(String s, int start, int end)
    {
        // System.out.println("to compute : "+s.substring(start, end));
        int len = s.length();
        int index = start;
        int sum = 0;
        while(index<end)
        {
            char c = s.charAt(index);
            //sign
            boolean sign = true;
            if (c=='-'||c=='+')
            {
                if (c=='-')
                {
                    sign = false;
                }
                index++;
            }
            //resolve brackets
            if (s.charAt(index)=='(')
            {
                int counter = 1;
                index++;
                int index2 = index;
                while(index2<end)
                {
                    char d = s.charAt(index2);
                    if (d=='(')
                    {
                        counter++;
                    }
                    else if (d==')')
                    {
                        counter--;
                    }
                    index2++;
                    if (counter==0)
                    {
                        break;
                    }
                }
                int number = computeWithBrackets(s, index, index2-1);
                if (sign)
                {
                    sum += number;
                }
                else
                {
                    sum -= number;
                }
                index = index2;
            }
            //number
            int number = 0;
            while(index<end && Character.isDigit(s.charAt(index)))
            {
                number *= 10;
                int x = Character.getNumericValue(s.charAt(index));
                number += x;
                index++;
            }
            if (sign)
            {
                sum += number;
            }
            else
            {
                sum -= number;
            }
        }
        return sum;
    }
}