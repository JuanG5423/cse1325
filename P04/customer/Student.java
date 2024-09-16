package customer;
import product.Media;

public class Student
{
	private String name;
	private int id;
	private String email;
	private Account account;

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

	public Account getAccount()
	{
		return this.account;
	}

	public String requestMedia(Media media)
	{
		return account.play(media);
	}

	@Override
	public String toString()
	{
		return name + " (" + id + ", " + email + ", " + "Account #" + account.getAccountNumber() + ")";
	}
}
