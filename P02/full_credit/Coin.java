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
		double value;
		switch(denomination)
		{
			case PENNY:
				value = 0.01;
			case NICKEL:
				value = 0.05;
			case DIME:
				value = 0.1;
			case QUARTER:
				value = 0.25;
			default:
				System.err.println("Something ain't right here");
		}
		return value;
	}

	public int getYear()
	{
		return year;
	}
}
