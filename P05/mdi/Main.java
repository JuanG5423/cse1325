package mdi;
import Moes.moes
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



}