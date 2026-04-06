package nikhil.bean;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
	
	//has a
	private Address address;
	
	private Integer id;
	private String firstName;
	private String lastName;
	private boolean active;
	
	//@JsonIgnore
	private List<String> friendsName;

	//@Override
	public String toString() {
		return "Customer [address=" + address +"\n"+ ", id=" + id + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", active=" + active +"\n"+ ", friendsName=" + friendsName + "]";
	}
	
	
}
