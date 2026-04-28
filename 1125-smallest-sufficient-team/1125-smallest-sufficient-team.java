class Solution {

    int[] memo;
    int[] chosen;
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        int n = req_skills.length;
        Map<String, Integer> skillToIndex = new HashMap<>();
        for (int i=0; i<n; i++)
        {
            skillToIndex.put(req_skills[i], i);
        }
        int m = people.size();
        int[] masks = new int[m];
        for (int i=0; i<m; i++)
        {
            for (String skill : people.get(i))
            {
                int ind = skillToIndex.getOrDefault(skill, -1);
                if (ind!=-1)
                {
                    masks[i] |= (1<<ind);
                }
            }
        }
        this.memo = new int[(1<<n)];
        this.chosen = new int[(1<<n)];
        Arrays.fill(this.memo, 100);
        int minCount = helper(masks, 0, n);
        int[] answer = new int[minCount];
        int ansIndex = 0;
        int mask = 0;
        while(mask != (1<<n)-1)
        {
            int index = this.chosen[mask];
            answer[ansIndex++] = index;
            mask |= masks[index];
        }
        return answer;
    }

    private int helper(int[] masks, int currMask, int n)
    {
        if (this.memo[currMask]!=100)
        {
            return this.memo[currMask];
        }
        if (currMask == (1<<n)-1)
        {
            return 0;
        }
        int min = 100;
        int m = masks.length;
        for (int i=0; i<m; i++)
        {
            int union = currMask | masks[i];
            if (union != currMask)
            {
                int next = helper(masks, union, n)+1;
                if (next < min)
                {
                    chosen[currMask] = i;
                    min = next;
                }
            }
        }
        this.memo[currMask] = min;
        return min;
    }
}