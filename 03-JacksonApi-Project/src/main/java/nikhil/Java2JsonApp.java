package nikhil;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import nikhil.bean.Account;
import nikhil.bean.Order;
import nikhil.bean.Person;

public class Java2JsonApp {
    public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
    	
    	Order ord1 = new Order(123,"laptop",true,"good");
    	Order ord2 = new Order(null,"phone",true,"best");
    	Order ord3 = new Order(789,"",false,"okk");
    	
    	Account account = new Account("14568","AXIS",new BigDecimal(123664.55));
    	
    	Person person = new Person("Sachin","yadav","sachin@123",
    						new Date(),
    						List.of(ord1,ord2,ord3),account);
    	
    	//use jackson api and convert java object to json
    	ObjectMapper mapper = new ObjectMapper();
    	//good output not in single line
    	mapper.enable(SerializationFeature.INDENT_OUTPUT);
    	//enable root elemet
    	mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
    	
    	//you can also do it in this way or use include 
    	mapper.setSerializationInclusion(Include.NON_NULL);
    	
    	
    	String valueAsString = mapper.writeValueAsString(person);
    	System.out.println(valueAsString);
    	
    	mapper.writeValue(new File("src/main/resources/person.json"), person);
    	System.out.println("serialization is complete.......");
    	
    }
}
