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
		return denomination.getValue();
	}

	public int getYear()
	{
		return year;
	}

	public double getWeight()
	{
		if (denomination.toString().equals("penny"))
		{
			if (year <= 1983)
			{
				return 3.11;
			}
			else
			{
				return 2.5;
			}
		}
		else if (denomination.toString().equals("nickel"))
		{
			return 5.0;
		}
		else if (denomination.toString().equals("dime"))
		{
			if (year <= 1965)
			{
				return 2.5;
			}
			else
			{
				return 2.268;
			}
		}
		else
		{
			if (year <= 1965)
			{
				return 6.25;
			}
			else
			{
				return 5.67;
			}
		}
	}

	@Override
	public String toString()
	{
		return year + " " + denomination;
	}
}
