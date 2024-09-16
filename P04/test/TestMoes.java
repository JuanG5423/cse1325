package test;
import moes.Moes;
import product.Media;
import customer.Student;
import customer.Account;
import customer.Unlimited;
import customer.Alacarte;

public class TestMoes
{
	public static void main(String[] args)
	{
		Moes moes = new Moes();
		int errors = 0;
		//TEST VECTOR #1: getMediaList
		moes.addMedia(new Media("Bidi Bidi Bom Bom", "https://www.last.fm/music/Selena/_/Bidi+Bidi+Bom+Bom", 5000));
		moes.addMedia(new Media("Telepatia", "https://www.last.fm/music/Kali+Uchis/_/telepat%C3%ADa", 2147483647));
		if (!(moes.getMediaList().equals("0) Bidi Bidi Bom Bom (https://www.last.fm/music/Selena/_/Bidi+Bidi+Bom+Bom, 5000 points)\n1) Telepatia (https://www.last.fm/music/Kali+Uchis/_/telepat%C3%ADa, 2147483647 points)\n")))
		{
			System.err.println("FAIL: Expected output of \n0) Bidi Bidi Bom Bom (https://www.last.fm/music/Selena/_/Bidi+Bidi+Bom+Bom, 5000 points)\n1) Telepatia (https://www.last.fm/music/Kali+Uchis/_/telepat%C3%ADa, 2147483647 points)\nbut received \n" + moes.getMediaList());
			errors++;
		}

		//TEST VECTOR #2: getStudentList
		moes.addStudent(new Student("Unlimited Limited", 7777, "unlimited@mavs.uta.edu", true));
		moes.addStudent(new Student("Limited Unlimited", 9999, "notunlimited@uta.edu", false));
		if (!(moes.getStudentList().equals("0) Unlimited Limited (7777, unlimited@mavs.uta.edu, Account #1)\n1) Limited Unlimited (9999, notunlimited@uta.edu, Account #2)\n")))
		{
			System.err.println("FAIL: Expected output of \n0) Unlimited Limited (7777, unlimited@mavs.uta.edu, Account #1)\n1) Limited Unlimited (9999, notunlimited@uta.edu, Account #2)\nbut received \n" + moes.getStudentList());
			errors++;
		}

		//TEST VECTOR #3: Buying points for Alacarte account
		String result = moes.buyPoints(1, 50);
		if (!(result.equals("Limited Unlimited (9999, notunlimited@uta.edu, Account #2) now has 50 points")))
		{
			System.err.println("FAIL: Buying 50 points for an Alacarte account with 0 points should output the message Limited Unlimited (9999, notunlimited@uta.edu, Account #2) now has 50 points but received " + result);
			errors++;
		}	

		//TEST VECTOR #4: Buying points for Unlimited account
		result = moes.buyPoints(0, 2147483647);
		if (!(result.equals("Unlimited Limited (7777, unlimited@mavs.uta.edu, Account #1) has unlimited account and needs no points!")))
		{
			System.err.println("FAIL: Buying points for an Unlimited account should output Unlimited Limited (7777, unlimited@mavs.uta.edu, Account #1) has unlimited account and needs no points! but received " + result);
			errors++;
		}

		//TEST VECTOR #5: getPoints for Alacarte account
		if (0+50 != moes.getPoints(1))
		{
			System.err.println("FAIL: Alacarte account that had 0 points and bought 50 points should have 50 points but has " + moes.getPoints(1) + " points");
			errors++;
		}


		System.exit(errors);
	}
}
		
