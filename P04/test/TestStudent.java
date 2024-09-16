package test;
import customer.Student;
import product.Media;
import customer.Account;
import customer.Unlimited;
import customer.Alacarte;

public class TestStudent
{
	public static void main(String[] args)
	{
		Student student = new Student("Juan Guajardo Gutierrez", 1002128662, "jgg8662@mavs.uta.edu", true);
		int errors = 0;

		//TEST VECTOR #1: Student.toString()
		if (!(student.toString().equals("Juan Guajardo Gutierrez (1002128662, jgg8662@mavs.uta.edu, Account #1)")))
		{
			System.err.println("FAIL: Expected output is Juan Guajardo Gutierrez (1002128662, jgg8662@mavs.uta.edu, Account #1) but received " + student.toString());
			errors++;
		}

		//TEST VECTOR #2: Student.requestMedia(media)
		if (!(student.requestMedia(new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", 4)).equals("Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0, 4 points)")))
		{
			System.err.println("FAIL: Expected output is Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0, 4 points)but returned " + student.requestMedia(new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", 4)));
			errors++;
		}	

		//TEST VECTOR #3: Non-UTA email address
		try
		{
			Student student2 = new Student("Invalid Email", 7777777, "bidibidibombom@utd.edu", false);
			System.err.println("FAIL: Non-UTA email address (bidibidibombom@utd.edu) but no exception thrown");
			errors++;
		}
		catch (IllegalArgumentException e)
		{
		}
		catch (Exception e)
		{
			System.err.println("FAIL: Student threw wrong exception on Non-UTA email address");
			errors++;
		}

		//TEST VECTOR #4: Student.requestMedia(media) with Unlimited account
		Student unlimitedStudent = new Student("Unlimited Limited", 7777, "unlimited@uta.edu", true);
		Media testMedia = new Media("Out of Ideas", "https://www.last.fm/music/Kali+Uchis/_/Tirano+(feat.+Fuego)", 999);
		Unlimited unlimitedAccount = new Unlimited();
		if (!(unlimitedStudent.requestMedia(testMedia).equals("Playing Out of Ideas (https://www.last.fm/music/Kali+Uchis/_/Tirano+(feat.+Fuego), 999 points)") && unlimitedAccount.play(testMedia).equals("Playing Out of Ideas (https://www.last.fm/music/Kali+Uchis/_/Tirano+(feat.+Fuego), 999 points)")))
		{
			System.err.println("FAIL: Student.requestMedia() and Account.play() should both	return Playing Out of Ideas (https://www.last.fm/music/Kali+Uchis/_/Tirano+(feat.+Fuego), 999 points) but Student.requestMedia() returned " + unlimitedStudent.requestMedia(testMedia) + " and Account.play() returned " + unlimitedAccount.play(testMedia));
			errors++;
		}

		//TEST VECTOR #5: Student.requestMedia(media) with Alacarte account with sufficient points
		Student alacarteStudent = new Student("Alacarte Student", 1234, "alacarte@mavs.uta.edu", false);
		Alacarte alacarteAccount = new Alacarte();
		Alacarte alacarteStudentAccount = (Alacarte) alacarteStudent.getAccount();
		alacarteStudentAccount.buyPoints(998);
		alacarteAccount.buyPoints(998);
		if (!(alacarteStudent.requestMedia(testMedia).equals("Buy more points: Requires 999 points, you have 998") && alacarteAccount.play(testMedia).equals("Buy more points: Requires 999 points, you have 998")))
		{
			System.err.println("FAIL: Student.requestMedia() and Account.play() should both return Buy more points: Requires 999 points, you have 998 but Student.requestMedia() returned " + alacarteStudent.requestMedia(testMedia) + " and Account.play() returned " + alacarteAccount.play(testMedia));
			errors++;
		}

		System.exit(errors);
	}
}

