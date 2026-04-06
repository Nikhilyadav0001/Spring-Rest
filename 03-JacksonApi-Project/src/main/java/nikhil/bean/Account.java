package nikhil.bean;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import nikhil.serialize.CustomeBalanceSerializer;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
	
	private String accounNumber;
	private String bankName;
	
	@JsonSerialize(using = CustomeBalanceSerializer.class)
	private BigDecimal balance;
}
