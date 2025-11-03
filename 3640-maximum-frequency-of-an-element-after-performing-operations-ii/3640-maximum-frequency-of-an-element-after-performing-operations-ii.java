class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
        Arrays.sort(nums);
        List<Node> list = new ArrayList<>();
        list.add(new Node(-1));
        int last = -1;
        for (int x : nums)
        {
            if (x!=last)
            {
                list.add(new Node(x));
            }
            else
            {
                list.get(list.size()-1).addFreq(1);
            }
            last = x;
        }
        int sumFreq = 0;
        for (Node node : list)
        {
            sumFreq += node.freq;
            node.addPrefix(sumFreq);
        }
        int max = 0;
        for (int index=1; index<list.size(); index++)
        {
            Node node = list.get(index);
            //get smallest greater or equal x-k
            //get largest smaller or equal x+k

            //all become this num
            int floor = getFloor(list, node.val-k);
            if (floor==0)
            {
                floor++;
            }
            int ceil = getCeil(list, node.val+k);
            int sameCount = node.freq;
            int notSameCount = list.get(ceil).prefixFreq-list.get(floor-1).prefixFreq-sameCount;
            max = Math.max(max, sameCount + Math.min(notSameCount, numOperations));

            //all become something b/n x-2k to x
            floor = getFloor(list, node.val-(2*k));
            if (floor==0)
            {
                floor++;
            }
            ceil = getCeil(list, node.val);
            notSameCount = list.get(ceil).prefixFreq-list.get(floor-1).prefixFreq;
            max = Math.max(max, Math.min(notSameCount, numOperations));

            // all become something b/n x to x+2k
            floor = getFloor(list, node.val);
            if (floor==0)
            {
                floor++;
            }
            ceil = getCeil(list, node.val+(2*k));
            notSameCount = list.get(ceil).prefixFreq-list.get(floor-1).prefixFreq;
            max = Math.max(max, Math.min(notSameCount, numOperations));


        }
        return max;
    }

    private int getFloor(List<Node> list, long target)
    {
        int low = 0;
        int high = list.size()-1;
        int best = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (list.get(mid).val>=target)
            {
                best = mid;
                high = mid-1;
            }
            else
            {
                low = mid+1;
            }
        }
        return best;
    }

    private int getCeil(List<Node> list, long target)
    {
        int low = 0;
        int high = list.size()-1;
        int best = -1;
        while(low<=high)
        {
            int mid = low + (high-low)/2;
            if (list.get(mid).val>target)
            {
                high = mid-1;
            }
            else
            {
                best = mid;
                low = mid+1;
            }
        }
        return best;
    }
}

class Node
{
    long val;
    int freq;
    int prefixFreq;

    Node(long val)
    {
        this.val = val;
        this.freq = 1;
        this.prefixFreq = 0;
    }

    void addFreq(int x)
    {
        this.freq += x;
    }

    void addPrefix(int x)
    {
        this.prefixFreq = x;
    }

    @Override
    public String toString()
    {
        return "[--- "+this.val+") count : "+this.freq+" ]";
    }
}


/*


5->11->20->20


5->11->20
1  1   2

1  2   4

*/