public class SavingAccount extends Account {
    //Default fee
    private static double interestRate = 2.5;

    public SavingAccount() {
        super();
    }

    /**
     * Assign our custom values
     *
     * @param savingsAccountNumber
     * @param interest
     */
    public SavingAccount(int savingsAccountNumber, double interest) {
        super(savingsAccountNumber);
        this.interestRate = interest;
    }

    //Getter method
    public double getInterestRate() {
        return interestRate;
    }

    //Setter method
    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calcInterest() {
        return balance * (interestRate * 0.01);
    }

    public void applyInterest() {
        double interestEarned = calcInterest();
        System.out.printf("Your have earned %.2f interest. It has been deposited to your account.", interestEarned);
        depositAmount(interestEarned);
    }

    /**
     * Fun to deposit amount int acc as long as
     * acc amount <>0</>
     * apply transactional fee for checking account and
     * not for savings account
     *
     * @param amount
     */
    public void depositAmount(double amount) {
        if (amount > 0) {
            balance += amount ;
            System.out.printf("Amount %.2f deposited successfully%n. Your new balance is %.2f.", amount, balance);
        } else {
            System.out.println(" Amount MUST be greater than zero!");
        }
    }

    /**
     * Amount to withdrawal > 0;
     * Amount to deposit must <= balance
     *
     * @param amount
     */
    public void withdrawalAmount(double amount) {
        if ((amount + (amount * (interestRate / 100)) <= balance)) {
            balance -= amount - (amount * (interestRate / 100));
            System.out.printf("Amount %.2f withdrawn successfully%n. Your new balance is %.2f.", amount, balance);
        } else {
            System.out.println(" Insufficient balance!");
        }
    }
}
