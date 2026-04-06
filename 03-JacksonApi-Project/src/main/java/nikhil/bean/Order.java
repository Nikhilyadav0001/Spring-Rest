package nikhil.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class Order {

	private Integer oid;

	@JsonInclude(Include.NON_EMPTY)
	private String name;

	private Boolean delivered;
	
	private String desc;

}