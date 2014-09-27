/***********************************************************************
 * Module:  GraphElement.java
 * Author:  Sladza
 * Purpose: Defines the Class GraphElement
 ***********************************************************************/

package gge.model;
import gge.view.ElementPainter;
import gui.PopUp;

import java.awt.BasicStroke;
import java.awt.GradientPaint;
import java.awt.event.MouseEvent;
import java.awt.geom.Dimension2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.Color;
import java.util.ArrayList;

public abstract class GraphElement extends Element {
	
	protected ArrayList<Atribute> atributi= new ArrayList<Atribute>();
	protected ArrayList<GeneralPath> linije= new ArrayList<GeneralPath>();
	protected ArrayList<ElementPainter> atributPainteri= new ArrayList<ElementPainter>();
	protected ArrayList<Point2D> connectionPoints= new ArrayList<Point2D>();
	

	

   protected Dimension2D size;
   protected String description;
   protected Dimension2D oldSize;   
   protected Point2D position;
  // protected String name;
   protected String type;
   
   protected float angle;
   protected boolean visibility;
   
   protected Color color;
   protected Color borderColor;
   protected BasicStroke lineStyle;
   protected String lineStyleName;
   protected String fontName;
   protected int fontStyle;
   protected int fontSize;
   protected Color fontColor;
   protected boolean underline;
   protected String shadowStyle;
   protected boolean shading=false;
   protected GradientPaint shadow;
   protected boolean resize=false;
   protected boolean fill;
   
   
   public GraphElement(){
		
	  
   }
   
   public String getLineStyleName() {
	return lineStyleName;
}

public void setLineStyleName(String lineStyleName) {
	this.lineStyleName = lineStyleName;
}

   //private Layer layer;		// Maja: ovo je klasa iz view paketa, a model ne bi trebalo za njega da zna. Prebacite tu klasu u ovaj paket.

   public Dimension2D getOldSize() {
	return oldSize;
}

public boolean isFill() {
	return fill;
}

public void setFill(boolean fill) {
	this.fill = fill;
}

public boolean isResize() {
	return resize;
}

public void setResize(boolean resize) {
	this.resize = resize;
}

public boolean isShading() {
	return shading;
}

public void setShading(boolean shading) {
	this.shading = shading;
}

public GradientPaint getShadow() {
	return shadow;
}

public void setShadow(GradientPaint shadow) {
	this.shadow = shadow;
}

public void setOldSize(Dimension2D oldSize) {
	this.oldSize = oldSize;
}


   
public String getFontName() {
	return fontName;
}

public void setFontName(String fontName) {
	this.fontName = fontName;
}

public int getFontStyle() {
	return fontStyle;
}

public void setFontStyle(int fontStyle) {
	
	
	this.fontStyle = fontStyle;
}

public int getFontSize() {
	return fontSize;
}

public void setFontSize(int fontSize) {
	this.fontSize = fontSize;
}

public Color getFontColor() {
	return fontColor;
}

public void setFontColor(Color fontColor) {
	this.fontColor = fontColor;
}

public boolean isUnderline() {
	return underline;
}

public void setUnderline(boolean underline) {
	this.underline = underline;
}

public String getShadowStyle() {
	return shadowStyle;
}

public void setShadowStyle(String shadowStyle) {
	this.shadowStyle = shadowStyle;
}


   public String getDescription(){
	return description;
}

public void setDescription(String description) {
	this.description = description;
}


public Color getColor() {
	return color;
}

public void setColor(Color color) {
	this.color = color;
}

public Color getBorderColor() {
	return borderColor;
}

public void setBorderColor(Color borderColor) {
	this.borderColor = borderColor;
}

public BasicStroke getLineStyle() {
	return lineStyle;
}

public void setLineStyle(BasicStroke lineStyle) {
	this.lineStyle = lineStyle;
}

public float getAngle() {
	return angle;
}

public void setAngle(float angle) {
	this.angle = angle;
}

public boolean isVisibility() {
	return visibility;
}

public void setVisibility(boolean visibility) {
	this.visibility = visibility;
}



   
   protected void finalize() {
      // TODO: implement
   }

   public Point2D getPosition() {
      return position;
   }
   
   
   public void setPosition(Point2D newPosition) {
      position = newPosition;
   }
   
   public String getName() {
      return name;
   }
   
   
   public void setName(String newName) {
      name = newName;
   }
   
   public Dimension2D getSize() {
      return size;
   }
   
  
   public void setSize(Dimension2D newSize) {
      size = newSize;
   }
   
  
   public String getType() {
		return type;
	}

   public void setType(String type) {
		this.type = type;
	}

   
   public ArrayList<GeneralPath> getLinije() {
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
	
	
   public ArrayList<Point2D> getConnectionPoints() {
		return connectionPoints;
	}

	public void setConnectionPoints(ArrayList<Point2D> connectionPoints) {
		this.connectionPoints = connectionPoints;
	}
	
	public void addConnectionPoints() {
		
		Point2D up= new Point2D.Double(position.getX()+(size.getWidth()/2),position.getY());
		Point2D left= new Point2D.Double(position.getX(),position.getY()+(size.getHeight()/2));
		Point2D down= new Point2D.Double(position.getX()+(size.getWidth()/2),position.getY()+(size.getHeight()));
		Point2D right= new Point2D.Double(position.getX()+(size.getWidth()),position.getY()+(size.getHeight()/2));
		
		connectionPoints.add(up);
		connectionPoints.add(left);
		connectionPoints.add(down);
		connectionPoints.add(right);
		
	}

public GraphElement(GraphElement oldGraphElement) {
      position = oldGraphElement.position;
      name = oldGraphElement.name;
      size = oldGraphElement.size;
      oldSize = oldGraphElement.oldSize;
      description = oldGraphElement.description;
      color= oldGraphElement.color;
      lineStyle= oldGraphElement.lineStyle;
      borderColor= oldGraphElement.borderColor;
      lineStyleName= oldGraphElement.lineStyleName;
      fontName= oldGraphElement.fontName;
      fontStyle= oldGraphElement.fontStyle;
      fontSize= oldGraphElement.fontSize;
      fontColor= oldGraphElement.fontColor;
      underline= oldGraphElement.underline;
      shadowStyle= oldGraphElement.shadowStyle;
      shading= oldGraphElement.shading;
      shadow= oldGraphElement.shadow;
      resize= oldGraphElement.resize;
      fill= oldGraphElement.fill;
      type=oldGraphElement.type;
   }
   
   public GraphElement(Point2D newPosition, Dimension2D newSize) {
	   super();
		position = newPosition;
		size = newSize;
	}
   
   
   @Override
public String toString() {
	   return name;
}

public abstract GraphElement createCopy();
/*
public void addMouseListener(PopClickListener popClickListener) {
	// TODO Auto-generated method stub
	//popClickListener = new PopClickListener();
	
}*/


}