package com.project.springdemo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.springdemo.entity.Personal;

@Repository
public class PersonalDAOImpljdbc implements PersonalDAO {

	@Autowired
	DataSource dataSource;
	
	@Override
	public List<Personal> getAllPersonal() {
		
		List<Personal> allPersonal = new ArrayList<>();

		String sql = "select * from lista_asistencia order by apellidos";
		try (Connection myConn = dataSource.getConnection();
				Statement myStmt = myConn.createStatement();
				ResultSet myRs = myStmt.executeQuery(sql)) {
		
			while (myRs.next()) {
				
				int id = myRs.getInt("id");
				String nombres = myRs.getString("nombres");
				String apellidos = myRs.getString("apellidos");
				String horaentrada = myRs.getString("hora_entrada");
				String horasalida = myRs.getString("hora_salida");
				// create new student object
				Personal tempPersonal = new Personal(id, nombres, apellidos, horaentrada,horasalida);
				
				allPersonal.add(tempPersonal);				
			}
			
			return allPersonal;		
		}catch (Exception e) {
			e.printStackTrace();
			return allPersonal;
		}
	}

	@Override
	public void savePersonal(Personal thePersonal) {



		String sql = thePersonal.getId()==0 ?"insert into lista_asistencia "
				   + "(nombres, apellidos) "
				   + "values (?, ?)":"update lista_asistencia "
							+ "set nombres=?, apellidos=?"
							+ "where id=?";

		try(Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = myConn.prepareStatement(sql);
				) {

			if(thePersonal.getId()==0) {
				myStmt.setString(1, thePersonal.getNombres());
				myStmt.setString(2, thePersonal.getApellidos());				
			}else {
				myStmt.setString(1, thePersonal.getNombres());
				myStmt.setString(2, thePersonal.getApellidos());		
				myStmt.setInt(3, thePersonal.getId());
			}
			
			myStmt.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}	

	}

	@Override
	public Personal getPersonal(int theId) {
Personal thePersonal = null;
		
		String sql = "select * from lista_asistencia where id=?";
		
		int personaltId;
		
		try(Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt= myConn.prepareStatement(sql);) {
			
			
			personaltId = theId;

			myStmt.setInt(1, personaltId);
			try(ResultSet myRs = myStmt.executeQuery();) {
				if (myRs.next()) {
					String nombres = myRs.getString("nombres");
					String apellidos = myRs.getString("apellidos");
					String horaentrada = myRs.getString("hora_entrada");
					String horasalida = myRs.getString("hora_salida");
					
					// use the studentId during construction
					thePersonal = new Personal(personaltId, nombres, apellidos, horaentrada,horasalida);
				}
				else {				
					System.out.println("No se puede encontral al personal con  id: " + personaltId);
					return thePersonal;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			// retrieve data from result set row
				
			
			return thePersonal;
		}catch (Exception e) {
			e.printStackTrace();
			return thePersonal;
		}
	}

	@Override
	public void deletePersonal(int theId) {
		String sql = "delete from lista_asistencia where id=?";
		try(Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt =myConn.prepareStatement(sql);) {

			int personalId = theId;

			myStmt.setInt(1, personalId);
			
			myStmt.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	@Override
	public void checkeEntradaSalidaPersonal(Personal thePersonal){
		
		String sql = "";
		String date = "";
		Personal old = this.getPersonal(thePersonal.getId());
		
		if(!thePersonal.getHoraentrada().equals(old.getHoraentrada())) {
			sql = "update lista_asistencia "
			+ "set  hora_entrada=?"
			+ "where id=?";
			date = thePersonal.getHoraentrada();
		}else {
			sql = "update lista_asistencia "
			+ "set  hora_salida=?"
			+ "where id=?";
			date = thePersonal.getHorasalida();
		}
		


		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = myConn.prepareStatement(sql); ) {
			
			myStmt.setString(1, date);
			myStmt.setInt(2, thePersonal.getId());
			myStmt.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}











