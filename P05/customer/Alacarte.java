package customer;
import product.Media;

/**
 *
 * A subclass of Account that requires points to play media
 * @author Juan Guajardo Gutierrez
 * @version 0.1
 * @since 0.1
 */ 

public class Alacarte extends Account
{
	private int pointsRemaining;

	/**
	 * 
	 * Adds points to the account
	 * @param points An int with the number of points to be bought
	 * @since 0.1
	 */

	public void buyPoints(int points)
	{
		pointsRemaining += points;
	}

	/**
	 *
	 * Retrieves the number of points remaining in the account
	 * @return An int with the number of points remaining in the account
	 * @since 0.1
	 */

	public int getPointsRemaining()
	{
		return pointsRemaining;
	}

	/**
	 *
	 * Plays the specified Media instance and subtracts the points necessary to play the media from the account
	 * @param media A Media instance
	 * @return A String message indicating that the media is being played if the account has enough points. If there aren't sufficient points in the account, returns a String detailing how many points the media costs and how many points the account has.
	 * @since 0.1
	 */ 

	@Override
	public String play(Media media)
	{
		if (pointsRemaining >= media.getPoints())
		{
			pointsRemaining -= media.getPoints();
			return "Playing " + media.toString();
		}
		else
		{
			return "Buy more points: Requires " + media.getPoints() + " points, you have " + pointsRemaining;
		}
	}
}

