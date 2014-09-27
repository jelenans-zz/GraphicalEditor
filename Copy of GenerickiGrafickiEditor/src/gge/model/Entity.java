/***********************************************************************
 * Module:  Rectangle.java
 * Author:  Sladza
 * Purpose: Defines the Class Rectangle
 ***********************************************************************/
//
//ovo je 
package gge.model;


import gge.view.ElementPainter;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ArrayList;

//ovo je entitet
public class Entity extends GraphElement {
   protected void finalize() {
      // TODO: implement
   }
   
	ArrayList<Atribute> atributi;
	ArrayList<GeneralPath> linije;
	ArrayList<ElementPainter> atributPainteri;
	ArrayList<Atribute>  key;
  
   public Entity(Point2D position, Dimension2D size) {
		super(position, size);
		name = "entity";
		type = "entity";
		atributi= new ArrayList<Atribute>();
		atributPainteri= new ArrayList<ElementPainter>();
		linije= new ArrayList<GeneralPath>();
		key= new ArrayList<Atribute>();
	}
   
   

   public ArrayList<Atribute> getKey() {
	return key;
}



public void setKey(ArrayList<Atribute> key) {
	this.key = key;
}



public ArrayList<GeneralPath> getLinije() {
//	   for(int i=0;i<linije.size();i++)
//		   System.out.println("linija"+i+": "+linije.get(i).toString());
	return linije;
}



public void setLinije(ArrayList<GeneralPath> linije) {
	this.linije = linije;
}



public ArrayList<Atribute> getAtributi() {
	return atributi;
}



public void setAtributi(ArrayList<Atribute> atributi) {
	this.atributi = atributi;
}

public void dodajAtribut(GeneralPath linija, GraphElement newElem, ElementPainter newPainter)
{
//		linija.moveTo(this.getPosition().getX()+this.getSize().getWidth(), this.getPosition().getY()+this.getSize().getHeight());
//		linija.lineTo(newElem.getPosition().getX()+ newElem.getSize().getWidth()/2,newElem.getPosition().getY());
		linije.add(linija);
		atributi.add((Atribute)newElem);
		atributPainteri.add(newPainter);
}

public ArrayList<ElementPainter> getAtributPainteri() {
	return atributPainteri;
}



public void setAtributPainteri(ArrayList<ElementPainter> atributPainteri) {
	this.atributPainteri = atributPainteri;
}



@Override
  	public Entity createCopy() {
  		Point2D positionCopy = new Point2D.Double(position.getX(), position.getY());
  		Dimension sizeCopy = new Dimension((int)size.getWidth(), (int)size.getHeight());
  		Entity entityCopy = new Entity(positionCopy, sizeCopy);
  		entityCopy.setName(name);
  		entityCopy.setType(type);
  		entityCopy.setDescription(description);
  		entityCopy.setColor(color);
  		entityCopy.setBorderColor(borderColor);
  		entityCopy.setLineStyle(lineStyle);
  		entityCopy.setLineStyleName(lineStyleName);
  		entityCopy.setFontName(fontName);
  		entityCopy.setFontStyle(fontStyle);
  		entityCopy.setFontSize(fontSize);
  		entityCopy.setFontColor(fontColor);
  		entityCopy.setUnderline(underline);
  		entityCopy.setShadowStyle(shadowStyle);
  		entityCopy.setShading(shading);
  		entityCopy.setShadow(shadow);
  		entityCopy.setResize(resize);
  		entityCopy.setFill(fill);
  		entityCopy.setAtributi(atributi);
  		entityCopy.setKey(key);
  		entityCopy.setConnectionPoints(connectionPoints);
  		return entityCopy;
  	}

}