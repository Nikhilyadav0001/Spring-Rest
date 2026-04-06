package nikhil;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import nikhil.bean.Customer;

public class JsonToJava {
    public static void main(String[] args) {

    	//use object mapper calss
    	ObjectMapper mapper = new ObjectMapper();
    	Customer customer;
    	
    	//read json file and put into java object
    	File file = new File("data/sample.json");
    	
		try {
			//converting json to java object
			customer = mapper.readValue(file,Customer.class);
			
			//using the java object
			System.out.println(customer);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
