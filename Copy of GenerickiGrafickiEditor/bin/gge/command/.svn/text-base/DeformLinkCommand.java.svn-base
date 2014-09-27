/***********************************************************************
 * Module:  ResizeCommand.java
 * Author:  Sladza
 * Purpose: Defines the Class ResizeCommand
 ***********************************************************************/

package gge.command;
import java.awt.geom.Point2D;
import gge.model.*;
import gge.view.LinkPainter;



public class DeformLinkCommand extends Command {
	
   private Link element; 
   protected GGEModel model;
   private Point2D newPosition;
   private Point2D oldPosition; 
   


  
   public DeformLinkCommand(GGEModel m,Link e,Point2D oldPosition,Point2D newPosition){
	   this.model = m;
	   this.element = e;
	   this.oldPosition = oldPosition;
	   this.newPosition = newPosition;

	   
   }
   
   
   public void execute() {
	  model.changeConnectionPoint(element, oldPosition, newPosition);
        
   }
   
   public void undo() {
	  model.changeConnectionPoint(element, newPosition, oldPosition);
   }

}