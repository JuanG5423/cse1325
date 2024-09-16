package moes;
import java.util.ArrayList;
import product.Media;
import customer.Student;
import customer.Account;
import customer.Unlimited;
import customer.Alacarte;

public class Moes
{
	private ArrayList<Media> library = new ArrayList<Media>();
	private ArrayList<Student> customers = new ArrayList<Student>();

	public void addMedia(Media media)
	{
		library.add(media);
	}

	public String getMediaList()
	{
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < library.size(); i++)
		{
			sb.append(i).append(") ").append(library.get(i).toString()).append("\n");
		}

		return sb.toString();
	}

	public void addStudent(Student student)
	{
		customers.add(student);
	}

	public String getStudentList()
	{

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < customers.size(); i++)
		{
			sb.append(i).append(") ").append(customers.get(i).toString()).append("\n");
		}

		return sb.toString();
	}

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

	public String playMedia(int studentIndex, int mediaIndex)
	{
		return customers.get(studentIndex).requestMedia(library.get(mediaIndex));
	}
}

