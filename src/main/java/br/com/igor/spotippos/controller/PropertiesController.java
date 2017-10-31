package br.com.igor.spotippos.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.spotippos.model.Immobile;
import br.com.igor.spotippos.response.ImmobileListResponse;
import br.com.igor.spotippos.response.ImmobileValidationResponse;
import br.com.igor.spotippos.service.ImmobileService;
import br.com.igor.spotippos.util.ImmobileHelper;

@RestController
@RequestMapping("properties")
public class PropertiesController {
	
	@Autowired
	private ImmobileService service;
	
	
	//**ONLY** used to load properties.json in database
	@RequestMapping(value="/list", method=RequestMethod.POST)
	public void save(@RequestBody ArrayList<Immobile> properties) {
		
		System.out.println(properties.size());
		service.save(properties);
		
	}
	
	@RequestMapping(value="", method=RequestMethod.POST)
	public ImmobileValidationResponse save(@RequestBody Immobile immobile) {
		
		ImmobileValidationResponse response = new ImmobileValidationResponse(immobile);
		
		if(response.getStatus().equals("Success")) {
			service.save(immobile);
		}
		
		return response;
		
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public ImmobileListResponse getAll(@RequestParam(value="ax", required=false) Integer ax, 
									   @RequestParam(value="ay", required=false) Integer ay,
									   @RequestParam(value="bx", required=false) Integer bx,
									   @RequestParam(value="by", required=false) Integer by){
		
		
		ArrayList<Immobile> filteredProperties;
		ImmobileListResponse response;
		
		if(ImmobileHelper.validateGetParams(ax, ay, bx, by)) {
		 	
			filteredProperties = service.getAll(ax,ay,bx,by);
			
		 	
		} else {
			
			filteredProperties = service.getAll();
			
			
			
		}
		response = new ImmobileListResponse(filteredProperties);
		return response;
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public Immobile getById(@PathVariable long id) {
		return service.getById(id);
	}
}
