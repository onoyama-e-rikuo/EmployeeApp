package app.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
@Table(name="employees")
public class Employee implements Serializable {

	private static final long serialVersionUID = -7692500108872903642L;

	@Id
	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="kana_last_name")
	private String kanaLastName;
	
	@Column(name="kana_first_name")
	private String kanaFirstName;
	
	@Column(name="age")
	private String age;
	
	@Column(name="phone")
	private String phone;
	
	@Column(name="email")
	private String email;

	@Column(name="created_at")
	private Date createDate;
	
	@Column(name="updated_at")
	private Date updateDate;
	
	@Column(name="deleted_at")
	private Date deleteDate;
}
