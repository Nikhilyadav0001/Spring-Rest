package nikhil;

import java.io.File;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Unmarshaller;
import nikhil.bean.Person;

public class UnMarshallingApp {
    public static void main(String[] args) throws Exception {

    	//deserialize the object xml to java
    	JAXBContext context = JAXBContext.newInstance(Person.class);
    	Unmarshaller unmarshaller = context.createUnmarshaller();
    	Person pr =(Person)unmarshaller.unmarshal(new File("src/main/resources/person.xml"));
    	System.out.println(pr);
    	
    }
}
