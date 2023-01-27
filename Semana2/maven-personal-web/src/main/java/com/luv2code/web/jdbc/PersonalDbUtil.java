package com.luv2code.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PersonalDbUtil {

	private DataSource dataSource;

	public PersonalDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
//	getStudents
	public List<Personal> getAllPersonal(){
		
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


 void addPersonal(Personal thePersonal){

		String sql = "insert into lista_asistencia "
				   + "(nombres, apellidos) "
				   + "values (?, ?)";
		try(Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = myConn.prepareStatement(sql);
				) {

			// set the param values for the student
			myStmt.setString(1, thePersonal.getNombres());
			myStmt.setString(2, thePersonal.getApellidos());
			// execute sql insert
			myStmt.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}

	public Personal getPersonal(String thePersonalId){

		Personal thePersonal = null;
		
		String sql = "select * from lista_asistencia where id=?";
		
		int personaltId;
		
		try(Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt= myConn.prepareStatement(sql);) {
			
			
			personaltId = Integer.parseInt(thePersonalId);

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

	public void updatePersonal(Personal thePersonal){
		
		
		String sql = "update lista_asistencia "
				+ "set nombres=?, apellidos=?"
				+ "where id=?";

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = myConn.prepareStatement(sql); ) {
			
			myStmt.setString(1, thePersonal.getNombres());
			myStmt.setString(2, thePersonal.getApellidos());
			myStmt.setInt(3, thePersonal.getId());
			
			// execute SQL statement
			myStmt.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void deletePersonal(String thePersonalId){
	
		String sql = "delete from lista_asistencia where id=?";
		try(Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt =myConn.prepareStatement(sql);) {

			int personalId = Integer.parseInt(thePersonalId);

			myStmt.setInt(1, personalId);
			
			myStmt.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void checkeEntradaSalidaPersonal(String thePersonalId,String entrada,String tipo){
		
		
		String sql = "update lista_asistencia "
				+ "set  "+tipo+"=?"
				+ "where id=?";

		try (Connection myConn = dataSource.getConnection();
				PreparedStatement myStmt = myConn.prepareStatement(sql); ) {
			
			myStmt.setString(1, entrada);
			myStmt.setString(2, thePersonalId);
			myStmt.execute();
		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}















