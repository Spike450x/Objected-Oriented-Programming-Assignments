/*
    SAVINGS ACCOUNT CLASS
*/
public class SavingsAccount {
    // Declare variables
    private static double annualInterestRate;
    private double savingsBalance;
    // Constructor Method
    public SavingsAccount(double amount) {
        this.savingsBalance = amount;
    }
    // Print starting balance for Savings Account One
    public void printOriginalBalanceOne () {
        System.out.println("--------------------------------------------------");
        System.out.printf("STARTING BALANCE FOR SAVINGS ACCOUNT ONE: $%.2f\n", this.savingsBalance);
        System.out.println("--------------------------------------------------");
    }
    // Print starting balance for Savings Account Two
    public void printOriginalBalanceTwo () {
        System.out.println("--------------------------------------------------");
        System.out.printf("STARTING BALANCE FOR SAVINGS ACCOUNT TWO: $%.2f\n", this.savingsBalance);
        System.out.println("--------------------------------------------------");
    }
    // Modify interest rate by setting annual interest rate to a new value
    public static void modifyInterestRate(double newInterestRate) {
        annualInterestRate = newInterestRate;
    }
    // Prints the interest rate
    public void printInterestRate () {
        System.out.println("Monthly Interest Rate: " + (annualInterestRate * 100) + "%");
        System.out.println();
    }
    //Method to calculate monthly interest
    public void calculateMonthlyInterest() {
        double intRate;
        intRate = (this.savingsBalance * annualInterestRate) / 12;
        this.savingsBalance = this.savingsBalance + intRate;
    }
    // Statement to print each month
    public void printDetails(int i) {
        System.out.print("Month " + (i+1)+": ");
    }
    // Statement to get the final balance after a year
    public double getFinal() {
        return this.savingsBalance;
    }
    // Print New Value
    public void printBalance() {
        System.out.printf("\t   $%.2f", this.savingsBalance);
    }
}

