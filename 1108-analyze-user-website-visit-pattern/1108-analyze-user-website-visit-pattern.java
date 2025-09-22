class Solution {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        int n = username.length;
        List<Node> list = new ArrayList<>();
        for (int i=0; i<n; i++)
        {
            list.add(new Node(username[i], timestamp[i], website[i]));
        }
        Collections.sort(list, (a,b)->(a.timestamp-b.timestamp));
        // System.out.println(list);
        Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i<n; i++)
        {
            map.putIfAbsent(list.get(i).username, new ArrayList<>());
            map.get(list.get(i).username).add(list.get(i).website);
        }
        Map<List<String>, Integer> entries = new HashMap<>();
        for (String name : map.keySet())
        {
            List<String> sites = map.get(name);
            int len = sites.size();
            Set<List<String>> set = new HashSet<>();
            List<String> path = new ArrayList<>();
            for (int i=0; i<len; i++)
            {
                String a = sites.get(i);
                path.add(a);
                for (int j=i+1; j<len; j++)
                {
                    String b = sites.get(j);
                    path.add(b);
                    for (int k=j+1; k<len; k++)
                    {
                        String c = sites.get(k);
                        path.add(c);
                        List<String> triple = new ArrayList<>(path);
                        set.add(triple);
                        path.remove(path.size()-1);
                    }
                    path.remove(path.size()-1);
                }
                path.remove(path.size()-1);
            }
            for (List<String> triple : set)
            {
                entries.put(triple, entries.getOrDefault(triple, 0)+1);
            }
        }
        List<String> result = null;
        for (List<String> triple : entries.keySet())
        {
            int freq = entries.get(triple);
            if (result==null)
            {
                result = triple;
            }
            if (entries.get(triple)>=entries.get(result))
            {
                if (entries.get(triple)==entries.get(result))
                {
                    if (compare(triple, result)<0)
                    {
                        result = triple;
                    }
                }
                else
                {
                    result = triple;
                }
            }
        }
        return result;
    }

    int compare(List<String> list1, List<String> list2)
    {
        int len = Math.min(list1.size(),list2.size());
        for (int i=0; i<len; i++)
        {
            if (list1.get(i).compareTo(list2.get(i))==0)
            {
                continue;
            }
            return list1.get(i).compareTo(list2.get(i));
        }
        return 0;
    }
}

class Node
{
    String username;
    int timestamp;
    String website;

    Node(String u, int t, String w)
    {
        this.username = u;
        this.timestamp = t;
        this.website = w;
    }

    @Override
    public String toString()
    {
        return "time : "+this.timestamp+", name : "+this.username+", site : "+this.website+"\n";
    }
}
