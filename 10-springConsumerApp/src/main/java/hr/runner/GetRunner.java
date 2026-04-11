package hr.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import hr.Application;
import hr.entity.Book;

@Component
public class GetRunner implements CommandLineRunner {

	private final Application application;

	GetRunner(Application application) {
		this.application = application;
	}

	@Override
	public void run(String... args) throws Exception {
	
		final String URL1 = "http://localhost:9999/v1/api/book/showA";

		//creation of rest template object
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<String> response1 = template.getForEntity(URL1, String.class);
	
		// Reading the response details from the object
		System.out.println(response1.getBody());
		System.out.println(response1.getHeaders());
		System.out.println(response1.getStatusCode().value());

		System.out.println("**********************************************");

		final String URL2 = "http://localhost:9999/v1/api/book/showB/10/nikhil";
		ResponseEntity<String> response2 = template.getForEntity(URL2, String.class);
		
		// Reading the response details from the object
		System.out.println(response2.getBody());
		System.out.println(response2.getHeaders());
		System.out.println(response2.getStatusCode().value());
		
		System.out.println("**********************************************");
	
		final String URL3 = "http://localhost:9999/v1/api/book/showC/{id}";
		ResponseEntity<Book> response3 = template.getForEntity(
				URL3,        //url details
				Book.class,  //ResponseEntity
				1            //pathVariable
				);
		
		// Reading the response details from the object
		System.out.println(response3.getBody());
		System.out.println(response3.getHeaders());
		System.out.println(response3.getStatusCode().value());

		System.out.println("**********************************************");
		
		//sending request for post mapping
		// 1. Creating a header section
		final String URL4 = "http://localhost:9999/v1/api/book/showD";
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		// 2. Creating a entity object (body + headers)
		String body = "{\r\n"
				+ "    \"bid\": 25,\r\n"
				+ "    \"bname\": \"Microservices\",\r\n"
				+ "    \"bauth\": \"Nikhil\",\r\n"
				+ "    \"bcost\": 5000.0\r\n"
				+ "}";
		HttpEntity<String> entity = new HttpEntity<>(body, headers);
		
		ResponseEntity<String> response4 = template.postForEntity(URL4, entity, String.class);
		// Reading the response details from the object
		System.out.println(response4.getBody());
		System.out.println(response4.getHeaders());
		System.out.println(response4.getStatusCode().value());
		
		
	
	
	}

}
