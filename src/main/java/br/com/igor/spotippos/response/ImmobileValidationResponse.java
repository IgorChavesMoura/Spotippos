package br.com.igor.spotippos.response;

import br.com.igor.spotippos.model.Immobile;

public class ImmobileValidationResponse {

	
	private String status;
	private String message;
	
	public ImmobileValidationResponse(Immobile immobile) {
		
		if(validateImmobile(immobile)) {
			
			status = "Success";
			message = "";
		
		} else {
			
			status = "Error";
			message = "The following fields are invalid: [";
			
			if(!validateImmobileCoordinates(immobile)) {
				message += "x or y";
			}
			if(!validateImmobileBeds(immobile)) {
				message += " beds";
			}
			if(!validateImmobileBaths(immobile)) {
				message += " baths";
			}
			if(!validateImmobileSquareMeters(immobile)) {
				message += " squareMeters";
			}
			
			message += " ]";
			
		}
	
	}
	
	public String getStatus() {
		return this.status;
	}
	
	public String getMessage() {
		return this.message;
	}
	
	
	private boolean validateImmobile(Immobile immobile) {
		
		boolean validateCoordinates = validateImmobileCoordinates(immobile);
		boolean validateBeds = validateImmobileBeds(immobile);
		boolean validateBaths = validateImmobileBaths(immobile);
		boolean validateSquareMeters = validateImmobileSquareMeters(immobile);
		
		return (validateCoordinates && validateBeds && validateBaths && validateSquareMeters);
		
		
	}

	private boolean validateImmobileCoordinates(Immobile immobile) {
		
		boolean validateX = immobile.getX() >= 0 && immobile.getX() <= 1400;
		boolean validateY = immobile.getY() >= 0 && immobile.getY() <= 1000;
		
		return validateX && validateY;
			
	}
	
	private boolean validateImmobileBeds(Immobile immobile) {
		return immobile.getBeds() >= 1 && immobile.getBeds() <= 5;
	}
	
	private boolean validateImmobileBaths(Immobile immobile) {
		return immobile.getBaths() >= 1 && immobile.getBaths() <= 4;
	}
	
	private boolean validateImmobileSquareMeters(Immobile immobile) {
		return immobile.getSquareMeters() >= 20 && immobile.getSquareMeters() <= 240;
	}
	
}
