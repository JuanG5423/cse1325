package product;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

/**
 * Represents a piece of media with its title and URL.
 *
 * @author	Juan Guajardo Gutierrez
 * @version	0.2
 * @since	0.1
 */

public class Media
{
	private String title;
	private String url;
	private int points;
	
	/**
	 * Creates a Media instance.
	 *
	 * @param title		String containing the title of the Media instance.
	 * @param url		String containing the URL of the Media instance.
	 * @param points	int representing the points needed to play the Media instance.
	 * @since 0.1
	 */

	public Media(String title, String url, int points)
	{
		
		try 
		{
		    HttpClient client = HttpClient.newHttpClient();
		    HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).timeout(Duration.ofSeconds(15)).build();
		    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		    this.title = title;
		    this.url = url;
		    this.points = points;
		}
	       	catch (Exception e) 
		{
		    throw new IllegalArgumentException("Invalid URL : " + url);
		}
	}

	/**
	 *
	 * Gets the number of points needed to play a Media instance.
	 *
	 * @return points - int representing the points needed to play the Media instance	
	 * @since 0.2
	 */

	public int getPoints()
	{
		return points;
	}

	/**
	 *
	 * Returns a String representation of the Media instance.
	 *
	 * @return title + " (" + url + ", " + points + " points)" - String representing the Media instance in the format [title] ("[url]", [points])
	 * @since 0.1
	 */

	@Override
	public String toString()
	{
		return title + " (" + url + ", " + points + " points)";
	}
}
