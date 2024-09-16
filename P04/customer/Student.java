package customer;
import product.Media;


/**
 * Represents a student and holds their data
 *
 * @author Juan Guajardo Gutierrez
 * @version 0.2
 * @since 0.1
 */

public class Student
{
	private String name;
	private int id;
	private String email;
	private Account account;

	/**
	 * Creates a Student instance after ensuring they use a valid email address
	 *
	 * @param name A String with the student's name
	 * @param id An int with the student's ID number
	 * @param email A String with the student's email address
	 * @param unlimited A boolean indicating if the student possesses an Unlimited account
	 * @since 0.1
	 */ 

	public Student(String name, int id, String email, boolean unlimited)
	{
		if (!(email.endsWith("@uta.edu") || email.endsWith("@mavs.uta.edu")))
		{
			throw new IllegalArgumentException("Non-UTA email address: " + email);
		}
		else
		{
			this.name = name;
			this.id = id;
			this.email = email;
			
			if (unlimited)
			{
				this.account = new Unlimited();
			}
			else
			{
				this.account = new Alacarte();
			}
		}
	}

	/**
	 * Retrieves the student's account
	 *
	 * @return The student's account
	 * @since 0.2
	 */

	public Account getAccount()
	{
		return this.account;
	}

	/**
	 * Plays the requested media
	 *
	 * @param media The Media instance to be played
	 * @return A String indicating that the media is being played
	 * @since 0.1
	 */

	public String requestMedia(Media media)
	{
		return account.play(media);
	}

	/**
	 * Returns a String representation of the Student instance
	 *
	 * @return A string in the format [name] ([id], [email], Account #[accountNumber])
	 * @since 0.1
	 */

	@Override
	public String toString()
	{
		return name + " (" + id + ", " + email + ", " + "Account #" + account.getAccountNumber() + ")";
	}
}
