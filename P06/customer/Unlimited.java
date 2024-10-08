package customer;
import product.Media;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.BufferedWriter;

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

	public Unlimited()
	{
		super();
	}

	public Unlimited(BufferedReader br) throws IOException
	{
		super(br);
	}

	public void save(BufferedWriter bw) throws IOException
	{
		super.save(bw);
	}

	@Override
	public String play(Media media)
	{
		return "Playing " + media.toString();
	}
}
