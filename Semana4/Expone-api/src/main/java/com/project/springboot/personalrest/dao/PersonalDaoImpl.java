package com.project.springboot.personalrest.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springboot.personalrest.entity.Personal;

@Repository
public class PersonalDaoImpl implements PersonalDao {

	private EntityManager entityManager;
	
	@Autowired
	public PersonalDaoImpl(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	
	@Override
	public List<Personal> getAllPersonal() {
	
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		Query<Personal> theQuery =
				currentSession.createQuery("from Personal", Personal.class);
		
	
		List<Personal> personals = theQuery.getResultList();
	
		return personals;
	}

	@Override
	public void savePersonal(Personal thePersonal) {
		
		Session currentSession = entityManager.unwrap(Session.class);

		currentSession.saveOrUpdate(thePersonal);
		
	}

	@Override
	public Personal getPersonal(int theId) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		Personal thePersonal =
				currentSession.get(Personal.class, theId);
		
		// return the employee
		return thePersonal;
	}

	@Override
	public void deletePersonal(int theId) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery(
						"delete from Personal where id=:personalId");
		theQuery.setParameter("personalId", theId);
		
		theQuery.executeUpdate();
		
	}

	
}
