package wipro;
import java.util.*;
public class BankingApplication {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		BankAccount ba = new BankAccount();
		while (true) {
		    System.out.println("Enter name: ");
		    String n = sc.nextLine();
		    if (n != null && !n.isEmpty()) {
		        ba.setName(n);
		        break;
		    } else {
		        System.out.println("Invalid name! Please enter a non-empty name.");
		    }
		}

		while(true) {
			System.out.println("Enter accountNumber: ");
			int a = sc.nextInt();
			if(a>0) {
				ba.setAccountNumber(a);
				break;
			}
			else {
				System.out.println("Invalid account number! Enter valid account number.");
			}
		}
		while(true) {
			System.out.println("Enter Initial Balance: ");
			int b = sc.nextInt();
			if(b>0) {
				ba.setBalance(b);
				break;
			}
			else {
				System.out.println("Enter positive balance");
			}
		}
		ba.display();
		 while (true) {
	            System.out.println("Enter the amount to be deposited: ");
	            int n = sc.nextInt();
	            if (n > 0) {
	                ba.addBalance(n);
	                break;
	            } else {
	                System.out.println("Only positive amount should be added. Try again.");
	            }
	        }
	        System.out.println("Balance after deposit: " + ba.getBalance());
	       while (true) {
	            System.out.println("Enter the amount to be withdrawn: ");
	            int m = sc.nextInt();
	            if (m > 0 && m <= ba.getBalance()) {
	                ba.removeBalance(m);
	                break;
	            } else if (m <= 0) {
	                System.out.println("Only positive amount can be withdrawn. Try again.");
	            } else {
	                System.out.println("No funds. Enter an amount up to current balance.");
	            }
	        }
	        System.out.println("Balance after withdraw: " + ba.getBalance());
    }
}
class BankAccount {
	private String name;
	private int accountNumber;
	private int balance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public int addBalance(int a) {
			balance += a;
		return balance;
	}
	public int removeBalance(int b) {
			balance-=b;
		return balance;
	}
	public void display() {
		System.out.println("Account Holder: " + name);
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Balance: " + balance);
	}
}
