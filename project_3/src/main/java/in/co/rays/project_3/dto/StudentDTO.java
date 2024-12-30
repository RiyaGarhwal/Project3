package in.co.rays.project_3.dto;

import java.util.Date;

/**
 * Student JavaDto encapsulates student attributes
 * 
 * @author Riya Garhwal
 *
 */

public class StudentDTO extends BaseDTO {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 /** First Name of Student. */
	private String firstName;
	 /** Last Name of Student. */
	private String lastName;
	 /** Email of Student. */
	private String emailId;
	 /** Mobileno of Student. */
	private String mobileNo;
	 /** CollegeId of Student. */
	private long collegeId;
	 /** Date of Birth of Student. */
	private Date dob;
	 /** College name of Student. */
	private String collegeName;
	/**
	  * accessor.
	  *
	  * @return the first name
	  */

	public String getFirstName() {
		return firstName;
	}
	 /**
	  * Sets the first name.
	  *
	  * @param firstName the new first name
	  */

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	 /**
	  * Gets the last name.
	  *
	  * @return the last name
	  */


	public String getLastName() {
		return lastName;
	}
	/**
	  * Sets the last name.
	  *
	  * @param lastName the new last name
	  */

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	  * Gets the email.
	  *
	  * @return the email
	  */


	public String getEmailId() {
		return emailId;
	}
	/**
	  * Sets the email.
	  *
	  * @param email the new email
	  */

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	/**
	  * Gets the mobile no.
	  *
	  * @return the mobile no
	  */
	public String getMobileNo() {
		return mobileNo;
	}
	/**
	  * Sets the mobile no.
	  *
	  * @param mobileNo the new mobile no
	  */


	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public long getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(long collegeId) {
		this.collegeId = collegeId;
	}
	 /**
	  * Gets the dob.
	  *
	  * @return the dob
	  */

	public Date getDob() {
		return dob;
	}
	/**
	  * Sets the mobile no.
	  *
	  * @param mobileNo the new mobile no
	  */
	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getKey() {
		// TODO Auto-generated method stub
		return id+" ";
	}
	 /* (non-Javadoc)
	  * @see in.co.rays.ors.bean.DropdownListBean#getValue()
	  */

	public String getValue() {
		// TODO Auto-generated method stub
		return firstName+" "+lastName;
	}

}
