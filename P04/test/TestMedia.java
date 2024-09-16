package test;
import product.Media;

public class TestMedia
{
	public static void main(String[] args)
	{
		//TEST VECTOR #1: Verify that the toString() returns the title followed by the URL in parentheses
		Media media = new Media("The Little Shop of Horrors", "https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0", 7);
		if (!(media.toString().equals("The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)")))
		{
			System.err.println("FAIL: expected output is \"The Little Shop of Horrors (https://publicdomainmovie.net/movie/the-little-shop-of-horrors-0)\" but returned " + media.toString());
			System.exit(69);
		}

		//TEST VECTOR #2: Verifying URLs
		String[] valid = {"https://youtube.com", "file://media/lib/garp.mp4"};
		String[] invalid = {"hello.world", "htt://badurl.com", "flub://badurl.com"};

		for (String url : valid)
		{
			Media test = new Media("Hello World", url, 8);
		}

		for (String url : invalid)
		{
			Media test = new Media("Good luck", url, 9);
		}
	}
}
