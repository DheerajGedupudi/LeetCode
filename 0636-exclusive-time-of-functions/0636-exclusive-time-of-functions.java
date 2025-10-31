class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        int[] count = new int[n];
        Deque<Node> stack = new ArrayDeque<>();
        for (String log : logs)
        {
            String[] arr = log.split(":");
            int id = Integer.parseInt(arr[0]);
            String status = arr[1];
            int ts = Integer.parseInt(arr[2]);
            int currTime = ts;
            if (status.equals("start"))
            {
                if (stack.isEmpty()==false)
                {
                    Node lastNode = stack.peek();
                    int diff = currTime-lastNode.lastStart;
                    count[lastNode.id] += diff;
                    // System.out.println(id+" gets "+diff+" new start ");
                }
                stack.push(new Node(id, currTime));
            }
            else
            {
                Node lastNode = stack.pop();
                int diff = currTime+1-lastNode.lastStart;
                count[lastNode.id] += diff;
                // System.out.println(id+" gets "+diff+" ending ");
                if (stack.isEmpty()==false)
                {
                    stack.peek().lastStart = currTime+1;
                }
            }
        }
        return count;
    }
}

class Node
{
    int id;
    int lastStart;

    Node(int id, int start)
    {
        this.id = id;
        this.lastStart = start;
    }
}