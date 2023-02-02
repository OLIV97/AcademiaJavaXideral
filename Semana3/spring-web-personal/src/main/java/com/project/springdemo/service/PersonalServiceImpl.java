package com.project.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.springdemo.dao.PersonalDAO;
import com.project.springdemo.entity.Personal;

@Service
public class PersonalServiceImpl implements PersonalService {

	// need to inject customer dao
	//personalDAOImpljdbc
	@Autowired
	@Qualifier("personalDAOImpljdbc")
	private PersonalDAO personalDAO;
	
	@Override
	@Transactional
	public List<Personal> getAllPersonal() {
		return personalDAO.getAllPersonal();
	}

	@Override
	@Transactional
	public void savePersonal(Personal thePersonal) {

		personalDAO.savePersonal(thePersonal);
	}

	@Override
	@Transactional
	public Personal getPersonal(int theId) {
		
		return personalDAO.getPersonal(theId);
	}

	@Override
	@Transactional
	public void deletePersonal(int theId) {
		
		personalDAO.deletePersonal(theId);
	}
	
	@Override
	@Transactional
	public void checkeEntradaSalidaPersonal(Personal thePersonal) {
		
		personalDAO.checkeEntradaSalidaPersonal(thePersonal);
	}
}





