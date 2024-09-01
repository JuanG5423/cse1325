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
		double value = 0;
		switch(denomination)
		{
			case PENNY:
				value = 0.01;
				break;
			case NICKEL:
				value = 0.05;
				break;
			case DIME:
				value = 0.1;
				break;
			case QUARTER:
				value = 0.25;
				break;
		}
		return value;
	}

	public int getYear()
	{
		return year;
	}
}
