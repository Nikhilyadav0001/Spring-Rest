package nikhil;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
    	Order ord2 = new Order(456,"phone",true,"best");
    	Order ord3 = new Order(789,"ram",false,"okk");
    	
    	Account account = new Account("14568","AXIS",new BigDecimal(123664.55));
    	
    	Person person = new Person("Sachin","ysdav","sachin@123",
    						new Date(),
    						List.of(ord1,ord2,ord3),account);
    	
    	//use jackson api and convert java object to json
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.enable(SerializationFeature.INDENT_OUTPUT);
    	
    	mapper.writeValue(new File("src/main/resources/person.json"), person);
    	System.out.println("serialization is complete.......");
    	
    }
}
