package customer;
import product.Media;

/**
 *
 * A subclass of Account that does not require any points to play media.
 * @author Juan Guajardo Gutierrez
 * @version 0.1
 * @since 0.1
 */

public class Unlimited extends Account
{
	/**
	 * 
	 * Overrides Account's abstract play method and plays the specified Media instance
	 * @param media A Media instance
	 * @return A String containing a message indicating that the media is being played
	 * @since 0.1
	 */

	@Override
	public String play(Media media)
	{
		return "Playing " + media.toString();
	}
}
