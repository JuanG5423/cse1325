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
			System.err.println("Expected output of \n0) Bidi Bidi Bom Bom (https://www.last.fm/music/Selena/_/Bidi+Bidi+Bom+Bom, 5000 points)\n1) Telepatia (https://www.last.fm/music/Kali+Uchis/_/telepat%C3%ADa, 2147483647 points)\n but received \n" + moes.getMediaList());
			errors++;
		}

		//TEST VECTOR #2: getStudentList
		moes.addStudent(new Student("Unlimited Limited", 7777, "unlimited@mavs.uta.edu", true));
		moes.addStudent(new Student("Limited Unlimited", 9999, "notunlimited@uta.edu", false));
		if (!(moes.getStudentList().equals("0) Unlimited Limited (7777, unlimited@mavs.uta.edu, Account #1)\n1) Limited Unlimited (9999, notunlimited@uta.edu, Account #2)\n")))
		{
			System.err.println("Expected output of \n0) Unlimited Limited (7777, unlimited@mavs.uta.edu, Account #1)\n1) Limited Unlimited (9999, notunlimited@uta.edu, Account #2)\n but received \n" + moes.getStudentList());
			errors++;
		}

		System.exit(errors);
	}
}
		