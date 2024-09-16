package moes;
import java.util.ArrayList;
import product.Media;
import customer.Student;

public class Moes
{
	private ArrayList<Media> library;
	private ArrayList<Student> customers;

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

}
