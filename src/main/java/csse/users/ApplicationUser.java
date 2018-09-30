package csse.users;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.Id;

public class ApplicationUser {
	
	@Id
	private String _id;
	
	@NotNull
	@Size(min=5, max=5)
	private String emp_ID;
	
	@NotNull
	private String emp_type;
	
	@NotNull
	private String firstname;
	
	@NotNull
	private String lastname;
	
	@NotNull
	private String address;
	
	@NotNull
	@Email
	private String email;
	
	@NotNull
	@Size(min=10, max=10)
	private String phone;
	
	
	@NotNull
	private String username;
	
	@NotNull
	private String password;
	
	@NotNull
	private String roles;
	
	private String createdDate;
	private String lastLogin;
	private String modifiedDate;
	
	public ApplicationUser(String emp_ID, String emp_type, String firstname, String lastname, String address, String email,
			String phone, String username, String password, String roles, String createdDate, String lastLogin,
			String modifiedDate) {
		this.emp_ID = emp_ID;
		this.emp_type = emp_type;
		this.firstname = firstname;
		this.lastname = lastname;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.username = username;
		this.password = password;
		this.roles = roles;
		this.createdDate = createdDate;
		this.lastLogin = lastLogin;
		this.modifiedDate = modifiedDate;
	}

	public ApplicationUser() {
		// TODO Auto-generated constructor stub
	}

	public String get_id() {
		return _id;
	}

	public String getEmp_ID() {
		return emp_ID;
	}

	public void setEmp_ID(String emp_ID) {
		this.emp_ID = emp_ID;
	}

	public String getEmp_type() {
		return emp_type;
	}

	public void setEmp_type(String emp_type) {
		this.emp_type = emp_type;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getlastLogin() {
		return lastLogin;
	}

	public void setlastLogin(String lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	@Override
	public String toString() {
		return "User [_id=" + _id + ", emp_ID=" + emp_ID + ", emp_type=" + emp_type + ", firstname=" + firstname
				+ ", lastname=" + lastname + ", address=" + address + ", email=" + email + ", phone=" + phone
				+ ", username=" + username + ", password=" + password + ", roles=" + roles + ", createdDate="
				+ createdDate + ", LastLogin=" + lastLogin + ", modifiedDate=" + modifiedDate + "]";
	}
	
}
