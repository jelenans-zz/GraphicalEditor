/***********************************************************************
 * Module:  ResizeCommand.java
 * Author:  Sladza
 * Purpose: Defines the Class ResizeCommand
 ***********************************************************************/

package gge.command;
import java.awt.geom.Point2D;
import gge.model.*;



public class ChangeElementLinkCommand extends Command {
	
   protected GGEModel model;
   private Link link;
   private GraphElement newGraphElem;
   int brEl;
   GraphElement first;
   GraphElement second;

  
   public ChangeElementLinkCommand(GGEModel m,Link e,int br,GraphElement newGrEl ){
	   this.model = m;
	   this.link = e;
	 this.newGraphElem = newGrEl;
	 this.brEl = br;
	 first = link.getFirst();
	 second = link.getSecond();

	   
   }
   
   
   public void execute() {
	  model.changeLinkElement(link, brEl, newGraphElem);
        
   }
   
   public void undo() {
	   
	   GraphElement oldGrEl = null ;
	   if(brEl ==1)
		   oldGrEl= first;
	   if(brEl == 2)
		   oldGrEl= second;
	  model.changeLinkElement(link, brEl, oldGrEl);
   }

}