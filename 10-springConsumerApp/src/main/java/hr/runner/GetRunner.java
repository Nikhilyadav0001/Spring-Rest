package hr.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import hr.entity.Book;

@Component
public class GetRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
	
		final String URL1 = "http://localhost:9999/v1/api/book/showA";
		final String URL2 = "http://localhost:9999/v1/api/book/showB/10/nikhil";
		final String URL3 = "http://localhost:9999/v1/api/book/showC/{id}";

		//creation of rest template object
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> response1 = template.getForEntity(URL1, String.class);
		ResponseEntity<String> response2 = template.getForEntity(URL2, String.class);
	
		// Reading the response details from the object
		System.out.println(response1.getBody());
		System.out.println(response1.getHeaders());
		System.out.println(response1.getStatusCode().value());

		System.out.println("**********************************************");

		// Reading the response details from the object
		System.out.println(response2.getBody());
		System.out.println(response2.getHeaders());
		System.out.println(response2.getStatusCode().value());
		
		System.out.println("**********************************************");
	
		ResponseEntity<Book> response3 = template.getForEntity(
				URL3,//url details
				Book.class,//ResponseEntity
				1//pathVariable
				);
		
		// Reading the response details from the object
		System.out.println(response3.getBody());
		System.out.println(response3.getHeaders());
		System.out.println(response3.getStatusCode().value());

	
	
	}

}
