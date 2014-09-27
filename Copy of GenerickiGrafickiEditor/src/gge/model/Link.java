
package gge.model;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;


public class Link extends Element {
   private GraphElement first;
   private GraphElement second;
   private List<Point2D> breakPoints; 
   private Point2D pocetnaTacka; 
   private Point2D krajnjaTacka;
   private String type;
   

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public Point2D getPocetnaTacka() {
	return pocetnaTacka;
}

public void setPocetnaTacka(Point2D pocetnaTacka) {
	this.pocetnaTacka = pocetnaTacka;
}

public Point2D getKrajnjaTacka() {
	return krajnjaTacka;
}

public void setKrajnjaTacka(Point2D krajnjaTacka) {
	this.krajnjaTacka = krajnjaTacka;
}

public Link() {
	super();
	name = "link";
	type="link";
	breakPoints = new ArrayList<Point2D>();	
}

   public String getName(){
	   return name;
   }

public GraphElement getFirst() {
	return first;
}
public void setFirst(GraphElement first) {
	this.first = first;
}
public GraphElement getSecond() {
	return second;
}
public void setSecond(GraphElement second) {
	this.second = second;
}



@Override
public Element createCopy() {
	// TODO Auto-generated method stub
	return null;
}



public List<Point2D> getBreakPoints() {
	return breakPoints;
}



public void setBreakPoints(List<Point2D> breakPoints) {
	this.breakPoints = breakPoints;
}


	
}



