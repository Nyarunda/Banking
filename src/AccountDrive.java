import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class AccountDrive {
    public static void main(String[] args) {
        Scanner scannerIn = new Scanner(System.in);

        //Accounts array
        Account accounts[] = new Account[4];
        int numAccounts = 0;

        int choice;

        do {
            choice = menu(scannerIn);
            System.out.println();

            if ( choice == 1 ){
                accounts[numAccounts++] = createAccount(scannerIn);
            } else if (choice == 2){
                doDepositing(accounts, numAccounts, scannerIn);
            } else if (choice == 3){
                doWithdrawal(accounts, numAccounts, scannerIn);
            } else if (choice == 4){
                applyInterest(accounts, numAccounts, scannerIn);
            } else {
                System.out.println("Thanks for Banking with Us");
            }
            System.out.println();

        } while ( choice!= 5);
    }

    public static int searchAccount(Account accounts[], int count, int accountNo){
        for (int i = 0; i < count; i++){
            if (accounts[i].getAccountNo() == accountNo){
                return  i;
            }
        }
        return -1;
    }

    /**
     * Func to perform depositing of money
     * @param accounts
     * @param count
     * @param scannerIn
     */
    public static void doDepositing(Account accounts[], int count, Scanner scannerIn){

        //Get the account no
        doPrint();
        int accountNo = scannerIn.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNo);

        //Get user amount
        if (index >= 0 ) {
            System.out.println("Please amount to Deposit: ");
            double amount = scannerIn.nextDouble();

            accounts[index].depositAmount(amount);
        } else {
            System.out.println("No Account found with: " +accountNo);
        }
    }

    public static void doWithdrawal(Account accounts[], int count, Scanner scannerIn){

        //Get the account no
        doPrint();
        int accountNo = scannerIn.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNo);

        //Get user amount
        if (index >= 0 ) {
            System.out.println("Please amount to Withdraw: ");
            double amount = scannerIn.nextDouble();

            accounts[index].withdrawalAmount(amount);
        } else {
            System.out.println("No Account found with: " +accountNo);
        }
    }

    public static void applyInterest(Account accounts[], int count, Scanner scannerIn){

        //Get the account no
        doPrint();
        int accountNo = scannerIn.nextInt();

        //search for account
        int index = searchAccount(accounts, count, accountNo);

        //Get user amount
        if (accounts[index] instanceof SavingAccount ) {
            ((SavingAccount)accounts[index]).applyInterest();
        } else {
            System.out.println("No Account found with: " +accountNo);
        }
    }

    public static void doPrint(){
        System.out.print("\nPlease enter the account number: ");
    }

    /**
     * Account choices
     * @param scannerIn user input choice
     * @return choice
     */
    public static int accountMenu(Scanner scannerIn){
        System.out.println("Select th account type");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");
        int choice;
        do {
            System.out.print("Enter your account type choice: ");
            choice = scannerIn.nextInt();
        } while (choice < 0 || choice > 2);

        return choice;
    }

    /**
     * Func to create an account
     * @param scannerIn
     * @return account
     */
    public static Account createAccount(Scanner scannerIn){

        Account account = null;
        int choice = accountMenu(scannerIn);

        int accountNo;
        System.out.print("Enter your Acc Number: ");
        accountNo = scannerIn.nextInt();

        if (choice == 1) { //checking acc
            System.out.println("Enter Transactional Fee: ");
            double fee = scannerIn.nextDouble();

            account = new CheckingAccount(accountNo, fee);
        } else {
            System.out.println("Enter your interest rate: ");
            double interestRate = scannerIn.nextDouble();

            account = new SavingAccount(accountNo, interestRate);
        }
        return account;

    }

    /**
     * Get the user selections
     * @param scannerIn
     * @return the choice
     */
    public static int menu(Scanner scannerIn){
        System.out.println("*********Bank Account Menu");
        System.out.println("1. Create Bank Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdrawal Money");
        System.out.println("4. Apply Interest");
        System.out.println("5. Quit");

        int choice;

        do {
            System.out.print("Enter your choice: ");
            choice = scannerIn.nextInt();
        } while (choice < 1 || choice >4);

        return choice;
    }
}
