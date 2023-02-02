package com.project.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springdemo.entity.Personal;

@Repository
public class PersonalDAOImpl implements PersonalDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<Personal> getAllPersonal() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
		Query<Personal> theQuery = 
				currentSession.createQuery("from Personal order by nombres",
						Personal.class);
		
		// execute query and get result list
		List<Personal> allPersonal = theQuery.getResultList();
				
		// return the results		
		return allPersonal;
	}

	@Override
	public void savePersonal(Personal thePersonal) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(thePersonal);
		
	}

	@Override
	public Personal getPersonal(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		Personal theCustomer = currentSession.get(Personal.class, theId);
		
		return theCustomer;
	}

	@Override
	public void deletePersonal(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Personal where id=:personalId");
		theQuery.setParameter("personalId", theId);
		
		theQuery.executeUpdate();		
	}

	@Override
	public void checkeEntradaSalidaPersonal(Personal thePersonal) {
		
		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the customer ... finally LOL
		currentSession.saveOrUpdate(thePersonal);
		
	}
}











