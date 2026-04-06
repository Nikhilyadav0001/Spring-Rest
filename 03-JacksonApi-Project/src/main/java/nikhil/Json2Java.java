package nikhil;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import nikhil.bean.Person;

public class Json2Java {
    public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
    	
    	//use jackson api and convert json to java
    	ObjectMapper mapper = new ObjectMapper();
    	mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);
    	
    	Person person = mapper.readValue(new File("src/main/resources/person.json"), Person.class);

    	System.out.println(person);
    	
    }

}
