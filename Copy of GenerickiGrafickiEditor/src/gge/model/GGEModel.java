/***********************************************************************
 * Module:  GGEModel.java
 * Author:  Sladza
 * Purpose: Defines the Class GGEModel
 ***********************************************************************/

package gge.model;


import gge.view.GGEView;
import gui.ElementProperties;
import gui.MainFrame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.*;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;




public class GGEModel extends Observable {
	
   private String name;
   private String author;
   private String description;
   protected  ArrayList<Element> elements;
   private boolean sacuvano;

public GGEModel() {
	   elements= new ArrayList<Element>();
	
   }
   public void fireUpdates(){
	   notifyObservers();
	   setChanged();
	   sacuvano = false; 
   }
   
   public GGEModel(String string) {
	   elements= new ArrayList<Element>();
	   name= string;
}


   protected void finalize() {
      // TODO: implement
   }
   
   public boolean isSacuvano(boolean arg) {
		return sacuvano;
	}
	public void setSacuvano(boolean sacuvano) {
		this.sacuvano = sacuvano;
	} 
   public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getAuthor() {
	return author;
}

public void setAuthor(String author) {
	this.author = author;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public void setElements(ArrayList<Element> elements) {
	this.elements = elements;
}

public void paint(Graphics g) {
      // TODO: implement
   }
   
public void moveElements(List<Element> elements2, Point2D moveByVector) {
	Iterator<Element> iter = elements2.iterator();
	while (iter.hasNext()) {
		Element elem=iter.next();
		if(elem instanceof GraphElement){
			GraphElement element = (GraphElement)elem;
			
			if (elements.contains(element)) {
				
				for(Element el : elements)
					if(el.equals(element)){
						
						Point2D newElementPosition = new Point2D.Double(
								element.getPosition().getX() + moveByVector.getX(),
								element.getPosition().getY() + moveByVector.getY());
						element.setPosition(newElementPosition);
				
					}
				
			}
		}
		if(elem instanceof Link){
			
			GraphElement prvi=((Link) elem).getFirst();
			GraphElement drugi=((Link) elem).getSecond();
			
			if(elements.contains(prvi)&&elements.contains(drugi)){
				
					ArrayList<Point2D> connPoints=(ArrayList<Point2D>) ((Link) elem).getBreakPoints();
					for(Point2D point: connPoints){
						//Point2D newLocation=point;
					double x=point.getX()+moveByVector.getX();
						double y=point.getY()+moveByVector.getY();
						
						point.setLocation(x, y);
					
						
					}
				
				
			}
		}
			
	}
	
	fireUpdates();
}

public void moveElementsForCanvas(GGEView view, Point2D moveByVector) {
	Iterator<Element> iter = view.getGGEModel().getElements().iterator();
	while (iter.hasNext()) {
		Element el=iter.next();
		if(el instanceof Link){
			Link element=(Link)el;
			if(elements.contains(element)){
				ArrayList<Point2D> connPoints=(ArrayList<Point2D>) ((Link) element).getBreakPoints();
				for(Point2D point: connPoints){
					point.setLocation(point.getX()+moveByVector.getX(), point.getY()+moveByVector.getY());
				}
			}
		}else{
			GraphElement element = (GraphElement)el;
			if (elements.contains(element)) {
				Point2D newElementPosition = new Point2D.Double(
						element.getPosition().getX()+moveByVector.getX(),
						element.getPosition().getY() + moveByVector.getY());
				element.setPosition(newElementPosition);
				view.getElementPainter(element).moveElementTransformation(moveByVector.getX(),
						 moveByVector.getY());
			}
		}
	}
//ubrzava zbog ovog element.getPos.getX/Y
	fireUpdates();
}
   
   public int select() {
      // TODO: implement
      return 0;
   }
	   
	 
	 
	   public void changeColor(List<GraphElement> elements, Color color) {
	      // TODO: implement
	   }
	   
	  
	   public void rename(String newName) {
	      // TODO: implement
	   }
	   
	   
	   public void copyElement(List<GraphElement> elements) {
	      // TODO: implement
	   }
	   
	   public void paste() {
	      // TODO: implement
	   }
	   
	  
	   public void cutElement(List<GraphElement> elements) {
	      // TODO: implement
	   }
	   
	   
   
   public java.util.List<Element> getElements() {	
      if (elements == null)
         elements = new java.util.ArrayList<Element>();
      return elements;
   }
   
   
   public void setElementProperties(
		   GraphElement el, String newName,String lineWidth, String lineStyle, 
		   Color borderColor, boolean fill, 
		   Color fillColor,boolean gradient, double width, 
		   double height, String fontName, String fontStyle, 
		   String fontSize ,Color fontColor, boolean underline,
		   ElementProperties.ShadowStyle stil, Color shadowColor, Color shadowColor2){
	   
	   el.setName(newName);
	   el.setOldSize(el.getSize());
	   el.setSize(new Dimension((int)width, (int)height));
	   if(!((el.getSize()).equals(el.getOldSize())))
	   {	  
		   resizeElement(el, new Point2D.Double(el.getPosition().getX(),el.getPosition().getY()), 
			   		new Dimension((int)width, (int)height));
	   } 
	   
	   el.setBorderColor(borderColor);
	   
	   if(fill)
	   {
		   el.setFill(true);
		   el.setColor(fillColor);
	   }

	   
	   double x=el.getSize().getWidth();
	   double rastojanje= x/2;
	   if(gradient)
	   {
		   el.setShading(true);
		   el.setShadow(new GradientPaint(
				   new Point2D.Double(el.getPosition().getX(),  el.getPosition().getY()), 
				   shadowColor,  
				   new Point2D.Double(el.getPosition().getX()+rastojanje,  el.getPosition().getY()), 
				   shadowColor2, true));

	   }

	   
	   el.setFontColor(fontColor);
	   el.setFontSize(Integer.parseInt(fontSize));
	   
	   int stilFonta=0;
	   

	   if(fontStyle.equals("Bold"))
		   stilFonta= Font.BOLD;	
	   else if(fontStyle.equals("Italic"))
		   stilFonta= Font.ITALIC;
	   else if(fontStyle.equals("Bold Italic"))
		   stilFonta= Font.BOLD+Font.ITALIC;
	   else
		   stilFonta=0;
	     
	   el.setFontName(fontName);
	   el.setFontStyle(stilFonta);
	   el.setUnderline(underline);
	   
	   
	   if(lineStyle.equals("________"))
	   {
			   el.setLineStyle(new BasicStroke(Float.parseFloat(lineWidth),
					   							BasicStroke.CAP_ROUND,
					   							BasicStroke.JOIN_ROUND,
					   							5,
					   							null,
					   							0));
			   el.setLineStyleName("puna");
	   }
	   else if(lineStyle.equals("--------------"))
	   {
		   	 el.setLineStyle(new BasicStroke(Float.parseFloat(lineWidth),
												BasicStroke.CAP_ROUND,
												BasicStroke.JOIN_ROUND,
												5,
												new float[] {6,6},
												3));
		   	 el.setLineStyleName("isprekidana");
	   }


	   notifyObservers();

   }

  
   public void addElement(Element elem) {
	   if (elem == null)
	         return;
	      if (this.elements == null)
	         this.elements = new ArrayList<Element>();
	    
	      if (!this.elements.contains(elem)){
	    	  if(elem instanceof GraphElement)
	    	  {
	        	 this.elements.add((GraphElement)elem);
	        	 
	    	  } else if(elem instanceof Link)
	    	  {
	    		  this.elements.add((Link)elem);
	    	  }
	    
	       
	         fireUpdates();
	      }
	     
   }

  
  
   public void removeElement(Element oldGraphElement) {
      if (oldGraphElement == null)
         return;
      if (this.elements != null)
         if (this.elements.contains(oldGraphElement)){
            this.elements.remove(oldGraphElement);
           // System.out.println("obrisan");
            fireUpdates();
         }
      
   }
   
   
  
   public void removeAllElements() {
      if (elements != null)
         elements.clear();
   }
   public Element getElement(int index) {
	   return elements.get(index);
   }

public int getElementCount() {
	int brEl= elements.size();
	return brEl;
}

public int getElementIndex(Element child) {
	
	if (elements.contains(child))
		return elements.indexOf(child);
	return -1;
}   

@Override
public String toString() {
	return name;
}
public Iterator<Element> getIteratorElements() {
	if (elements == null)
		elements = new ArrayList<Element>();
	return elements.iterator();
}


public void resizeElement(GraphElement selectedElement, Point2D position,
		Dimension2D velicina) 
{
	for(Element g: elements)
	{
		
		if(((GraphElement)g).equals(selectedElement)){
			((GraphElement)g).setPosition(position);
			((GraphElement)g).setSize(velicina);
			break;
		
		}
	}
	fireUpdates();
	
}

public GGEModel createCopy() {
	
	GGEModel diagramCopy = new GGEModel();
	ArrayList<Element> elementsCopy = new ArrayList<Element>();
	diagramCopy.setName(name);
	diagramCopy.setAuthor(author);
	diagramCopy.setDescription(description);

	for (Element elem : elements) {
		elementsCopy.add(elem.createCopy());
	}
	diagramCopy.setElements(elementsCopy);
	diagramCopy.addObserver(MainFrame.getInstance().getTree());	
	return diagramCopy;
}
public void changeConnectionPoint(Element link,
		Point2D oldConnectionPoint, Point2D newConnectionPoint) {	 
		 	        List<Point2D> listaTacaka;
		 	        for(Element g: elements){
		 	                if(g.equals(link)){
		 	                        listaTacaka = ((Link)g).getBreakPoints();
		 	                        for(int i=0;i<listaTacaka.size();i++){
		 	                                if(listaTacaka.get(i).getX()==oldConnectionPoint.getX()&& listaTacaka.get(i).getY() == oldConnectionPoint.getY()){
		 	                                        listaTacaka.set(i, newConnectionPoint);
		 	                                        break;
		 	                                }
		 	                                       
		 	                        }
		 	                        ((Link)g).setBreakPoints(listaTacaka);
		 	                        fireUpdates();
		 	                }
		 	               
		 	        }
		 	     
	
}
public void changeLinkElement(Link link, int i, GraphElement elem) { // i = 1 za prvi 2 za drugi
if(elem!=null){
	for(Element el:elements){
		if(el instanceof Link)
		if(el.equals(link)){
			if(i==1)
				((Link)el).setFirst(elem);	
		if(i==2)
			((Link)el).setSecond(elem);
		fireUpdates();
		break;
		}
	}
}
}
public void moveTwoPoints(Link link, Point2D bp1, Point2D bp2, double moveByX,
		double moveByY) {
	for(Element el : elements){
		if(el instanceof Link){
			if(el.equals(link)){
				List<Point2D> breakpoints = ((Link) el).getBreakPoints();
				for(Point2D bp:breakpoints){
					if(bp == bp1)
						bp.setLocation(bp.getX()+moveByX, bp.getY() + moveByY);
					else if(bp == bp2)
						bp.setLocation(bp.getX()+moveByX, bp.getY() + moveByY);
					
				}
				((Link) el).setBreakPoints(breakpoints);
				if(link.getPocetnaTacka() == bp1 || link.getPocetnaTacka()==bp2 )
					link.setPocetnaTacka(new Point2D.Double(link.getPocetnaTacka().getX()+moveByX, link.getPocetnaTacka().getY() + moveByY));
				if(link.getKrajnjaTacka() == bp1 || link.getKrajnjaTacka()==bp2 )
					link.setKrajnjaTacka(new Point2D.Double(link.getKrajnjaTacka().getX()+moveByX, link.getKrajnjaTacka().getY() + moveByY));
				
				fireUpdates();
			}
		}
	}
	
}
}