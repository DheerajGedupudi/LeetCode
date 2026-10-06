class Solution {
    public int minAddToMakeValid(String s) {
        int counter = 0;
        int miss = 0;
        for (char c : s.toCharArray())
        {
            if (c=='(')
            {
                counter++;
            }
            else
            {
                counter--;
            }
            if (counter<0)
            {
                miss++;
                counter++;
            }
        }
        return miss+counter;
    }
}