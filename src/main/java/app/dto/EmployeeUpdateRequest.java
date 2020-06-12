package app.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotBlank;

public class EmployeeUpdateRequest implements Serializable {

	private static final long serialVersionUID = 5303646281771996452L;

	@NotBlank
	private int id;
	
	@NotBlank
	private String lastName;
	
	@NotBlank
	private String firstName;
	
	@NotBlank
	private String kanaLastName;
	
	@NotBlank
	private String kanaFirstName;
	
	@NotBlank
	private String age;
	
	@NotBlank
	private String phone;
	
	@NotBlank
	private String email;

	@NotBlank
	private Date createDate;
	
	@NotBlank
	private Date updateDate;
	
	@NotBlank
	private Date deleteDate;
}
