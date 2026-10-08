class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        int counter = 0;
        for (char c : s.toCharArray())
        {
            boolean appendFlag = true;
            if (c=='(')
            {
                if (counter==0)
                {
                    //outer most opening
                    appendFlag = false;
                }
                counter++;
            }
            else
            {
                if (counter-1==0)
                {
                    //outer most closing
                    appendFlag = false;
                }
                counter--;
            }
            if (appendFlag)
            {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}