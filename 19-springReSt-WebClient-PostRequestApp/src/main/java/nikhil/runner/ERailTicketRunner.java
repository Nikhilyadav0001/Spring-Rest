package nikhil.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import nikhil.request.PassengerInfo;
import nikhil.response.Ticket;

@Component
public class ERailTicketRunner implements CommandLineRunner {

private String url = "http://localhost:9999/v1/api/railway/createTicket";
	
	@Override
	public void run(String... args) throws Exception {

		PassengerInfo body = new PassengerInfo();
		body.setFirstName("Sachin");
		body.setLastName("Yaduvanshi");
		body.setJourneyDate("16/04/2026");
		body.setFrom("Noida");
		body.setTo("Gurugam");
		body.setTrainNumber("Shatabdi");
		
		invokeSynchRestApi(body);
		
	}

	private void invokeSynchRestApi(PassengerInfo body) {
		//Creating a WebClient
		WebClient webClient = WebClient.create();
		
		System.out.println("***SynchRequest : WEBCLIENT Started ****");
		
		//Sending post request
		Ticket ticket = webClient
			.post()
			.uri(url)
			.body(BodyInserters.fromValue(body))
			.retrieve()
			.bodyToMono(Ticket.class)
			.block();
		
		System.out.println(ticket);
		System.out.println("***SynchRequest : WEBCLIENT Ended ****");
		
	}

}
