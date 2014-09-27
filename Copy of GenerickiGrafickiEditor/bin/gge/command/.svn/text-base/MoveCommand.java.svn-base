/***********************************************************************
 * Module:  MoveCommand.java
 * Author:  Sladza
 * Purpose: Defines the Class MoveCommand
 ***********************************************************************/

package gge.command;

import gge.model.*;
import gge.view.ElementPainter;
import gge.view.GGEView;
import gge.view.SelectionHandleHandler;
import gge.view.SelectionModel;

import java.awt.geom.Point2D;
import java.util.*;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

public class MoveCommand extends Command {
   private double moveByX;
   private double moveByY;
   private List<Element> elements;
   protected GGEModel model;
   private ElementPainter painter;
   private Point2D position;
   private int xPos,yPos;
   public MoveCommand(GGEView view,double moveByX,double moveByY) {
	super();
	this.moveByX = moveByX;
	this.moveByY = moveByY;
	this.elements=new ArrayList<Element>(view.getSelection().getElements());
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
	  view.getGGEModel().moveElements(elements, new Point2D.Double(moveByX,moveByY));
	  
	  for(Element grElem: elements){
		  if(grElem instanceof GraphElement){
			  if(grElem instanceof Entity|| grElem instanceof Gerund || grElem instanceof Connector || 
					  grElem instanceof WeakEntity||grElem instanceof ISAhierarchy){
				  ArrayList<Atribute> atributes=((GraphElement) grElem).getAtributi();
				  if(atributes.size()!=0){
				  for(Atribute a: atributes){
					  position= a.getPosition();
					  xPos=(int) (position.getX()+moveByX);
					  yPos=(int) (position.getY()+moveByY);
					  a.setPosition(new Point2D.Double(xPos,yPos));
					  view.getElementPainter(a).moveElementTransformation(moveByX, moveByY);
				  }
				  }else {
					  System.err.println();
				  }
			  }
			
			  view.getElementPainter((GraphElement)grElem).moveElementTransformation(moveByX, moveByY);
		  }else if(grElem instanceof Link){
			
			  view.getLinkPainter((Link)grElem).moveElementTransformation(moveByX, moveByY);
		  }
	  }
	  
	  
	  model.fireUpdates();
   }
   
   public void undo() {
      // TODO: implement
	   model.moveElements(elements, new Point2D.Double(-moveByX,-moveByY));
	 
	   for(Element grElem: elements){
		   if(grElem instanceof GraphElement){
				  if(grElem instanceof Entity|| grElem instanceof Gerund || grElem instanceof Connector || 
						  grElem instanceof WeakEntity||grElem instanceof ISAhierarchy){
					  ArrayList<Atribute> atributes=((GraphElement) grElem).getAtributi();
					  if(atributes.size()!=0){
					  for(Atribute a: atributes){
						  position= a.getPosition();
						  xPos=(int) (position.getX()-moveByX);
						  yPos=(int) (position.getY()-moveByY);
						  a.setPosition(new Point2D.Double(xPos,yPos));
						  view.getElementPainter(a).moveElementTransformation(-moveByX, -moveByY);
					  }
					  }
				  }
				
				  view.getElementPainter((GraphElement)grElem).moveElementTransformation(-moveByX, -moveByY);
			  }else if(grElem instanceof Link){
				
				  view.getLinkPainter((Link)grElem).moveElementTransformation(-moveByX, -moveByY);
			  }
	   model.fireUpdates();
   }
   }
}