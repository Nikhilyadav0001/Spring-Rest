package nikhil;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.webmvc.test.autoconfigure.AutoConfigureMockMvc;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

//Creating the server and container environment
@SpringBootTest(webEnvironment = WebEnvironment.MOCK)

//mocking the annotations(@RequestBody,@ResponseBody) needed  during Testing
@AutoConfigureMockMvc

//Loading the data from properties file(src/main/resources)
@TestPropertySource("classpath:application.properties")

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StudentRestControllerTest {

	@Autowired
	public MockMvc mockMvc;
	
	@Test
	@DisplayName("SAVING STUDENT OBJECT")
	@Order(1)
	public void createStudentTest() throws Exception {
		String body="{\n"
				+ "    \"stdName\": \"XYZ\",\n"
				+ "    \"stdGen\": \"Femail\",\n"
				+ "    \"stdCourse\": \"ABC\",\n"
				+ "    \"stdAddr\": \"HR\"\n"
				+ "}";
		
		// 1. Create a dummy request object[M.T,URL,C.T,C.B]
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.post("http://localhost:9999/v1/api/student/create").contentType(MediaType.APPLICATION_JSON)
				.content(body);

		// 2. Send the request and get the response
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. Retrieve the data from request object to peform testing
		MockHttpServletResponse response = result.getResponse();

		// 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.CREATED.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		boolean isTrue = response.getContentAsString().contains("CREATED");
		if (!isTrue) {
			fail("STUDENT NOT CREATED!!!");
		}
	}
		
		
	@Test
	@DisplayName("GETTING STUDENT OBJECT")
	@Order(2)
	public void testGetStudent() throws Exception {
		
		// 1. Create a dummy request object[M.T,URL,C.T,C.B]
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
				.get("http://localhost:9999/v1/api/student/find/{id}",1);
		
		
		// 2. Send the request and get the response
		MvcResult result = mockMvc.perform(request).andReturn();
		
		// 3. Retrieve the data from request object to peform testing
		MockHttpServletResponse response = result.getResponse();
		
		// 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		String output = response.getContentAsString();
		System.out.println(output);
		assertEquals(MediaType.APPLICATION_JSON_VALUE, response.getContentType());
	}
	
	@Test
	@DisplayName("GETTING ALL STUDENT DETAIlS")
	@Order(3)
	public void testGetAllStudent() throws Exception {
		
		// 1. Create a dummy request object[M.T,URL,C.T,C.B]
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
			.get("http://localhost:9999/v1/api/student/all");
			

		// 2. Send the request and get the response
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. Retrieve the data from request object to peform testing
		MockHttpServletResponse response = result.getResponse();

		// 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		String output = response.getContentAsString();
		System.out.println(output);
	}
	
	@Test
	@DisplayName("UPDATE STUDENT DETAIlS")
	@Order(4)
	public void testUpdateStudent() throws Exception {
		
		String body = "{\n"
				+ "    \"stdId\": 5,\n"
				+ "    \"stdName\": \"Sher\",\n"
				+ "    \"stdGen\": \"Male\",\n"
				+ "    \"stdCourse\": \"Content\",\n"
				+ "    \"stdAddr\": \"Up\"\n"
				+ "}";
		// 1. Create a dummy request object[M.T,URL,C.T,C.B]
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
			.put("http://localhost:9999/v1/api/student/modify")
			.contentType(MediaType.APPLICATION_JSON)
			.content(body);
			

		// 2. Send the request and get the response
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. Retrieve the data from request object to peform testing
		MockHttpServletResponse response = result.getResponse();

		// 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		String output = response.getContentAsString();
		System.out.println(output);
	}
	
	
	@Test
	@DisplayName("DELETING STUDENT OBJECT")
	@Order(5)
	public void testDeleteStudent() throws Exception {
		
		// 1. Create a dummy request object[M.T,URL,C.T,C.B]
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders
			.delete("http://localhost:9999/v1/api/student/remove/{id}",5);
			

		// 2. Send the request and get the response
		MvcResult result = mockMvc.perform(request).andReturn();

		// 3. Retrieve the data from request object to peform testing
		MockHttpServletResponse response = result.getResponse();

		// 4. use JUNIT to test wheter the testcase is pass|fail
		assertEquals(HttpStatus.OK.value(), response.getStatus());
		assertNotNull(response.getContentAsString());
		boolean isTrue = response.getContentAsString().contains("REMOVED");
		if (!isTrue) {
			fail("STUDENT NOT DELETED");
		}
	}
		
}
