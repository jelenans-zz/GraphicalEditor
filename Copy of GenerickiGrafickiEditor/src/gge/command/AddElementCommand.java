/***********************************************************************
 * Module:  AddElementCommand.java
 * Author:  Sladza
 * Purpose: Defines the Class AddElementCommand
 ***********************************************************************/

package gge.command;

import java.util.ArrayList;

import javax.swing.tree.TreePath;

import gge.model.*;
import gge.view.ElementPainter;
import gge.view.GGEView;
import gge.view.LinkPainter;
import gge.view.Painter;
import gui.MainFrame;


public class AddElementCommand extends Command {
   private Element element;
   private Painter painter;
   protected GGEModel model;
   protected GGEView view;
   
   public AddElementCommand(GGEModel model,GGEView view,Element e,Painter painter){
	   this.element = e;
	   this.model = model;
	   this.view = view;
	   this.painter = painter;
   }
   
  
   
   public void execute() {
	   
	   model.addElement(element);
	   
      if(element instanceof GraphElement){
    	  
	      view.addElementPainters((ElementPainter)painter);
      }
      else 
      {
    	  view.addLinkPainters((LinkPainter)painter);
      }

	   Workspace workspace= MainFrame.getInstance().getWorkspace();
	   Project project = null;
	   outerloop:
	   for(Project p: workspace.getProjects())
	   {
		   ArrayList<GGEModel> dijagrami= p.getGGEModel();
		   for(GGEModel m: dijagrami)
		   {
			   if(m.equals(model))
			   {
				   project=p;
				   break outerloop;
			   }

		   }
	   }


	   if(element!=null)
	   {
	    Object[] pathToDiagram = new Object[4];
		pathToDiagram[0] = workspace;
		pathToDiagram[1] = project;
		pathToDiagram[2] = model;
		pathToDiagram[3] = element;
		MainFrame.getInstance().getTree().makeVisible(new TreePath(pathToDiagram));
	   }
   }
   
   public void undo() {
     
	 
	   if(element instanceof GraphElement){
		   model.removeElement((GraphElement)element);
		   view.removeElementPainters((ElementPainter)painter);
	      }
	      else 
	      {
	    	  model.removeElement((Link)element);
	    	  view.removeLinkPainters((LinkPainter)painter);
	      }
	   
   }

}