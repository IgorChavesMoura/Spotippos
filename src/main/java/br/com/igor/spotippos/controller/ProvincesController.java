package br.com.igor.spotippos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.igor.spotippos.model.Province;
import br.com.igor.spotippos.service.ProvinceService;

@RestController
@RequestMapping("provinces")
public class ProvincesController {
	
	@Autowired
	private ProvinceService service;

	@RequestMapping(value="", method=RequestMethod.POST)
	public void save(@RequestBody Province province) {
		service.save(province);
	}
	
	@RequestMapping(value="list", method=RequestMethod.POST)
	public void save(@RequestBody List<Province> provinces) {
		service.save(provinces);
	}
	
	@RequestMapping(value="", method=RequestMethod.GET)
	public Iterable<Province> getProvinces() {
		return service.getAll();
	}
}
