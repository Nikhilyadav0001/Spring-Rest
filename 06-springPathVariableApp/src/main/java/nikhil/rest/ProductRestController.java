package nikhil.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/api/product")
public class ProductRestController {

	
	@GetMapping("/get/{pid}/{pname}")
	public ResponseEntity<String> getProductDetails(
					@PathVariable	Integer pid,
					@PathVariable   String pname
			) {
	//	new ResponseEntity<String>("PID="+pid+"Pname="+pname,HttpStatus.OK)
		String str = "PID="+pid+"Pname="+pname;
		return ResponseEntity.ok(str);
	}
	@GetMapping("/find")
	public ResponseEntity<String> getProductInfo(
			@RequestParam	Integer pid,
			@RequestParam 	String pname
			) {
		//	new ResponseEntity<String>("PID="+pid+"Pname="+pname,HttpStatus.OK)
		String str = "PID="+pid+"Pname="+pname;
		return ResponseEntity.ok(str);
	}
	
}
