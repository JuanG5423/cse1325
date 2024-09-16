package test;
import customer.Account;
import customer.Alacarte;

public class TestAlacarte
{
	public static void main(String[] args)
	{
		Alacarte account = new Alacarte();

		//TEST VECTOR #1: Alacarte.buyPoints()
		int currentPoints = 0;
	  	account.buyPoints(20);
		if (0+20 != account.getPointsRemaining())
		{
			System.err.println("FAIL: 0+20=20 but points remaining after buying 20 points for an account with 0 points is " + account.getPointsRemaining());
		}	
	}
}

