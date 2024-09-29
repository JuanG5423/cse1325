package mdi;
import moes.Moes;
import product.Media;
import customer.Student;
import java.util.Scanner;

public class Main
{
	private Moes moes;
	private String output;
	private Menu menu;
	private boolean running;

	private void addStudent()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the student's name: ");
		String name = in.nextLine();
		
		System.out.print("\nEnter the student's ID number: ");
		int id = in.nextInt();
		
		System.out.print("\nEnter the student's @mavs.uta.edu or @uta.edu email address: ");
		String email = in.nextLine();
		
		System.out.print("\nEnter a for an Alacarte account or u for an Unlimited account");
		boolean isUnlimited = in.nextLine().equals("u");
		addStudent(new Student(name, id, email, isUnlimited);
	}

	private void listStudents()
	{
		System.out.println(getStudentList());
	}

	private void addMedia()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("Enter the title of the media: ");
		String title = in.nextLine();

		System.out.print("\nEnter its URL: ");
		String url = in.nextLine();

		System.out.print("\nHow many points will this media cost? ");
		int points = in.nextInt();

		addMedia(new Media(title, url, points));
	}

	private void listMedia()
	{
		System.out.println(getMediaList());
	}

	private void playMedia()
	{
		Scanner in = new Scanner(System.in);

		System.out.print("Here is a list of the students and their corresponding numbers:\n" + getStudentList() + "\nEnter the number for the student for which you wish to play media: ");
		int studentIndex = in.nextInt();

		System.out.print("Here is a list of the available media along with their numbers:\n" + getMediaList() + "\nEnter the number for the media you wish to play");
		int mediaIndex = in.nextInt();

		System.out.println(playMedia(studentIndex, mediaIndex));
	}

	private void listAvailablePoints()
	{
		Scanner in = new Scanner(System.in);

                System.out.print("Here is a list of the students and their corresponding numbers:\n" + getStudentList() + "\nEnter the number for the student whose points balance you wish to see: ");
                int studentIndex = in.nextInt();
		getPoints(studentIndex);
	}

	private void buyPoints()
	{
		Scanner in = new Scanner(System.in);

                System.out.print("Here is a list of the students and their corresponding numbers:\n" + getStudentList() + "\nEnter the number for the student that is buying points: ");
                int studentIndex = in.nextInt();
		int currentPoints = getPoints(studentIndex);

		System.out.print("How many points do you want to buy? ");
		int newPoints = in.nextInt();

		if (newPoints <= 0)
		{
			throw new IllegalArgumentException("Cannot buy a non-positive number of points");
		}
		else
		{
			System.out.println(buyPoints(studentIndex, newPoints);
		}
	}




}
