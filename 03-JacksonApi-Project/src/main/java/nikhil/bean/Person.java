package nikhil.bean;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nikhil.CustomeDateDeserializer;
import nikhil.serialize.CustomeDateSerializer;


@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonPropertyOrder(value = {"firstName","lastName","dob"})
@JsonRootName("person")
@JsonIgnoreProperties(value = {"emailId"})
public class Person {

	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;
	
	private String emailId;
	
	@JsonSerialize(using = CustomeDateSerializer.class)
	@JsonDeserialize(using = CustomeDateDeserializer.class)
	private Date dob;
	
	//has a order :: multiple order
	private List<Order> orders;
	
	@JsonIgnore
	private Account account;
}
