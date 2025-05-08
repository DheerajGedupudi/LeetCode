class Logger {

    Map<String, Integer> map;

    public Logger() {
        this.map = new HashMap<>();
    }
    
    public boolean shouldPrintMessage(int timestamp, String message) {
        Integer lastTime = this.map.getOrDefault(message, -100);
        if (timestamp>=(lastTime+10))
        {
            this.map.put(message, timestamp);
            return true;
        }
        else
        {
            return false;
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */