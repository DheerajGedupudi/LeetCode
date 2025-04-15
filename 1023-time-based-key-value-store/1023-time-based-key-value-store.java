class TimeMap {

    private Map<String, TreeMap<Integer, String>> map;

    public TimeMap() {
        this.map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.map.putIfAbsent(key, new TreeMap<>());
        this.map.get(key).put(timestamp, value);
    }
    
    public String get(String key, int timestamp) {
        if (this.map.containsKey(key)==false)
        {
            return "";
        }
        TreeMap<Integer, String> timeMap = this.map.get(key);
        Integer mostRecent = timeMap.floorKey(timestamp);
        if (mostRecent==null)
        {
            return "";
        }
        return timeMap.get(mostRecent);
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */