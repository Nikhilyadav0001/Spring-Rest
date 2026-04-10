package nikhil.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nikhil.bean.Book;


@RestController
@RequestMapping("/v1/api/book")
public class BookRestController {
	/*
	 * RT =ResponseEntity
	 * Method =get
	 * path =/find/{id}
	 * input = id (@Pathvariable)
	 */
	@GetMapping("/find/{id}")
	public ResponseEntity<?> getBookDetails(
			@PathVariable
			Integer id) {
		
		if (id==5) {
			HttpHeaders headers = new HttpHeaders();
			headers.add("found", "yes");
			return new ResponseEntity<Book>(new Book(5,"Microservices",5000.00),headers,HttpStatus.OK);
		} else {

			HttpHeaders headers = new HttpHeaders();
			headers.add("found", "no");
			return new ResponseEntity<String>("sorry book not found",headers,HttpStatus.BAD_REQUEST);
			
		}
	}
	/*
	 * R.T    : Book
	 * Method : GET
	 * PATH   : /info
	 * Input  : no input
	 */
	@GetMapping("/info")
	public Book getBookInfo() {
		// return new ResponseEntity(Book,HttpStatus.OK);
		return new Book(10,"HIBERNATE",6000.0); 
	}
}
