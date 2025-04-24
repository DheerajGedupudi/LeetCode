class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum3(int k, int n) {
        this.result = new ArrayList<>();    
        backtrack(0, n, k, 0, new ArrayList<>());
        return this.result;
    }

    private void backtrack(int number, int n, int k, int sum, List<Integer> path)
    {
        if (sum>n)
        {
            return;
        }
        if (path.size()==k)
        {
            if (sum==n)
            {
                this.result.add(new ArrayList<>(path));
            }
            return;
        }
        for (int i=number+1; i<10; i++)
        {
            path.add(i);
            sum += i;
            backtrack(i, n, k, sum, path);
            sum -= i;
            path.remove(path.size()-1);
        }
    }
}