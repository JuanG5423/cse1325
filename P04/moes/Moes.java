package moes;
import java.util.ArrayList;
import product.Media;
import customer.Student;
import customer.Account;
import customer.Unlimited;
import customer.Alacarte;

/**
 * Maverick Online Entertainment System, a class for managing students and media
 *
 * @author	Juan Guajardo Gutierrez
 * @version	0.1
 * @since	0.1
 */

public class Moes
{
	private ArrayList<Media> library = new ArrayList<Media>();
	private ArrayList<Student> customers = new ArrayList<Student>();

	/**
	 * Adds a piece of media to the library
	 *
	 * @param media	A Media instance
	 * @since 0.1
	 */

	public void addMedia(Media media)
	{
		library.add(media);
	}

	/**
	 * Retrieves a list of all the media in the library
	 *
	 * @return A string in a menu format. Each line is in the format [mediaIndex]) [media]
	 * @since 0.1
	 */

	public String getMediaList()
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < library.size(); i++)
		{
			sb.append(i).append(") ").append(library.get(i).toString()).append("\n");
		}

		return sb.toString();
	}

	/**
	 * Adds a student to the list of customers
	 *
	 * @param student A Student instance
	 * @since 0.1
	 */

	public void addStudent(Student student)
	{
		customers.add(student);
	}

	/**
	 * Retrieves a list of all the students
	 *
	 * @return A string in a menu format. Each line is in the format [studentIndex]) [student]
	 * @since 0.1
	 */

	public String getStudentList()
	{

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < customers.size(); i++)
		{
			sb.append(i).append(") ").append(customers.get(i).toString()).append("\n");
		}

		return sb.toString();
	}

	/**
	 * Retrieves the number of points a student holds
	 *
	 * @param studentIndex	An int holding the index of a student in the customer list
	 * @return The number of points in the student's account if they have an Alacarte account. Integer.MAX_VALUE if the student has an Unlimited account.
	 * @since 0.1
	 */

	public int getPoints(int studentIndex)
	{
		Account account = customers.get(studentIndex).getAccount();

		if (account instanceof Alacarte)
		{
			Alacarte alacarteAccount = (Alacarte) account;
			return alacarteAccount.getPointsRemaining();
		}
		else if (account instanceof Unlimited)
		{
			return Integer.MAX_VALUE;
		}
		else
		{
			throw new UnsupportedOperationException("Unknown subclass of Account");
		}
	}

	/**
	 * Adds points to a student's account
	 *
	 * @param studentIndex An int holding the index of a student in the customer list
	 * @param points An int with the number of points to be bought
	 * @return A message indicating how many points the student has after the purchase if they hold an Alacarte account. Returns a message indicating that the student doesn't need additional points if they hold an Unlimited account.
	 * @since 0.1
	 */

	public String buyPoints(int studentIndex, int points)
	{
		Account account = customers.get(studentIndex).getAccount();

		if (account instanceof Alacarte)
		{
			Alacarte alacarteAccount = (Alacarte) account;
			alacarteAccount.buyPoints(points);
			return "You now have " + alacarteAccount.getPointsRemaining() + " points";
		}
		else if (account instanceof Unlimited)
		{
			return "You have an unlimited account and don't need additional points";
		}
		else
		{
			throw new UnsupportedOperationException("Unknown subclass of Account");
		}
	}

	/**
	 * Plays a student's media
	 *
	 * @param studentIndex An int holding the index of a student in the customer list
	 * @param mediaIndex An int holding the index of a media in the library list
	 * @return A message indicating that the media is being played
	 * @since 0.1
	 */

	public String playMedia(int studentIndex, int mediaIndex)
	{
		return customers.get(studentIndex).requestMedia(library.get(mediaIndex));
	}
}

