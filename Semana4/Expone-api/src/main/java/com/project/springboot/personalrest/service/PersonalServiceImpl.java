package com.project.springboot.personalrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.project.springboot.personalrest.dao.PersonalDao;
import com.project.springboot.personalrest.entity.Personal;

@Service
public class PersonalServiceImpl implements PersonalService {

	private PersonalDao personalDao;
	
	@Autowired
	public PersonalServiceImpl(PersonalDao thePersonalDao) {
		personalDao = thePersonalDao;
	}
	
	@Override
	@Transactional
	public List<Personal> getAllPersonal() {
		
		return personalDao.getAllPersonal();
	}

	@Override
	@Transactional
	public void savePersonal(Personal thePersonal) {
		personalDao.savePersonal(thePersonal);
		
	}

	@Override
	@Transactional
	public Personal getPersonal(int theId) {
		return personalDao.getPersonal(theId);
	}

	@Override
	@Transactional
	public void deletePersonal(int theId) {
		personalDao.deletePersonal(theId);
		
	}

}
