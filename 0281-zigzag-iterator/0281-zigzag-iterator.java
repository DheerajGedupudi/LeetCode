public class ZigzagIterator {

    private Iterator it1;
    private Iterator it2;
    private boolean flag;

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        this.it1 = v1.iterator();
        this.it2 = v2.iterator();
        this.flag = true;
    }

    public int next() {
        if (this.flag)
        {
            this.flag = false;
            int x = (int) this.it1.next();
            // System.out.println(x);
            return x;
        }
        else
        {
            this.flag = true;
            int x = (int) this.it2.next();
            // System.out.println(x);
            return x;
        }
    }

    public boolean hasNext() {
        if (this.it1.hasNext()==false && this.it2.hasNext()==false)
        {
            return false;
        }
        else if (this.it1.hasNext()==false)
        {
            this.flag = false;
            return this.it2.hasNext();
        }
        else if (this.it2.hasNext()==false)
        {
            this.flag = true;
            return this.it1.hasNext();
        }
        else
        {
            if (this.flag)
            {
                // this.flag = false;
                return this.it1.hasNext();
            }
            else
            {
                // this.flag = true;
                return this.it2.hasNext();
            }
        }
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */