class Solution {
    public int possibleStringCount(String word) {
        char last = ' ';
        int count = 0;
        for (char c : word.toCharArray())
        {
            if (c==last)
            {
                count++;
            }
            last = c;
        }
        return ++count;
    }
}