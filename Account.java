import java.util.Scanner;

public class Account {
	private int balance = 0;
	private int previousTransaction = 0;
	private String customerID = "ksj";
	private String customerPW = "0000";
	
	Scanner scan = new Scanner(System.in);

	public void signIn(String customerID, String customerPW) {
		while (true) {
			System.out.print("Enter your ID>> ");
			customerID = scan.nextLine();
			System.out.print("Enter your PW>> ");
			customerPW = scan.nextLine();
			System.out.println();

			if (this.customerID.equals(customerID) && this.customerPW.equals(customerPW)) {
				showMenu();
				break;
			} else {
				System.out.println("\n-------------------------------------");
				System.out.println("Check your ID and PW");
				System.out.println("-------------------------------------\n");
				continue;
			} // if else
		} // while
	}//signIn

	public int getBalance() {
		return balance;
	}

	public void deposit() {
		int deposit_amount = Integer.parseInt(scan.nextLine());
		previousTransaction = deposit_amount;
		balance += deposit_amount;
		System.out.println();
	}// deposit()

	public void withdraw() {
		int withdraw_amount = Integer.parseInt(scan.nextLine());
		if (balance > withdraw_amount) {
			previousTransaction = -withdraw_amount;
			balance -= withdraw_amount;
			System.out.println();
		} else {
			System.out.println("\n----------------------------------------");
			System.out.println("Insuficient balance. Check your balance");
			System.out.println("----------------------------------------\n");
		}
	}// withdraw()

	public void getPreviousTransaction() {
		if (previousTransaction > 0) {
			System.out.println("\n----------------------------------------");
			System.out.println("Deposited : " + previousTransaction);
			System.out.println("----------------------------------------\n");
		} else if (previousTransaction < 0) {
			System.out.println("\n----------------------------------------");
			System.out.println("Withdrawn : " + (-previousTransaction));
			System.out.println("----------------------------------------\n");
		} else {
			System.out.println("\n----------------------------------------");
			System.out.println("Previous Transaction is not exist");
			System.out.println("----------------------------------------\n");
		} // if else if
	}// getPreviousTransaction()

	public void showMenu() {
		System.out.println("A. Check Balance");
		System.out.println("B. Deposit");
		System.out.println("C. Withdraw");
		System.out.println("D. Previous Transaction");
		System.out.println("E. Exit");
	}// showMenu()

}
