package test;
import customer.Account;
import customer.Alacarte;
import product.Media;

public class TestAlacarte
{
	public static void main(String[] args)
	{
		Alacarte account = new Alacarte();
		int errors = 0;

		//TEST VECTOR #1: Alacarte.buyPoints()
		int currentPoints = 0;
	  	account.buyPoints(20);
		if (0+20 != account.getPointsRemaining())
		{
			System.err.println("FAIL: 0+20=20 but points remaining after buying 20 points for an account with 0 points is " + account.getPointsRemaining());
		}	errors++;

		//TEST VECTOR #2: Alacarte.play() when media can be afforded
		Media media = new Media("Short title", "https://en.wikipedia.org/wiki/Bidi_Bidi_Bom_Bom", 20);
		String playMedia = account.play(media);
		if (!(playMedia.equals("Playing Short title (https://en.wikipedia.org/wiki/Bidi_Bidi_Bom_Bom, 20 points)")))
		{
			System.err.println("FAIL: Expected output of Playing Short title (https://en.wikipedia.org/wiki/Bidi_Bidi_Bom_Bom, 20 points) but received " + playMedia);
		       errors++;	
		}

	}
}

