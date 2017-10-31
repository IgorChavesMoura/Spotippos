package br.com.igor.spotippos.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Boundaries {

	@Id
	@GeneratedValue
	private long id;
	
	@OneToOne(optional=false, cascade=CascadeType.ALL)
	private Coordinate upperLeft;
	
	@OneToOne(optional=false, cascade=CascadeType.ALL)
	private Coordinate bottomRight;
	
	public Coordinate getUpperLeft() {
		return upperLeft;
	}
	public void setUpperLeft(Coordinate upperLeft) {
		this.upperLeft = upperLeft;
	}
	public Coordinate getBottomRight() {
		return bottomRight;
	}
	public void setBottomRight(Coordinate bottomRight) {
		this.bottomRight = bottomRight;
	}
	
	
	
}
