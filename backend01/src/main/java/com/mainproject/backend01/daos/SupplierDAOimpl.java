package com.mainproject.backend01.daos;

import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mainproject.backend01.models.Category;
import com.mainproject.backend01.models.Supplier;

@Repository
@Transactional
public class SupplierDAOimpl implements SupplierDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public boolean addSupplier(Supplier supp) {
		
		try{
			Session session=sessionFactory.getCurrentSession();
			session.persist(supp);
			System.out.println("Supplier Added Succesfully");
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public boolean updateSupplier(Supplier supp) {

		try{
			Session session=sessionFactory.getCurrentSession();
			session.update(supp);
			System.out.println("Supplier updated Succesfully");
			return true;
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public void deleteSupplier(int supplierId) {
		Session session=sessionFactory.getCurrentSession();
		Supplier supp=(Supplier)session.get(Supplier.class, supplierId);
				if(supp==null){
					System.out.println("Supplier Not Found");
				}
				else{
					session.delete(supp);
				}
		
	}

	@Override
	public List<Supplier> supplier() {
		Session session=sessionFactory.getCurrentSession();
		Criteria s=session.createCriteria(Supplier.class);
		List<Supplier> supplierList=s.list();
		return  supplierList;
	}

	@Override
	public Supplier getSupplier(int supplierId) {
		Session session=sessionFactory.getCurrentSession();
		Supplier supp1=(Supplier)session.get(Supplier.class,supplierId);
		return supp1;
		
	}

}
