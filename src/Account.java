public abstract class Account {
    //Account Number
    private int accountNo;
    //Balance
    private double balance;

    //Default Constructor
    public Account(){

    }

    public Account(int accountNo){
        this.accountNo = accountNo;
        balance = 0;
    }

    //Getter Methods
    public double getBalance() {
        return balance;
    }

    public int getAccountNo() {
        return accountNo;
    }

    //abstract
    /**
     *Fun to deposit amount int acc as long as
     * acc amount <>0</>
     * apply transactional fee for checking account and
     * not for savings account
     * @param amount
     */
    public abstract void depositAmount(double amount);

    /**
     * Amount to withdrawal > 0;
     * Amount to deposit must <= balance
     * @param amount
     */
    public abstract void withdrawalAmount(double amount);

}
