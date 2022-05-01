public class CheckingAccount extends Account {
    //Default fee
    private static double FEE = 2.0;

    public CheckingAccount(){
        super();
    }

    /**
     * Assign our custome values
     * @param checkingAccountNumber
     * @param fee
     */
    public CheckingAccount(int checkingAccountNumber, double fee){
        super(checkingAccountNumber);
        FEE = fee;
    }
    /**
     *Fun to deposit amount int acc as long as
     * acc amount <>0</>
     * apply transactional fee for checking account and
     * not for savings account
     * @param amount
     */
    public void depositAmount(double amount){
        if ( amount > 0 ){
            balance += amount-(amount*(FEE/100));
            System.out.printf("Amount %.2f deposited successfully%n. Your new balance is %.2f.", amount,balance);
        } else {
            System.out.println(" Amount MUST be greater than zero!");
        }
    }

    /**
     * Amount to withdrawal > 0;
     * Amount to deposit must <= balance
     * @param amount
     */
    public void withdrawalAmount(double amount){
        if ( (amount + (amount*(FEE/100)) <= balance)  ){
            balance -= amount-(amount*(FEE/100));
            System.out.printf("Amount %.2f withdrawal successfully%n. Your new balance is %.2f.", amount,balance);
        } else {
            System.out.println(" Insufficient balance!");
        }
    }

}
