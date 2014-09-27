/***********************************************************************
 * Module:  EllipsePainter.java
 * Author:  Sladza
 * Purpose: Defines the Class EllipsePainter
 ***********************************************************************/

package gge.view;

import gge.model.Element;

import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public abstract  class Painter{
	protected Shape shape;
	protected AffineTransform elementTransformation = new AffineTransform();
	
   
   abstract void paint(Graphics2D g2);
   
   public AffineTransform getElementTransformation() {
	return elementTransformation;
}

public Boolean isElementIn(Rectangle2D rct2D) {
      // TODO: implement
      //
      return null;
   }


public abstract void moveElementTransformation(double xPos, double yPos);

public abstract Element getElement();

public abstract Boolean isElementAt(Point2D p2);

public abstract boolean isElementAtX(int x);
}