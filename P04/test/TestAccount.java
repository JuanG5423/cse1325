package test;
import customer.Account;

public class TestAccount
{
	public static void main(String[] args)
	{
		Account firstAccount = new Account();
		Account secondAccount = new Account();

		if (firstAccount.getAccountNumber() != 1)
		{
			System.err.println("FAIL: Account number for the first account should be 1, but it is " + firstAccount.getAccountNumber());
			System.exit(69);
		}

		if (secondAccount.getAccountNumber() != 2)
		{
			System.err.println("FAIL: Account number for the second account should be 2, but it is " + secondAccount.getAccountNumber());
			System.exit(69);
		}
	}
}
