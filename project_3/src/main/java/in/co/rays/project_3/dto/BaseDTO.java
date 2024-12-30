package in.co.rays.project_3.dto;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Parent class of all Dto in application. It contains generic attributes.
 * 
 * @author Riya Garhwal
 *
 */

public abstract class BaseDTO implements Serializable, Comparable<BaseDTO>, DropdownList {

	/**
		 * 
		 */
	private static final long serialVersionUID = 1L;
	/** Non Business primary key. */
	protected Long id;
	
	/** Contains USER ID who created this database record. */
	protected String createdBy;
	
	/** Contains USER ID who modified this database record. */
	protected String modifiedBy;
	
	/** Contains Created Timestamp of database record. */
	protected Timestamp createdDatetime;
	
	/** Contains Modified Timestamp of database record. */
	protected Timestamp modifiedDatetime;

	/**
	 * accessor.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * Gets the created by.
	 *
	 * @return the created by
	 */

	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * Sets the created by.
	 *
	 * @param createdBy the new created by
	 */

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * Gets the modified by.
	 *
	 * @return the modified by
	 */
	public String getModifiedBy() {
		return modifiedBy;
	}
	/**
	 * Sets the modified by.
	 *
	 * @param modifiedBy the new modified by
	 */

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	/**
	 * Gets the created datetime.
	 *
	 * @return the created datetime
	 */
	public Timestamp getCreatedDatetime() {
		return createdDatetime;
	}
	/**
	 * Sets the created datetime.
	 *
	 * @param createdDatetime the new created datetime
	 */

	public void setCreatedDatetime(Timestamp createdDatetime) {
		this.createdDatetime = createdDatetime;
	}
	/**
	 * gets the modified datetime.
	 * 
	 * @return the modified datetime
	 */

	public Timestamp getModifiedDatetime() {
		return modifiedDatetime;
	}
	/**
	 * Sets the modified datetime.
	 *
	 * @param modifiedDatetime the new modified datetime
	 */

	public void setModifiedDatetime(Timestamp modifiedDatetime) {
		this.modifiedDatetime = modifiedDatetime;
	}
	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */

	public int compareTo(BaseDTO next) {
		return getValue().compareTo(next.getValue());
	}
}
