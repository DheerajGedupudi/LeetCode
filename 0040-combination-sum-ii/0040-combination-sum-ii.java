class Solution {

    private List<List<Integer>> result;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.result = new ArrayList<>();
        backtrack(candidates, 0, target, new ArrayList<>());
        return this.result;
    }

    private void backtrack(int[] candidates, int index, int target, List<Integer> path)
    {
        if (target<0)
        {
            return;
        }
        int n = candidates.length;
        if (index==n)
        {
            if (target==0)
            {
                this.result.add(new ArrayList<>(path));
            }
            return;
        }
        //choose
        path.add(candidates[index]);
        int newTarget = target-candidates[index];
        backtrack(candidates, index+1, newTarget, path);
        path.remove(path.size()-1);

        //don't choose current, go next distinct
        int nextIndex = index;
        while (nextIndex<n)
        {
            if (candidates[index]==candidates[nextIndex])
            {
                nextIndex++;
            }
            else
            {
                break;
            }
        }
        backtrack(candidates, nextIndex, target, path);
    }
}