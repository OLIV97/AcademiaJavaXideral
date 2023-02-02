package com.project.springdemo.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.springdemo.entity.Personal;
import com.project.springdemo.service.PersonalService;

@Controller
@RequestMapping("/personal")
public class PersonalController {

	// need to inject our customer service
	@Autowired
	private PersonalService personalService;
	
	@GetMapping("/list")
	public String listPersonal(Model theModel) {
		
		// get customers from the service
		List<Personal> thePersonal = personalService.getAllPersonal();
				
		// add the customers to the model
		theModel.addAttribute("allpersonal", thePersonal);
		
		return "list-personal";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
		Personal thePersonal = new Personal();
		
		theModel.addAttribute("personal", thePersonal);
		
		return "personal-form";
	}
	
	@PostMapping("/savePersonal")
	public String savePersonal(@ModelAttribute("personal") Personal thePersonal) {
		
		// save the customer using our service
		personalService.savePersonal(thePersonal);	
		
		return "redirect:/personal/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("personalId") int theId,
									Model theModel) {
		
		// get the customer from our service
		Personal thePersonal = personalService.getPersonal(theId);	
		
		// set customer as a model attribute to pre-populate the form
		theModel.addAttribute("personal", thePersonal);
		
		// send over to our form		
		return "personal-form";
	}
	@GetMapping("/delete")
	public String deletePersonal(@RequestParam("personalId") int theId) {
		
		// delete the customer
		personalService.deletePersonal(theId);
		
		return "redirect:/personal/list";
	}
	@GetMapping("/checkEntradaSalida")
	public String checkEntradaSalida(@RequestParam("personalId") int theId, String tipo) {
		

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");		
		Personal thePersonal = personalService.getPersonal(theId);	
		
		if(tipo.equals("ENTRADA")) {
			thePersonal.setHoraentrada(dtf.format(LocalDateTime.now()));			
		}else{
			thePersonal.setHorasalida(dtf.format(LocalDateTime.now()));
		}
//		dd/MM/uuuu 
		
		personalService.checkeEntradaSalidaPersonal(thePersonal);
		
		return "redirect:/personal/list";
	}
}










