package nikhil.bean;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value = {"firstName","lastName","dob"})
@JsonRootName("person")
public class Person {

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;
	
	@JsonIgnoreProperties
	private String emailId;
	
	private Date dob;
	
	//has a order :: multiple order
	private List<Order> orders;
	
	@JsonIgnoreProperties
	private Account account;
}
