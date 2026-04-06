package nikhil;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

import nikhil.bean.Student;

public class SendingJavaToJsonApp {
    public static void main(String[] args) {
    	
    	try {
			// use ObjectMapper class
			ObjectMapper mapper = new ObjectMapper();

			// Created a Student object
			Student student = new Student(1, "Nikhil", 19);

			String jsonStudent = mapper.writeValueAsString(student);
			System.out.println(jsonStudent);
			
			mapper.writeValue(new File("student.json"), student);
			System.out.println("Json data created...");

		} catch (IOException e) {
			e.printStackTrace();
		}

    }
}
