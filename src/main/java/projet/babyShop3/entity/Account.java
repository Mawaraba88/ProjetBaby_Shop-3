package projet.babyShop3.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity

@Table(name = "Accounts")
public class Account  implements Serializable{
	
	private static final long serialVersionUID = -2054386655979281969L;
	 
    public static final String ROLE_MANAGER = "MANAGER";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";
    public static final String ROLE_CUSTOMER = "CUSTOMER";
    
  
    @Id
    @Column(name = "User_Name", length = 20, nullable = false)
    private String userName;
 
    @Column(name = "Active", length = 1, nullable = false)
    private boolean active;
 
    @Column(name = "Encryted_Password", length = 128, nullable = false)
    private String encrytedPassword;
 
 
    @Column(name = "User_Role", length = 20, nullable = false)
    private String userRole;


	public Account(String userName, boolean active, String encrytedPassword, String userRole) {
		super();
		this.userName = userName;
		this.active = active;
		this.encrytedPassword = encrytedPassword;
		this.userRole = userRole;
	}


	public Account() {
		super();
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public boolean isActive() {
		return active;
	}


	public void setActive(boolean active) {
		this.active = active;
	}


	public String getEncrytedPassword() {
		return encrytedPassword;
	}


	public void setEncrytedPassword(String encrytedPassword) {
		this.encrytedPassword = encrytedPassword;
	}


	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public static String getRoleManager() {
		return ROLE_MANAGER;
	}


	public static String getRoleEmployee() {
		return ROLE_EMPLOYEE;
	}


	public static String getRoleCustomer() {
		return ROLE_CUSTOMER;
	}
    
    
	/*
	 * public Account(Account account) {
	 * 
	 * this.userName = account.getUserName(); this.active = active;
	 * this.encrytedPassword = encrytedPassword; this.userRole = userRole; }
	 */

 

    
}