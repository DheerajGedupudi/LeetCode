class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray())
        {
            if (sb.length()>=2 && (c==sb.charAt(sb.length()-1) && c==sb.charAt(sb.length()-2)) )
            {
                //last 2 chars same, so skip
            }
            else
            {
                sb.append(c);
            }

        }
        return sb.toString();
    }
}