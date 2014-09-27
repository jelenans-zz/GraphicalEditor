/***********************************************************************
 * Module:  MoveCommand.java
 * Author:  Sladza
 * Purpose: Defines the Class MoveCommand
 ***********************************************************************/

package gge.command;

import gge.model.Element;
import gge.model.GGEModel;
import gge.model.GraphElement;
import gge.model.Link;
import gge.view.ElementPainter;
import gge.view.GGEView;
import gge.view.SelectionModel;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hamcrest.core.IsInstanceOf;

public class MoveCanvaCommand extends Command {
   private double moveByX;
   private double moveByY;
   private List<Element> elements;
   protected GGEModel model;
   private Point2D position;
   private int xPos,yPos;
   ArrayList<Point2D> connPoints;
   private Point2D posKrajnjaT;
   private Point2D posPocetnaT;
   private int xKrajnje,yKrajnje;
   private int xPocetno,yPocetno;
   
   public MoveCanvaCommand(GGEView view,double moveByX,double moveByY) {
	super();
	this.moveByX = moveByX;
	this.moveByY = moveByY;
	this.elements=new ArrayList<Element>(view.getSelection().getElements());
	connPoints=new ArrayList<Point2D>();
	this.model = view.getGGEModel();
	this.view=view;
	
}

/** @pdGenerated default parent getter */
   public GGEModel getModel() {
      return model;
   }
   
   /** @pdGenerated default parent setter
     * @param newGGEModel */
   public void setModel(GGEModel newGGEModel) {
      this.model = newGGEModel;
   }
   
   public void execute() {
      // TODO: implement
	   view.getGGEModel().moveElementsForCanvas(view, new Point2D.Double(moveByX,moveByY));
		
	   Iterator<Element> iter = view.getGGEModel().getElements().iterator();
		while (iter.hasNext()) {
			Element el=iter.next();
			if(el instanceof GraphElement){
			GraphElement element = (GraphElement)el;
			if (elements.contains(element)) {
				  
				view.getElementPainter(element).moveElementTransformation(moveByX,moveByY);
			}
			}else if(el instanceof Link){
				Link element = (Link)el;
				if (elements.contains(element)) {
					  
					view.getLinkPainter(element).moveElementTransformation(moveByX,moveByY);
				}	
			}
		}
	  model.fireUpdates();
   }
   
   public void undo() {
      // TODO: implement
	  model.moveElementsForCanvas(view, new Point2D.Double(-moveByX,-moveByY));
	  Iterator<Element> iter = view.getGGEModel().getElements().iterator();
		while (iter.hasNext()) {
			if(iter.next() instanceof GraphElement){
			GraphElement element = (GraphElement)iter.next();
			if (elements.contains(element)) {
				  
				view.getElementPainter(element).moveElementTransformation(-moveByX,-moveByY);
			}
			}else{
				Link element = (Link)iter.next();
				if (elements.contains(element)) {
					  
					view.getLinkPainter(element).moveElementTransformation(-moveByX,-moveByY);
				}	
			}
		}
	   model.fireUpdates();
   }

}