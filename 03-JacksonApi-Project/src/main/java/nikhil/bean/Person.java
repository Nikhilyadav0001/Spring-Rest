package nikhil.bean;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

	private String firstName;
	private String lastName;
	private String emailId;
	
	private Date dob;
	
	//has a order :: multiple order
	private List<Order> orders;
	
	private Account account;
}
