package in.co.rays.project_3.dto;

import java.sql.Timestamp;
import java.util.Date;

/**
 * User JavaDto encapsulates user attributes
 * 
 * @author Riya Garhwal
 *
 */
public class UserDTO extends BaseDTO {
	/**
	 * Lock Active constant for User
	 */
	public static final String ACTIVE = "Active";

	/**
	 * Lock Inactive constant for User
	 */
	public static final String INACTIVE = "Inactive";

	/**
	 * First Name of User
	 */
	private String firstName;

	/**
	 * Last Name of User
	 */
	private String lastName;
	/**
	 * Login of User
	 */
	private String login;

	/**
	 * Password of User
	 */
	private String password;

	/**
	 * Confirm password of User
	 */
	private String confirmPassword;
	/**
	 * Date of Birth of User
	 */
	private Date dob;
	/**
	 * Mobile Number of User
	 */
	private String mobileNo;
	/**
	 * number of unsuccessful login attempt
	 */
	private int unSuccessfullLogin;
	/**
	 * Gender of User
	 */
	private String gender;
	/**
	 * Role of User
	 */
	private long roleId;

	/**
	 * IP Address of User of his last login
	 */
	private Timestamp lastLogin;

	/**
	 * IP Address of User from where User was registred.
	 */
	private String registeredIP;
	/**
	 * last login Timestamp
	 */
	private String loginIP;

	/**
	 * accessor
	 */

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public int getUnSuccessfullLogin() {
		return unSuccessfullLogin;
	}

	public void setUnSuccessfullLogin(int unSuccessfullLogin) {
		this.unSuccessfullLogin = unSuccessfullLogin;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public long getRoleId() {
		return roleId;
	}

	public void setRoleId(long roleId) {
		this.roleId = roleId;
	}

	public Timestamp getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(Timestamp lastLogin) {
		this.lastLogin = lastLogin;
	}

	public String getRegisteredIP() {
		return registeredIP;
	}

	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}

	public String getLoginIP() {
		return loginIP;
	}

	public void setLoginIP(String loginIP) {
		this.loginIP = loginIP;
	}

	public static String getActive() {
		return ACTIVE;
	}

	public static String getInactive() {
		return INACTIVE;
	}

	
	  public String getKey() {
	  
	  return id + ""; 
	  }
	  
	  public String getValue() {
	  
	  return firstName + "" + lastName; 
	  }
	  
	 
	/*
	 * @Override public String getKey() { // TODO Auto-generated method stub return
	 * firstName; }
	 * 
	 * @Override public String getValue() { // TODO Auto-generated method stub
	 * return firstName; }
	 */

}
