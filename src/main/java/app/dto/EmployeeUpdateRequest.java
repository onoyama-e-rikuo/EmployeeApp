package app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import lombok.Data;

@Data
public class EmployeeUpdateRequest implements Serializable {

	private static final long serialVersionUID = 5303646281771996452L;

	@NotEmpty
	private int id;
	
	@NotEmpty
	private String lastName;
	
	@NotEmpty
	private String firstName;
	
	@NotEmpty
	private String kanaLastName;
	
	@NotEmpty
	private String kanaFirstName;
	
	@NotEmpty
	private String age;
	
	@NotEmpty
	private String phone;
	
	@NotEmpty
	private String email;

	@NotEmpty
	private Date createDate;
	
	@NotEmpty
	private Date updateDate;
	
	@NotEmpty
	private Date deleteDate;
}
