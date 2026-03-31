class PhoneDirectory {

    private LinkedHashSet<Integer> available;
    private int maxNumber;

    public PhoneDirectory(int maxNumbers) {
        this.available = new LinkedHashSet<>();
        this.maxNumber = maxNumbers;
        for (int i=0; i<maxNumbers; i++)
        {
            this.available.add(i);
        }
    }
    
    public int get() {
        if (this.available.size()==0)
        {
            return -1;
        }
        int top = this.available.getFirst();
        this.available.remove(top);
        return top;
    }
    
    public boolean check(int number) {
        return this.available.contains(number);
    }
    
    public void release(int number) {
        this.available.addLast(number);
    }
}

/**
 * Your PhoneDirectory object will be instantiated and called as such:
 * PhoneDirectory obj = new PhoneDirectory(maxNumbers);
 * int param_1 = obj.get();
 * boolean param_2 = obj.check(number);
 * obj.release(number);
 */