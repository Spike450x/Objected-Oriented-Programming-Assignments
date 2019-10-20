/*
    Joshua Wood
    Problem 2
    COP 3330 - Fall 2019
    October 19, 2019

    Create class SavingsAccount. Use a static variable annualInterestRate to store the
    annual interest rate for all account holders. Each object of the class contains a private
    instance variable savingsBalance indicating the amount the saver currently has on deposit.
    Provide method calculateMonthlyInterest to calculate the monthly interest by multiplying the
    savingsBalance by annualInterestRate divided by 12—this interest should be added to savingsBalance.
    Provide a static method modifyInterestRate that sets the annualInterestRate to a new value.

    Write a program to test class SavingsAccount. Instantiate two SavingsAccount objects, saver1 and saver2, with
    balances of $2000.00 and $3000.00, respectively. Set annualInterestRate to 4%, then calculate the monthly interest
    for each of 12 months and print the new balances for both savers. Next, set the annualInterestRate to 5%, calculate
    the next month’s interest and print the new balances for both savers.
*/
public class Application {
    public static void main(String[] args) {
        // Variable Declaration
        final double SAVING_ONE_AMOUNT = 2000.0;
        final double SAVING_TWO_AMOUNT = 3000.0;
        final double ANNUAL_INTEREST_RATE = 0.04;
        final double NEW_INTEREST_RATE =0.05;

        SavingsAccount saver1 = new SavingsAccount (SAVING_ONE_AMOUNT);
        SavingsAccount saver2 = new SavingsAccount (SAVING_TWO_AMOUNT);
        SavingsAccount.modifyInterestRate (ANNUAL_INTEREST_RATE);
        System.out.println();
        saver1.printOriginalBalanceOne();
        System.out.println();
        saver2.printOriginalBalanceTwo();
        for (int i = 0; i < 2; i++) {
            System.out.println();
            saver1.printInterestRate();
            System.out.println("Savings Account One New Balance:");
            printHeader();
            printSaver1(saver1);
            System.out.println();
            System.out.println("Savings Account Two New Balance:");
            printHeader();
            printSaver2(saver2);
            System.out.println();
            SavingsAccount.modifyInterestRate(NEW_INTEREST_RATE);
        }
    }
    public static void printHeader() {
        System.out.println("\n#######################");
        System.out.println("MONTH\t\t   BALANCE");

    }
    // Print the details for savings account one
    private static void printSaver1 (SavingsAccount saver1) {
        for(int i = 0; i < 12; i++) {
            saver1.calculateMonthlyInterest();
            saver1.printDetails(i);
            saver1.printBalance();
            System.out.println();
        }
        // Prints the final balance after each year for account one
        double yearFinal = saver1.getFinal();
        System.out.printf("\nACCOUNTS FINAL YEAR BALANCE: $%.2f\n", yearFinal);
    }
    // Print the details for savings account two
    private static void printSaver2 (SavingsAccount saver2) {
        for(int i = 0; i < 12; i++) {
            saver2.calculateMonthlyInterest();
            saver2.printDetails(i);
            saver2.printBalance();
            System.out.println();
        }
        // Prints the final balance after each year for account two
        double yearFinal = saver2.getFinal();
        System.out.printf("\nACCOUNTS FINAL YEAR BALANCE: $%.2f\n", yearFinal);
    }
}
