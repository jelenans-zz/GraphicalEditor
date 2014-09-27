package gge.model;

import gge.view.ElementPainter;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class Connector extends GraphElement {


	@Override
	protected void finalize() {
		// TODO Auto-generated method stub
		super.finalize();
	}

	public Connector(Point2D newPosition, Dimension2D newSize) {
		super(newPosition, newSize);
		name = "connector";
		type = "connector";

	}
	



	   @Override
	  	public Connector createCopy() {
	  		Point2D positionCopy = new Point2D.Double(position.getX(), position.getY());
	  		Dimension sizeCopy = new Dimension((int)size.getWidth(), (int)size.getHeight());
	  		Connector ellipseCopy = new Connector(positionCopy, sizeCopy);
	  		ellipseCopy.setName(name);
	  		ellipseCopy.setType(type);	  		
	  		ellipseCopy.setDescription(description);
	  		ellipseCopy.setColor(color);
	  		ellipseCopy.setBorderColor(borderColor);
	  		ellipseCopy.setLineStyle(lineStyle);
	  		ellipseCopy.setLineStyleName(lineStyleName);
	  		ellipseCopy.setFontName(fontName);
	  		ellipseCopy.setFontStyle(fontStyle);
	  		ellipseCopy.setFontSize(fontSize);
	  		ellipseCopy.setFontColor(fontColor);
	  		ellipseCopy.setUnderline(underline);
	  		ellipseCopy.setShadowStyle(shadowStyle);
	  		ellipseCopy.setShading(shading);
	  		ellipseCopy.setShadow(shadow);
	  		ellipseCopy.setResize(resize);
	  		ellipseCopy.setFill(fill);
	  		ellipseCopy.setAtributi(atributi);
	  		ellipseCopy.setConnectionPoints(connectionPoints);
	  		return ellipseCopy;
	  	}
	

}
