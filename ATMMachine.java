import java.util.*;

public class ATMMachine {

	static int Pin = 0;
	static int AccountBalance = 1000;

	public static void main(String[] args) {
		ATMMachine obj = new ATMMachine();
		try {
			Pin = obj.Welcome();
			System.out.println();
			if (Pin >= 1000 && Pin <= 9999) {
				obj.Menu();
			} else {
				System.out.println("Incorrect Pin");
				System.err.println("Transaction Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Prints Bank welcome message and accept card's secret key for further
	 * validation
	 *
	 * @author Dileep
	 * @return secret pin
	 */
	public int Welcome() {
		System.out.println("------------ Welcome to ABC Bank ------------");
		System.out.println("Please Insert your card and enter 4 digit pin: ");

		Scanner sc = new Scanner(System.in);
		int secretPin = sc.nextInt();

		return secretPin;
	}

	/**
	 * Displays the Banking Options
	 *
	 * @author Dileep
	 */
	public void Menu() {
		ArrayList<String> a1 = new ArrayList<>();
		a1.add("1. Account Balance");
		a1.add("2. Cash Deposit");
		a1.add("3. Cash Withdrawl");
		a1.add("4. Pin Change");
		a1.add("5. Exit");
		
		for (String a : a1) {
			System.out.println(a);
		}
		System.out.println("Select the Option (1, 2, 3, 4, 5): ");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();

		switch (option) {
		case 1:
			System.out.println("Account Balance: " + AccountBalance);
			System.out.println("Transaction Completed..!");
			break;
		case 2: {
			System.out.println("Enter the amount: ");
			int deposit = sc.nextInt();
			AccountBalance += deposit;
			System.out.println("Account Balance: " + AccountBalance);
			System.out.println("Transaction Completed..!");

		}
			break;
		case 3: {
			System.out.println("Enter the amount: ");
			int withDrawl = sc.nextInt();
			if (withDrawl > AccountBalance) {
				System.err.println("Insufficient balance");
			} else {
				AccountBalance -= withDrawl;
				System.out.println("Account Balance: " + AccountBalance);
			}
			System.out.println("Transaction Completed..!");
		}
			break;
		case 4: {
			System.out.println("Enter current Pin: ");
			int CurrentPin = sc.nextInt();
			if (CurrentPin == Pin) {
				System.out.println("Enter new Pin: ");
				int NewPin = sc.nextInt();
				System.out.println("Pin changed Successfully..!");
			} else {
				System.err.println("Your Pin is incorrect. Transaction Failed");
				break;
			}
		}
			break;
		case 5:
			System.out.println("Transaction Ended..!");
			break;
		}
	}

}