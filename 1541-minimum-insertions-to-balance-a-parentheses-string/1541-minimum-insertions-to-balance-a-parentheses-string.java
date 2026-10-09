class Solution {
    public int minInsertions(String s) {
        int counter = 0; // +2 for (, -1 for )
        int miss = 0;
        int n = s.length();
        for (int i=0; i<n; i++)
        {
            if (s.charAt(i)=='(')
            {
                //counter>=0 && counter=even, then balanced, add after balancing
                //allow only if counter is even
                if (counter%2!=0)
                {
                    // ()(__
                    counter--;
                    miss++;
                }
                counter += 2;
            }
            else
            {
                if (counter<=0)
                {
                    miss++;
                    // )
                    counter += 2;
                }
                counter--;
            }
        }
        miss += counter; // every opening, requires 2 closing
        return miss;
    }
}

/*

( -> counter++
)) -> counter--

()()))
  ^
())())())
*/