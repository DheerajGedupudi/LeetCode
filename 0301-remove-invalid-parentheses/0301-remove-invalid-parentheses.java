class Solution {

    private Set<String> result;

    public List<String> removeInvalidParentheses(String s) {
        this.result = new HashSet<>();
        int totalInvalid = 0;
        int counter = 0;
        for (char c : s.toCharArray())
        {
            if (c=='(')
            {
                counter++;
            }
            else if (c==')')
            {
                counter--;
            }
            if (counter<0)
            {
                totalInvalid++;
                counter++;
            }
        }
        totalInvalid += counter;
        System.out.println(totalInvalid);
        helper(s, 0, new StringBuilder(), 0, s.length()-totalInvalid);
        return new ArrayList<>(this.result);
        
    }

    private void helper(String s, int index, StringBuilder sb, int counter, int targetLength)
    {
        if (index==s.length())
        {
            if (counter==0 && sb.length()==targetLength)
            {
                this.result.add(sb.toString());
            }
            return;
        }
        char c = s.charAt(index);
        //dont
        if (c=='(' || c==')')
        {
            //only skip brackets
            helper(s, index+1, sb, counter, targetLength);
        }
        //include
        if (c=='(')
        {
            counter++;
        }
        else if (c==')')
        {
            counter--;
        }
        if (counter<0)
        {
            //discard already invalid
            return;
        }
        sb.append(c);
        helper(s, index+1, sb, counter, targetLength);
        sb.deleteCharAt(sb.length()-1);
    }
}