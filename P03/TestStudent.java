public class TestStudent
{
	public static void main(String[] args)
	{
		Student student = new Student("Juan Guajardo Gutierrez", 1002128662, "jgg8662@mavs.uta.edu");
		int errors = 0;

		//TEST VECTOR #1: Student.toString()
		if (!(student.toString().equals("Juan Guajardo Gutierrez (1002128662, jgg8662@mavs.uta.edu, Account #1)")))
		{
			System.err.println("FAIL: Expected output is Juan Guajardo Gutierrez (1002128662, jgg8662@mavs.uta.edu, Account #1) but received " + student.toString());
			errors++;
		}

		//TEST VECTOR #2: Student.requestMedia(media)
		if (!(student.requestMedia(new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0")).equals("Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)")))
		{
			System.err.println("FAIL: Expected output is Playing The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0) but returned " + student.requestMedia(new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0")));
			errors++;
		}	

		//TEST VECTOR #3: Non-UTA email address
		try
		{
			Student student2 = new Student("Invalid Email", 7777777, "bidibidibombom@utd.edu");
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

		System.exit(errors);
	}
}

