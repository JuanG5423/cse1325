public class TestMedia
{
	public static void main(String[] args)
	{
		//TEST VECTOR: Verify that the toString() returns the title followed by the URL in parentheses
		media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0");
		if (!(media.toString().equals("The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)")));
		{
			System.err.println("FAIL: expected output is \"The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)\" but returned " + media.toString());
			System.exit(69);
		}
	}
}
