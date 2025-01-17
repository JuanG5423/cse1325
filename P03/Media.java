import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;

public class Media
{
	private String title;
	private String url;

	public Media(String title, String url)
	{
		
		try 
		{
		    HttpClient client = HttpClient.newHttpClient();
		    HttpRequest request = HttpRequest.newBuilder().uri(new URI(url)).timeout(Duration.ofSeconds(15)).build();
		    HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		    this.title = title;
		    this.url = url;
		}
	       	catch (Exception e) 
		{
		    throw new IllegalArgumentException("Invalid URL : " + url);
		}
	}

	@Override
	public String toString()
	{
		return title + " (" + url + ")";
	}
}
