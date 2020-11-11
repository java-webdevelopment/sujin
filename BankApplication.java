import java.util.Scanner;

public class BankApplication {
	public static void main(String[] args) {

		String customerID = null;
		String customerPW = null;

		Account account = new Account();

		Scanner scan = new Scanner(System.in);
		
		account.signIn(customerID, customerPW);

		while (true) {
			System.out.println("==================================================");
			System.out.println("Enter an option");
			System.out.println("==================================================");
			String input = scan.nextLine();
			char option = input.charAt(0);
			if ('A' <= option && option <= 'E') {
				if (option == 'A') {
					System.out.println("\n----------------------------------------");
					System.out.println("Balance = " + account.getBalance());
					System.out.println("----------------------------------------\n");
					continue;
				} else if (option == 'B') {
					System.out.println("\n----------------------------------------");
					System.out.println("Enter an amount to deposit");
					System.out.println("----------------------------------------\n");
					account.deposit();
					continue;

				} else if (option == 'C') {
					System.out.println("\n----------------------------------------");
					System.out.println("Enter an amount to withdraw");
					System.out.println("----------------------------------------\n");
					account.withdraw();
					continue;
				} else if (option == 'D') {
					account.getPreviousTransaction();
					continue;
				} else {
					System.out.println("\nExit Bank Application");
					break;
				} // if else if
			} else {
				System.out.println("\nEnter an option from A to E\n");
			}
		} // while

	}// main
}// class
