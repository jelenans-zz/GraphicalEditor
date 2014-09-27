/***********************************************************************
 * Module:  Ellipse.java
 * Author:  Sladza
 * Purpose: Defines the Class Ellipse
 ***********************************************************************/

package gge.model;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
//ovo je domen ili obiljezje
public class Atribute extends GraphElement {
   protected void finalize() {
      // TODO: implement
   }
   
   public Atribute(Point2D position, Dimension2D size) {
		super(position, size);
		name = "atribute";
		type = "atribute";
		
	}

   @Override
  	public Atribute createCopy() {
  		Point2D positionCopy = new Point2D.Double(position.getX(), position.getY());
  		Dimension sizeCopy = new Dimension((int)size.getWidth(), (int)size.getHeight());
  		Atribute atributeCopy = new Atribute(positionCopy, sizeCopy);
  		atributeCopy.setName(name);
  		atributeCopy.setType(type);
  		atributeCopy.setDescription(description);
  		atributeCopy.setColor(color);
  		atributeCopy.setBorderColor(borderColor);
  		atributeCopy.setLineStyle(lineStyle);
  		atributeCopy.setLineStyleName(lineStyleName);
  		atributeCopy.setFontName(fontName);
  		atributeCopy.setFontStyle(fontStyle);
  		atributeCopy.setFontSize(fontSize);
  		atributeCopy.setFontColor(fontColor);
  		atributeCopy.setUnderline(underline);
  		atributeCopy.setShadowStyle(shadowStyle);
  		atributeCopy.setShading(shading);
  		atributeCopy.setShadow(shadow);
  		atributeCopy.setResize(resize);
  		atributeCopy.setFill(fill);
  		return atributeCopy;
  	}
	

}