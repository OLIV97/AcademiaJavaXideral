package com.project.springboot.personalrest.dao;

import java.util.List;

import com.project.springboot.personalrest.entity.Personal;

public interface PersonalDao {

	public List<Personal> getAllPersonal();

	public void savePersonal(Personal thePersonal);

	public Personal getPersonal(int theId);

	public void deletePersonal(int theId);
	
}
