class PhoneDirectory {

    private LinkedHashSet<Integer> available;
    private Set<Integer> taken;
    private int maxNumber;

    public PhoneDirectory(int maxNumbers) {
        this.available = new LinkedHashSet<>();
        this.taken = new HashSet<>();
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
        this.taken.add(top);
        return top;
    }
    
    public boolean check(int number) {
        return this.available.contains(number);
    }
    
    public void release(int number) {
        this.taken.remove(number);
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