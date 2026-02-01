class HitCounter {

    private TreeMap<Integer, Integer> timeHitMap;
    private int counter;

    public HitCounter() {
        this.timeHitMap = new TreeMap<>();
        this.timeHitMap.put(0, 0);
        this.counter = 0;
    }
    
    public void hit(int timestamp) {
        this.timeHitMap.put(timestamp, ++counter);
    }
    
    public int getHits(int timestamp) {
        int lastTime = Math.max(0, timestamp-300);
        Integer up = this.timeHitMap.floorKey(timestamp);
        Integer bottom = this.timeHitMap.floorKey(lastTime);
        // System.out.println("for : "+timestamp+" , it is till : "+lastTime+" => keys : "+bottom+" to "+up);
        if (up==null || bottom==null)
        {
            return 0;
        }
        return this.timeHitMap.get(up)-this.timeHitMap.get(bottom);
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */