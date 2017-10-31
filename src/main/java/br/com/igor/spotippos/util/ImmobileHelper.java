package br.com.igor.spotippos.util;

import br.com.igor.spotippos.model.Immobile;
import br.com.igor.spotippos.model.Province;

public class ImmobileHelper {
	
	public static void allocateToProvinces(Immobile immobile, Iterable<Province> provinces) {
		
		for(Province province : provinces) {
			if(isInProvince(immobile,province)) {
				immobile.getProvinces().add(province.getName());
			}
		}
	
	}
	
	public static boolean validateGetParams(Integer ax, Integer ay, Integer bx, Integer by) {
		
		boolean validateAx = ax != null;
		boolean validateAy = ay != null;
		
		boolean validateBx = bx != null;
		boolean validateBy = by != null;
		
		return (((validateAx) && (validateAy)) && ((validateBx) && (validateBy)));
		
	}
	
	public static boolean isInArea(Immobile immobile, Integer ax, Integer ay, Integer bx, Integer by) {
		
		boolean isInUpperLeft = immobile.getX() >= ax && immobile.getY() <= ay;
		boolean isInBottomRight = immobile.getX() <= bx && immobile.getY() >= by;
		
		return (isInUpperLeft && isInBottomRight);
		
	}
	

	
	private static boolean isInProvince(Immobile immobile, Province province) {
		
		boolean isInUpperLeftX = immobile.getX() >= province.getBoundaries().getUpperLeft().getX();
		boolean isInUpperLeftY = immobile.getY() <= province.getBoundaries().getUpperLeft().getY();
		
		boolean isInBottomRightX = immobile.getX() <= province.getBoundaries().getBottomRight().getX();
		boolean isInBottomRightY = immobile.getY() >= province.getBoundaries().getBottomRight().getY();
		
		
		return ((isInUpperLeftX) && (isInUpperLeftY)) && ((isInBottomRightX) && (isInBottomRightY));
	}
	
	
}
