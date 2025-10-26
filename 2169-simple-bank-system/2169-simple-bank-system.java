class Bank {

    private long[] balance;

    public Bank(long[] balance) {
        this.balance = balance; 
    }
    
    public boolean transfer(int account1, int account2, long money) {
        account1--;
        account2--;
        // System.out.println("transfer : "+account1+" -> "+account2);
        int n = this.balance.length;
        if (account1<0 || account1>=n || account2<0 || account2>=n)
        {
            return false;
        }
        long currBalance = this.balance[account1];
        if (money<=currBalance)
        {
            this.balance[account1] -= money;
            this.balance[account2] += money;
            return true;
        }
        else
        {
            return false;
        }
    }
    
    public boolean deposit(int account, long money) {
        account--;
        int n = this.balance.length;
        if (account<0 || account>=n)
        {
            return false;
        }
        this.balance[account] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        account--;
        int n = this.balance.length;
        if (account<0 || account>=n)
        {
            return false;
        }
        long currBalance = this.balance[account];
        if (money<=currBalance)
        {
            this.balance[account] -= money;
            return true;
        }
        else
        {
            return false;
        }
        
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */