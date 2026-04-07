class Robot {

    private int x;
    private int y;
    private String[] names;
    private int index;
    private int w;
    private int h;
    private int curr;
    private boolean startedMoving;

    private int[] flat;

    public Robot(int w, int h) {
        this.w = w;
        this.h = h;
        this.x = 0;
        this.y = 0;
        this.flat = new int[(w+h)*2-4];
        for (int i=1; i<w; i++)
        {
            flat[i] = 3;
        }
        for (int i=w; i<(w+h-1); i++)
        {
            flat[i] = 0;
        }
        for (int i=(w+h-1); i<(w+h+w-2); i++)
        {
            flat[i] = 1;
        }
        for (int i=(w+h+w-2); i<(w+h+w+h-4); i++)
        {
            flat[i] = 2;
        }
        flat[0] = 2;
        this.names = new String[]{"North", "West", "South", "East"};
        this.index = 3; // East
        this.curr = 0;
        this.startedMoving = false;
    }

    private int getFlat(int x, int y)
    {
        if (y==0)
        {
            return x;
        }
        if (x==this.w-1)
        {
            return this.w+y-1;
        }
        if (y==this.h-1)
        {
            return this.w+this.h-3+(this.w-x);
        }
        if (x==0)
        {
            return this.w*2+this.h-4+(this.h-y);
        }
        return -1;
    }

    private int[] getCord(int index)
    {
        int x = 0;
        int y = 0;
        if (index < this.w)
        {
            x = index;
            y = 0;
        }
        else if (index < this.w + this.h - 1)
        {
            x = this.w - 1;
            y = index - this.w + 1;
        }
        else if (index < 2 * this.w + this.h - 2)
        {
            x = 2 * this.w + this.h - 2 - index - 1;
            y = this.h - 1;
        }
        else
        {
            x = 0;
            y = 2 * this.w + 2 * this.h - 4 - index;
        }
        return new int[]{x, y};
    }
    
    public void step(int num) {
        if (num>0)
        {
            this.startedMoving = true;
        }
        this.curr += num;
        this.curr %= this.flat.length;
    }
    
    public int[] getPos() {
        return getCord(this.curr);
    }
    
    public String getDir() {
        if (this.startedMoving==false && this.curr==0)
        {
            return "East";
        }
        return this.names[this.flat[this.curr]];
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(w, h);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */