/***********************************************************************
 * Module:  ResizeCommand.java
 * Author:  Sladza
 * Purpose: Defines the Class ResizeCommand
 ***********************************************************************/

package gge.command;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import gge.view.Painter;
import gge.model.*;
import gge.view.ElementPainter;



public class ResizeCommand extends Command {
	
   //private List<GraphElement> elements;
   private GraphElement element; 
   protected GGEModel model;
   private Point2D newPosition;
   private Dimension2D newSize;
   private Painter painter;
   private Dimension2D staraVelicina; //pamtim za undo
   private Point2D staraPozicija;  //pamti ya undo
   private double translateX;
   private double translateY;
  
   public ResizeCommand(GGEModel model,GraphElement e, Painter p,Point2D position,Dimension2D size,double translateX,double translateY){
	   this.element = e;
	   this.model = model;
	   this.newPosition = position;
	   this.newSize = size;
	   this.painter = p;
	   staraVelicina = e.getSize();
	   staraPozicija = e.getPosition();
	   this.translateX = translateX;
	   this.translateY = translateY;
	   
   }
   
   
   public void execute() {
	  model.resizeElement(element, newPosition, newSize);
      ((ElementPainter) painter).resizeElementTransformation(newSize.getWidth()/staraVelicina.getWidth(), newSize.getHeight()/staraVelicina.getHeight(),translateX,translateY);
      
     
   }
   
   public void undo() {
	  model.resizeElement(element, staraPozicija, staraVelicina);
	  ((ElementPainter) painter).resizeElementTransformation(staraVelicina.getWidth()/newSize.getWidth(), staraVelicina.getHeight()/newSize.getHeight(),-translateX,-translateY);
     
   }

}