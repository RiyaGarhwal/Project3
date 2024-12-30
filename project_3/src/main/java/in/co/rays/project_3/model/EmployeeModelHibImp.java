package in.co.rays.project_3.model;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import in.co.rays.project_3.dto.EmployeeDTO;
import in.co.rays.project_3.exception.ApplicationException;
import in.co.rays.project_3.exception.DuplicateRecordException;
import in.co.rays.project_3.util.HibDataSource;

public class EmployeeModelHibImp implements EmployeeModelInt{
	public long add(EmployeeDTO dto) throws ApplicationException, DuplicateRecordException {


		EmployeeDTO existDto = null;
		
		Session session = HibDataSource.getSession();
		Transaction tx = null;
		try {

			tx = session.beginTransaction();

			session.save(dto);

			dto.getId();
			tx.commit();
		} catch (HibernateException e) {
			e.printStackTrace();
			if (tx != null) {
				tx.rollback();

			}
			throw new ApplicationException("Exception in Employee Add " + e.getMessage());
		} finally {
			session.close();
		}
		return dto.getId();

	}

	
	public void delete(EmployeeDTO dto) throws ApplicationException {
		Session session = null;
		Transaction tx = null;
		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.delete(dto);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("Exception in Employee Delete" + e.getMessage());
		} finally {
			session.close();
		}
	}


	public void update(EmployeeDTO dto) throws ApplicationException, DuplicateRecordException {
		Session session = null;
		
		Transaction tx = null;

		try {
			session = HibDataSource.getSession();
			tx = session.beginTransaction();
			session.saveOrUpdate(dto);
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw new ApplicationException("Exception in Employee update" + e.getMessage());
		} finally {
			session.close();
		}
	}

	

	public EmployeeDTO findByPK(long pk) throws ApplicationException {
		Session session = null;
		EmployeeDTO dto = null;
		try {
			session = HibDataSource.getSession();
			dto = (EmployeeDTO) session.get(EmployeeDTO.class, pk);

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in getting Employee by pk");
		} finally {
			session.close();
		}

		return dto;
	}

	

	public EmployeeDTO findByLogin(String login) throws ApplicationException {
		Session session = null;
		EmployeeDTO dto = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(EmployeeDTO.class);
			criteria.add(Restrictions.eq("login", login));
			List list = criteria.list();
			if (list.size() == 1) {
				dto = (EmployeeDTO) list.get(0);
			}
		} catch (HibernateException e) {
			e.printStackTrace();
			throw new ApplicationException("Exception in getting Employee by Login " + e.getMessage());

		} finally {
			session.close();
		}

		return dto;
	}

	
	public List list() throws ApplicationException {
		return list(0, 0);
	}

	

	public List list(int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub
		Session session = null;
		List list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(EmployeeDTO.class);
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);

			}
			list = criteria.list();

		} catch (HibernateException e) {
			throw new ApplicationException("Exception : Exception in  Employees list");
		} finally {
			session.close();
		}

		return list;
	}

	
	public List search(EmployeeDTO dto) throws ApplicationException {
		// TODO Auto-generated method stub
		return search(dto, 0, 0);
	}

	
	public List search(EmployeeDTO dto, int pageNo, int pageSize) throws ApplicationException {
		// TODO Auto-generated method stub

		Session session = null;
		ArrayList<EmployeeDTO> list = null;
		try {
			session = HibDataSource.getSession();
			Criteria criteria = session.createCriteria(EmployeeDTO.class);
			if (dto != null) {
				if (dto.getId() != null && dto.getId() > 0) {
					criteria.add(Restrictions.eq("id", dto.getId()));
				}
				if (dto.getName() != null && dto.getName().length() > 0) {
					criteria.add(Restrictions.like("name", dto.getName() + "%"));
				}
				
				  if (dto.getSalary() != null && dto.getSalary().length() > 0) {
				  criteria.add(Restrictions.like("salary", dto.getSalary() + "%"));
				  }

				  if (dto.getStatus() != null && dto.getStatus().length() > 0) {
				  criteria.add(Restrictions.like("status", dto.getStatus() + "%"));
				  }
				  
				
				
				  if (dto.getAccountNumber() != null && dto.getAccountNumber().length() > 0) {
				  criteria.add(Restrictions.eq("accountNumber", dto.getAccountNumber())); }
				 
				
				if (dto.getDob() != null && dto.getDob().getTime() > 0) {
					criteria.add(Restrictions.eq("dob", dto.getDob()));
				}
				
				
			}
			
			
			if (pageSize > 0) {
				pageNo = (pageNo - 1) * pageSize;
				criteria.setFirstResult(pageNo);
				criteria.setMaxResults(pageSize);
			}
			list = (ArrayList<EmployeeDTO>) criteria.list();
		} catch (HibernateException e) {
			throw new ApplicationException("Exception in Employee search");
		} finally {
			session.close();
		}

		return list;
	}

	

	public List getRoles(EmployeeDTO dto) throws ApplicationException {
		return null;
	}



	
	

	

}
