class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        int n = numberOfUsers;
        Collections.sort(events, new EventComparator());
        int[] offlineTill = new int[n];
        boolean[] online = new boolean[n];
        Arrays.fill(online, true);
        int[] result = new int[n];
        for (List<String> event : events)
        {
            String action = event.get(0);
            int time = Integer.parseInt(event.get(1));
            String mentioned = event.get(2);
            //update online list
            for (int i=0; i<n; i++)
            {
                if (time>=offlineTill[i])
                {
                    online[i] = true;
                }
            }
            if (action.equals("MESSAGE"))
            {
                //MESSAGE
                if (mentioned.equals("ALL"))
                {
                    for (int i=0; i<n; i++)
                    {
                        result[i]++;
                    }
                }
                else if (mentioned.equals("HERE"))
                {
                    for (int i=0; i<n; i++)
                    {
                        if (online[i])
                        {
                            result[i]++;
                        }
                    }
                }
                else
                {
                    String[] mentions = mentioned.split(" ");
                    for (String mention : mentions)
                    {
                        String num = mention.substring(2);
                        int id = Integer.parseInt(num);
                        result[id]++;
                    }
                }
            }
            else
            {
                //OFFLINE
                int id = Integer.parseInt(mentioned);
                offlineTill[id] = time+60;
                online[id] = false;
            }
        }
        return result;
    }
}

class EventComparator implements Comparator<List<String>>
{
    @Override
    public int compare(List<String> e1, List<String> e2)
    {
        int t1 = Integer.parseInt(e1.get(1));
        int t2 = Integer.parseInt(e2.get(1));
        if (t1==t2)
        {
            return e2.get(0).compareTo(e1.get(0));
        }
        return Integer.compare(t1, t2);
    }
}