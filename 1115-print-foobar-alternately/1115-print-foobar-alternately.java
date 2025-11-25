class FooBar {
    private int n;
    private AtomicBoolean fooTime;

    public FooBar(int n) {
        this.n = n;
        this.fooTime = new AtomicBoolean(true);
    }

    public void foo(Runnable printFoo) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
        	// printFoo.run() outputs "foo". Do not change or remove this line.
            while (this.fooTime.get()==false);
            printFoo.run();
            this.fooTime.set(false);
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {
        
        for (int i = 0; i < n; i++) {
            
            // printBar.run() outputs "bar". Do not change or remove this line.
            while (this.fooTime.get());
            printBar.run();
            this.fooTime.set(true);
        }
    }
}