package nikhil;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import nikhil.bean.Address;
import nikhil.bean.Person;

public class MarshallingApp {
    public static void main(String[] args) throws Exception {
    	Person person = new Person();
    	person.setName("Nikhil");
    	person.setId(1);
    	person.setEmail("nikhil@123");
    	person.setGender("Male");
    	
    	Address addr = new Address("Gurugram","Haruana","India");
    	person.setAddress(addr);
    	
    	//serialize the object
    	JAXBContext context = JAXBContext.newInstance(Person.class);
    	Marshaller marshaller = context.createMarshaller();
    	
    	marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // optional
    	marshaller.marshal(person, new File("src/main/resources/person.xml"));
    	System.out.println("..........marshalling completed..........");
    }
}
