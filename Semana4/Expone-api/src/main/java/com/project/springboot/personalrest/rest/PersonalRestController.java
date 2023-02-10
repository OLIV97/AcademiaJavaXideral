package com.project.springboot.personalrest.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.project.springboot.personalrest.entity.Personal;
import com.project.springboot.personalrest.service.PersonalService;

@RestController
@RequestMapping("/api")
public class PersonalRestController {

	private PersonalService personalService;
	
	@Autowired
	public PersonalRestController(PersonalService thePersonalService) {
		personalService = thePersonalService;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/personal")
	public List<Personal> findAll() {
		return personalService.getAllPersonal();
	}

	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/personal/{personalId}")
	public Personal getPersonal(@PathVariable int personalId) {
		
		Personal thePersonal = personalService.getPersonal(personalId);
		
		if (thePersonal == null) {
			throw new PersonalNotFoundException("Personal con el id :" + personalId+" no encontrado");
		}
		
		return thePersonal;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/personal")
	public Personal addPersonal(@RequestBody Personal thePersonal) {
		
		thePersonal.setId(0);
		
		personalService.savePersonal(thePersonal);

		return thePersonal;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/personal")
	public Personal updatePersonal(@RequestBody Personal thePersonal) {
		
		personalService.savePersonal(thePersonal);
		
		return thePersonal;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@RequestMapping(value ="/personal/check/{personalId}/{type}",method = RequestMethod.PUT)
	public Personal checkeEntradaSalidaPersonal(@PathVariable("personalId") int personalId, @PathVariable("type") String type) {
		
		Personal thePersonal = personalService.getPersonal(personalId);
		DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
		Calendar obj = Calendar.getInstance();
		if(type.equals("entrada")) {
			thePersonal.setHoraentrada(formatter.format(obj.getTime()));
		}else {
			thePersonal.setHorasalida(formatter.format(obj.getTime()));
		}
		personalService.savePersonal(thePersonal);
		
		return thePersonal;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/personal/{personalId}")
	public ResponseEntity<Object>  deleteEmployee(@PathVariable int personalId) {
		
		Personal tempPersonal = personalService.getPersonal(personalId);
		
		// throw exception if null
		
		if (tempPersonal == null) {
			throw new PersonalNotFoundException("Personal con el id :" + personalId+" no encontrado");
		}
		
	      Map<String, Object> map = new HashMap<String, Object>();
          map.put("message", "Personal eliminado con el id - " + personalId );
          map.put("status", HttpStatus.OK);
          map.put("data", null);
          
		personalService.deletePersonal(personalId);
		   return new ResponseEntity<>(
				   map,
				      HttpStatus.OK);
				
//		return "Personal eliminado con el id - " + personalId;
	}
}
