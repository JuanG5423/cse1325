package mdi;
import moes.Moes;
import product.Media;
import customer.Student;
import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;

public class Main
{
	private Moes moes;
	private String output;
	private Menu menu;
	private boolean running;
	private static final String extension = ".moes";
	private static final String magicCookie = "bababui";
	private static final String fileVersion = "0.4";
	private String filename;

	private void open() throws IOException
	{
		System.out.print("Current filename: " + filename + ".\nEnter new filename: ");
		if (filename.equals("\n"))
		{
			return;
		}
		else
		{
			if (!(filename.contains(".moes")))
                        {
                                filename += ".moes";
                        }
			try
			{
				BufferedReader br = new BufferedReader(new FileReader(filename));

				if (!(br.readLine().equals(magicCookie)))
				{
					throw new IOException("First line of file is not magicCookie " + magicCookie);
				}
				if (!(br.readLine().equals(fileVersion)))
				{
					throw new IOException("Second line of file is not fileVersion " + fileVersion);
				}
				try
				{
					moes = new Moes(br);
				}
				catch (Exception e)
				{
					System.err.println("Could not reconstruct moes");
					System.err.println(e.getMessage());
					return;
				}
			}
			catch (Exception e)
			{
				System.err.println("Could not open file " + filename);
				System.err.println(e.getMessage());
				return;
			}
		}
	}



	private void saveAs() throws IOException
	{
		System.out.print("Current filename: " + filename + ".\nEnter new filename: ");
		Scanner in = new Scanner(System.in);
		filename  = in.nextLine();
		if (filename.equals("\n"))
		{
			return;
		}
		else
		{
			if (!(filename.contains(".moes")))
			{
				filename += ".moes";
			}
			this.save();
		}
	}

	private void newMoes()
	{
		moes = new Moes();
	}

	private void save() throws IOException
	{
		try
		{
			BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
			bw.write(magicCookie + "\n" + fileVersion);
			moes.save(bw);
			return;
		}
		catch (Exception e)
		{
			System.err.println("File " + filename + " could not be opened");
			System.err.println(e.getMessage());
			return;
		}
	}

	public Main()
	{
		this.moes = new Moes();
		this.output = output;
		this.menu = new Menu();
		this.running = true;

		menu.addMenuItem(new MenuItem("Exit", () -> endApp()));
		menu.addMenuItem(new MenuItem("Play media", () -> playMedia()));
	       	menu.addMenuItem(new MenuItem("List media", () -> listMedia()));
		menu.addMenuItem(new MenuItem("List available points", () -> listAvailablePoints()));
		menu.addMenuItem(new MenuItem("Buy points", () -> buyPoints()));
		menu.addMenuItem(new MenuItem("Add media", () -> addMedia()));
		menu.addMenuItem(new MenuItem("List all students", () -> listStudents()));
		menu.addMenuItem(new MenuItem("Add a student", () -> addStudent()));
	}


	private void addStudent()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("\nEnter the student's name: ");
		String name = in.nextLine();
		
		System.out.print("\nEnter the student's ID number: ");
		int id = in.nextInt();
		in.nextLine();
		
		System.out.print("\nEnter the student's @mavs.uta.edu or @uta.edu email address: ");
		String email = in.nextLine();
		
		System.out.print("\nEnter a for an Alacarte account or u for an Unlimited account: ");
		boolean isUnlimited = in.nextLine().equals("u");
		moes.addStudent(new Student(name, id, email, isUnlimited));
	}

	private void listStudents()
	{
		System.out.println(moes.getStudentList());
	}

	private void addMedia()
	{
		Scanner in = new Scanner(System.in);
		
		System.out.print("\nEnter the title of the media: ");
		String title = in.nextLine();

		System.out.print("\nEnter its URL: ");
		String url = in.nextLine();

		System.out.print("\nHow many points will this media cost? ");
		int points = in.nextInt();

		moes.addMedia(new Media(title, url, points));
	}

	private void listMedia()
	{
		System.out.println(moes.getMediaList());
	}

	private void playMedia()
	{
		Scanner in = new Scanner(System.in);

		System.out.print("\nHere is a list of the students and their corresponding numbers:\n" + moes.getStudentList() + "\nEnter the number for the student for which you wish to play media: ");
		int studentIndex = in.nextInt();

		System.out.print("\nHere is a list of the available media along with their numbers:\n" + moes.getMediaList() + "\nEnter the number for the media you wish to play");
		int mediaIndex = in.nextInt();

		System.out.println(moes.playMedia(studentIndex, mediaIndex));
	}

	private void listAvailablePoints()
	{
		Scanner in = new Scanner(System.in);

                System.out.print("\nHere is a list of the students and their corresponding numbers:\n" + moes.getStudentList() + "\nEnter the number for the student whose points balance you wish to see: ");
                int studentIndex = in.nextInt();
		System.out.println(moes.getPoints(studentIndex));
	}

	private void buyPoints()
	{
		Scanner in = new Scanner(System.in);

                System.out.print("\nHere is a list of the students and their corresponding numbers:\n" + moes.getStudentList() + "\nEnter the number for the student that is buying points: ");
                int studentIndex = in.nextInt();
		int currentPoints = moes.getPoints(studentIndex);

		System.out.print("\nHow many points do you want to buy? ");
		int newPoints = in.nextInt();

		if (newPoints <= 0)
		{
			throw new IllegalArgumentException("Cannot buy a non-positive number of points");
		}
		else
		{
			System.out.println(moes.buyPoints(studentIndex, newPoints));
		}
	}

	private void mdi()
	{
		while (running)
		{
			Scanner in = new Scanner(System.in);
			System.out.println("\n" + menu.toString());
			System.out.print("Enter the number corresponding to the desired command: ");
			int command = in.nextInt();
			menu.run(command);
		}
	}

	private void endApp()
	{
		running = false;
	}

	public static void main(String args[])
	{
		Main main = new Main();
		main.mdi();
	}




}
