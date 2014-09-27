/***********************************************************************
 * Module:  ResizeCommand.java
 * Author:  Sladza
 * Purpose: Defines the Class ResizeCommand
 ***********************************************************************/

package gge.command;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.BREAKPOINT;

import gge.model.*;
import gge.view.GGEView;



public class MoveLineInLinkCommand extends Command {
	
   protected GGEModel model;
   private Link link;
   private Point2D bp1;
   private Point2D bp2;
   double moveByX;
   double moveByY;
   private GGEView  view;
 
   List<Element> elements;
   Point2D vector ;
   Point2D minusVector;

  
   public MoveLineInLinkCommand(GGEView v ,GGEModel m,Link l,Point2D bp1,Point2D bp2,double moveByX,double moveByY , List<Element> list){
	 this.model = m;
	 this.link = l;
	 this.moveByX = moveByX;
	 this.moveByY = moveByY;
	 this.bp1 = bp1;
	 this.bp2 = bp2;
	 //this.ge = g;
	 elements = new ArrayList<Element>(list);
	// elements.add(ge);
	 vector = new Point2D.Double(moveByX, moveByY);
	 minusVector = new Point2D.Double(-moveByX, -moveByY);
	 this.view = v;
	   
   }
   
   
   public void execute() {
	   if(!elements.isEmpty()){
			  model.moveElements(elements, vector);
			  view.getElementPainter((GraphElement)elements.get(0)).moveElementTransformation(moveByX, moveByY);
		  }
	  model.moveTwoPoints(link, bp1,bp2, moveByX,moveByY);
	 
	 
        
   }
   
   public void undo() {
	   if(!elements.isEmpty()){
			  model.moveElements(elements, minusVector);
			  view.getElementPainter((GraphElement)elements.get(0)).moveElementTransformation(-moveByX, -moveByY);
		  }
	   model.moveTwoPoints(link, bp1,bp2, -moveByX,-moveByY);
	   
   }

}