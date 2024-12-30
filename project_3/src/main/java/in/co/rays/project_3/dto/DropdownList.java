package in.co.rays.project_3.dto;

/**
 * DropdownList interface is implemented by Beans those are used to create 
 * drop down list on HTML pages
 * 
 * @author Riya Garhwal
 *
 */
public interface DropdownList {
	 /**
	  * Returns key of list element.
	  *
	  * @return key
	  */
public String getKey();
/**
 * Returns display text of list element.
 *
 * @return value
 */
public String getValue();
}
