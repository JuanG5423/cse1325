public class Purse
{
	public static void main(String[] args)
	{
		Coin[] purse = {new Coin(Denomination.PENNY, 1738), new Coin(Denomination.NICKEL, 1800), new Coin(Denomination.DIME, 1969), new Coin(Denomination.QUARTER, 1982), new Coin(Denomination.PENNY, 2024)};

		double total = 0;
		int earliest = purse[0].getYear();
		int latest = purse[0].getYear();
		
		for (Coin coin : purse)
		{
			total += coin.getValue();
			System.out.println(coin.toString());
			
			if (coin.getYear() < earliest)
			{
				earliest = coin.getYear();
			}
			
			else if (coin.getYear() > latest)
			{
				latest = coin.getYear();
			}
		}	

		System.out.printf("You have $%.2f in coins between %d and %d\n", total, earliest, latest); 
	}
}
