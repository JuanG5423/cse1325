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
}

