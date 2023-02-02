package com.project.springdemo.dao;

import java.util.List;


import com.project.springdemo.entity.Personal;

public interface PersonalDAO {

	public List<Personal> getAllPersonal();

	public void savePersonal(Personal thePersonal);

	public Personal getPersonal(int theId);

	public void deletePersonal(int theId);
	
	public void checkeEntradaSalidaPersonal(Personal thePersonal);
	
}
