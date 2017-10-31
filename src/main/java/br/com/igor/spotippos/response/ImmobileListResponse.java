package br.com.igor.spotippos.response;

import java.util.ArrayList;

import br.com.igor.spotippos.model.Immobile;

public class ImmobileListResponse {
	
	private int foundProperties;
	
	private Iterable<Immobile> properties;

	public ImmobileListResponse(ArrayList<Immobile> properties) {
		this.properties = properties;
		
		foundProperties = properties.size();
	}
	
	public int getFoundProperties() {
		return foundProperties;
	}

	public Iterable<Immobile> getProperties() {
		return properties;
	}

	
	
	
	
}
