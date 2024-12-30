package in.co.rays.project_3.test;

import java.util.Date;

import in.co.rays.project_3.dto.EmployeeDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.model.EmployeeModelInt;
import in.co.rays.project_3.model.ModelFactory;

public class BankModelTest {
	public static void main(String[] args) throws Exception, Exception {
		testAdd();
	}

	private static void testAdd() throws ApplicationException, Exception {
		//BankDTO dto=new BankDTO();
		EmployeeDTO dto=new EmployeeDTO();
		dto.setName("Amit");
		//dto.setAddress("address");
		dto.setAccountNumber("123456");
		dto.setDob(new Date());
		dto.setStatus("Active");
		dto.setSalary("9000");
		//BankModelInt bankModel=ModelFactory.getInstance().getBankModel();
		EmployeeModelInt EmployeeModel=ModelFactory.getInstance().getEmployeeModel();
		EmployeeModel.add(dto);
		
		
	}

}
