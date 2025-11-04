class Bank {

    private long[] vault;

    public Bank(long[] balance) {
        this.vault = balance;
    }
    
    public boolean transfer(int account1, int account2, long money) {
        //check possibility
        account1--;
        account2--;
        int n = this.vault.length;
        if (account1<0 || account1>=n || account2<0 || account2>=n)
        {
            return false;
        }
        if (this.vault[account1]<money)
        {
            return false;
        }
        this.vault[account1] -= money;
        this.vault[account2] += money;
        return true;
    }
    
    public boolean deposit(int account, long money) {
        account--;
        int n = this.vault.length;
        if (account<0 || account>=n)
        {
            return false;
        }
        this.vault[account] += money;
        return true;
    }
    
    public boolean withdraw(int account, long money) {
        account--;
        int n = this.vault.length;
        if (account<0 || account>=n)
        {
            return false;
        }
        if (this.vault[account]<money)
        {
            return false;
        }
        this.vault[account] -= money;
        return true;
    }
}

/**
 * Your Bank object will be instantiated and called as such:
 * Bank obj = new Bank(balance);
 * boolean param_1 = obj.transfer(account1,account2,money);
 * boolean param_2 = obj.deposit(account,money);
 * boolean param_3 = obj.withdraw(account,money);
 */