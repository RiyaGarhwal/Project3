package in.co.rays.project_3.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.co.rays.project_3.dto.BankDTO;
import in.co.rays.project_3.dto.BaseDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.model.BankModelInt;
import in.co.rays.project_3.model.ModelFactory;
import in.co.rays.project_3.model.RoleModelInt;
import in.co.rays.project_3.util.DataUtility;
import in.co.rays.project_3.util.DataValidator;
import in.co.rays.project_3.util.PropertyReader;
import in.co.rays.project_3.util.ServletUtility;

@WebServlet(name = "BankCtl", urlPatterns = { "/ctl/BankCtl" })
public class BankCtl extends BaseCtl {

	protected void preload(HttpServletRequest request) {
		RoleModelInt model = ModelFactory.getInstance().getRoleModel();
		try {
			List list = model.list();
			request.setAttribute("roleList", list);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
					
	protected boolean validate(HttpServletRequest request) {
		boolean pass = true;
		
		if (DataValidator.isNull(request.getParameter("name"))) {
			request.setAttribute("name", PropertyReader.getValue("error.require", " name"));
			
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("name"))) {
			request.setAttribute("name", " name must contains alphabets only");
			System.out.println(pass);
			pass = false;

		}
		if (DataValidator.isNull(request.getParameter("address"))) {
			request.setAttribute("address", PropertyReader.getValue("error.require", "address"));
			System.out.println(pass);
			pass = false;
		} else if (!DataValidator.isName(request.getParameter("address"))) {
			request.setAttribute("address", "address must contains alphabets only");
			System.out.println(pass);
			pass = false;

		}
		if (!OP_UPDATE.equalsIgnoreCase(request.getParameter("operation"))) {
			/*
			 * if (DataValidator.isNull(request.getParameter("password"))) {
			 * request.setAttribute("password", PropertyReader.getValue("error.require",
			 * "Password")); System.out.println(pass); pass = false; }
			 */
			/*
			 * else if (!DataValidator.isPassword(request.getParameter("password"))) {
			 * request.setAttribute("password",
			 * PropertyReader.getValue("Enter the valid Password"));
			 * System.out.println(pass); pass = false; }
			 * 
			 * if (DataValidator.isNull(request.getParameter("confirmPassword"))) {
			 * request.setAttribute("confirmPassword",
			 * PropertyReader.getValue("error.require", "Confirm Password"));
			 * System.out.println(pass); pass = false; } else if
			 * (!DataValidator.isPassword(request.getParameter("confirmPassword"))){
			 * request.setAttribute("confirmPassword",PropertyReader.
			 * getValue("Enter the valid confirmPassword")); pass = false; }
			 * 
			 * 
			 * else if (!request.getParameter("password").equals(request.getParameter(
			 * "confirmPassword"))) { request.setAttribute("confirmPassword",
			 * "Confirm Password should  be matched."); pass = false; } }if
			 * (DataValidator.isNull(request.getParameter("role"))) {
			 * request.setAttribute("role", PropertyReader.getValue("error.require",
			 * "role")); pass = false; } if
			 * (DataValidator.isNull(request.getParameter("gender"))) {
			 * request.setAttribute("gender", PropertyReader.getValue("error.require",
			 * "gender")); pass = false; } 
			 *
			 */
		
			if(DataValidator.isNull(request.getParameter("accountNumber"))) {
			  request.setAttribute("accountNumber", PropertyReader.getValue("error.require", "accountNumber"));
			  pass = false;
		}
			
			  else if (!DataValidator.isAccountNo(request.getParameter("accountNumber"))) {
			  request.setAttribute("accountNumber", "Must contain digit Only And Length 6 to 12 ");
			  pass = false;
			 
		}

		/*
		 * if (DataValidator.isNull(request.getParameter("emailId"))) {
		 * request.setAttribute("emailId", PropertyReader.getValue("error.require",
		 * "email Id")); pass = false; } else if
		 * (!DataValidator.isEmail(request.getParameter("emailId"))) {
		 * request.setAttribute("emailId", PropertyReader.getValue("error.email",
		 * "Email Id ")); pass = false; }
		 */
		
		if (DataValidator.isNull(request.getParameter("dob"))) {
			request.setAttribute("dob", PropertyReader.getValue("error.require", "dob"));
			pass = false;
		
		}
		/*
		 * else if (!DataValidator.isDate(request.getParameter("dob"))) {
		 * request.setAttribute("dob", PropertyReader.getValue("error.date",
		 * "Date Of Birth")); pass = false; }else if
		 * (!DataValidator.isValidAge(request.getParameter("dob"))) {
		 * 
		 * request.setAttribute("dob", "Age Must be greater then 18 year"); pass =
		 * false;
		 */
		
		}
		
		return pass;

	}

	protected BaseDTO populateDTO(HttpServletRequest request) {
		BankDTO dto = new BankDTO();
		
         
         System.out.println(request.getParameter("dob"));      
   
		dto.setId(DataUtility.getLong(request.getParameter("id")));

	//	dto.setRoleId(DataUtility.getLong(request.getParameter("role")));
		dto.setDob(DataUtility.getDate(request.getParameter("dob")));
		dto.setName(DataUtility.getString(request.getParameter("name")));

		dto.setAccountNumber(DataUtility.getString(request.getParameter("accountNumber")));

		dto.setAddress(DataUtility.getString(request.getParameter("address")));

		//dto.setPassword(DataUtility.getString(request.getParameter("password")));

		//dto.setConfirmPassword(DataUtility.getString(request.getParameter("confirmPassword")));

		//dto.setGender(DataUtility.getString(request.getParameter("gender")));
		//dto.setMobileNo(DataUtility.getString(request.getParameter("mobileNo")));
        
		populateBean(dto,request);
		

		return dto;

	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		String op = DataUtility.getString(request.getParameter("operation"));
		BankModelInt model = ModelFactory.getInstance().getBankModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (id > 0 || op != null) {
			BankDTO dto;
			try {
				dto = model.findByPK(id);
				ServletUtility.setDto(dto, request);
			} catch (Exception e) {
				e.printStackTrace();
				ServletUtility.handleException(e, request, response);
				return;
			}
		}
		ServletUtility.forward(getView(), request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String op = DataUtility.getString(request.getParameter("operation"));
		BankModelInt model = ModelFactory.getInstance().getBankModel();
		long id = DataUtility.getLong(request.getParameter("id"));
		if (OP_SAVE.equalsIgnoreCase(op)||OP_UPDATE.equalsIgnoreCase(op)) {
			BankDTO dto = (BankDTO) populateDTO(request);
			try {
				if (id > 0) {
					model.update(dto);
					
					ServletUtility.setSuccessMessage("Data is successfully Update", request);
				} else {
					
					try {
						 model.add(dto);
						 ServletUtility.setDto(dto, request);
						ServletUtility.setSuccessMessage("Data is successfully saved", request);
					} catch (ApplicationException e) {
						ServletUtility.handleException(e, request, response);
						return;
					} catch (DuplicateRecordException e) {
						ServletUtility.setDto(dto, request);
						ServletUtility.setErrorMessage("Login id already exists", request);
					}

				}
				ServletUtility.setDto(dto, request);
				
				
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			} catch (DuplicateRecordException e) {
				ServletUtility.setDto(dto, request);
				ServletUtility.setErrorMessage("Login id already exists", request);
			}
		} else if (OP_DELETE.equalsIgnoreCase(op)) {

			BankDTO dto = (BankDTO) populateDTO(request);
			try {
				model.delete(dto);
				ServletUtility.redirect(ORSView.BANK_LIST_CTL, request, response);
				return;
			} catch (ApplicationException e) {
				ServletUtility.handleException(e, request, response);
				return;
			}

		} else if (OP_CANCEL.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.BANK_LIST_CTL, request, response);
			return;
		} else if (OP_RESET.equalsIgnoreCase(op)) {

			ServletUtility.redirect(ORSView.BANK_CTL, request, response);
			return;
		}
		ServletUtility.forward(getView(), request, response);

	}

	@Override
	protected String getView() {
		// TODO Auto-generated method stub
		return ORSView.BANK_VIEW;
	}

	

}
