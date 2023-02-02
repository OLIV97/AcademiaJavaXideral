package com.project.springdemo.service;

import java.util.List;

import com.project.springdemo.entity.Personal;

public interface PersonalService {

	public List<Personal> getAllPersonal();

	public void savePersonal(Personal theCustomer);

	public Personal getPersonal(int theId);

	public void deletePersonal(int theId);
	
	public void checkeEntradaSalidaPersonal(Personal thePersonal);
}
