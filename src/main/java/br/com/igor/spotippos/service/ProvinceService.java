package br.com.igor.spotippos.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.igor.spotippos.model.Province;
import br.com.igor.spotippos.repository.ProvinceRepository;

@Service
public class ProvinceService {
	
	@Autowired
	private ProvinceRepository repository;
	
	public Iterable<Province> getAll(){
		return repository.findAll();	
	}
	
	public void save(Province province) {
		repository.save(province);
	}
	
	public void save(Iterable<Province> provinces) {
		repository.save(provinces);
	}
	
	
}
