public enum Denomination
{
	PENNY, NICKEL, DIME, QUARTER
}

public class Coin
{
	private Denomination denomination;
	private int year;

	public Coin(Denomination denomination, int year)
	{
		this.denomination = denomination;
		this.year = year;
	}

	public double getValue()
	{
		switch(denomination)
		{
			case PENNY:
				return 0.01;
			case NICKEL:
				return 0.05;
			case DIME:
				return 0.1;
			case QUARTER:
				return 0.25;
			default:
				System.err.println("Something ain't right here");
		}
	}

	public int getYear()
	{
		return year;
	}
}
