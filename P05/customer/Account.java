package customer;
import product.Media;

/**
 * Abstract class used for managing the accounts
 * @author Juan Guajardo Gutierrez
 * @version 0.2
 * @since 0.1
 */

public abstract class Account
{
	private int accountNumber;
	private static int nextAccountNumber = 1;

	/**
	 * Creates an Account instance and automatically assigns an account number
	 * @since 0.1
	 */

	public Account()
	{
		this.accountNumber = nextAccountNumber;
		nextAccountNumber++;
	}

	/**
	 * Retrieves the account's number
	 * @return An int with the account's number
	 * @since 0.1
	 */

	public int getAccountNumber()
	{
		return accountNumber;
	}

	/**
	 * Abstract method for playing a Media instance
	 * @param media A Media instance
	 * @return A String indicating the status of playing the media
	 * @since 0.2
	 */

	public abstract String play(Media media);
}

