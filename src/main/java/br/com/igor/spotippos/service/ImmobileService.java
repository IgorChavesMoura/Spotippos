package br.com.igor.spotippos.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igor.spotippos.model.Immobile;
import br.com.igor.spotippos.repository.ImmobileRepository;
import br.com.igor.spotippos.util.ImmobileHelper;

@Service
public class ImmobileService {
	
	@Autowired
	private ImmobileRepository repository;
	
	@Autowired
	private ProvinceService provinceService;
	
	
	public void save(Immobile immobile) {
		
		if(immobile.getProvinces() == null) {
			immobile.setProvinces(new ArrayList());
			ImmobileHelper.allocateToProvinces(immobile, provinceService.getAll());
		}
		
		repository.save(immobile);
	}
	
	public void save(ArrayList<Immobile> properties) {
		
		for(Immobile immobile : properties) {
			if(immobile.getProvinces() == null) {
				immobile.setProvinces(new ArrayList());
				ImmobileHelper.allocateToProvinces(immobile, provinceService.getAll());
			}
		}
		
		repository.save(properties);
	}
	
	public ArrayList<Immobile> getAll(){
		return (ArrayList<Immobile>) repository.findAll();
	}
	
	public ArrayList<Immobile> getAll(Integer ax, Integer ay, Integer bx, Integer by){
		Iterable<Immobile> properties = repository.findAll();
		
		
		ArrayList<Immobile> filteredProperties = new ArrayList();
		
		for(Immobile immobile : properties) {
			if(ImmobileHelper.isInArea(immobile, ax, ay, bx, by)) {
				filteredProperties.add(immobile);
			}
		}
		
		return filteredProperties;
	}
	
	public Immobile getById(long id) {
		return repository.getOne(id);
	}

}
