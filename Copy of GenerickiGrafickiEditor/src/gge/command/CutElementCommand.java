/***********************************************************************
 * Module:  CutElementCommand.java
 * Author:  Sladza
 * Purpose: Defines the Class CutElementCommand
 ***********************************************************************/

package gge.command;

import gge.model.*;
import gge.state.SelectElementState;
import gge.view.ElementPainter;
import gge.view.GGEView;
import gge.view.LinkPainter;
import gge.view.Painter;
import gui.MainFrame;

import java.util.*;

import javax.swing.tree.TreePath;

public class CutElementCommand extends Command {
	

    protected GGEModel model; 
    private List<Painter> painters;    
    protected GGEView view;
    private List<Element> selectedElements;
    private List<LinkPainter> vezeZaBrisanje;
   
   public CutElementCommand(GGEModel model,GGEView view,List<Element> selectedElements, List<Painter> painters,ArrayList<LinkPainter> veze){
	   this.model = model;
	   this.view = view;
	   this.painters = painters;
	   this.selectedElements = new ArrayList<Element>(selectedElements);
	   vezeZaBrisanje = new ArrayList<LinkPainter>(veze);
	   
   }
   
  
   public void execute() {
		SelectElementState.cut=true;
	   
	   Clipboard.getInstance().putElements(view.getSelection().getElements());
	   ArrayList<Painter> painteri =view.selectedElementsPainters();
		
	  
		
			
		for (Painter elPainter : painters) {
			if(elPainter instanceof ElementPainter){
				model.removeElement((GraphElement)elPainter.getElement());
			    view.removeElementPainters((ElementPainter)elPainter);
			}
			else {
				model.removeElement(elPainter.getElement());
				view.removeLinkPainters((LinkPainter)elPainter);
			}
		}
		view.getSelection().removeAllElements();
		view.repaint();
   }
   
   public void undo() {
	   
		SelectElementState.cut=false;
	   
	   System.out.println("UNDOO");
	   if(selectedElements.size()==0)
		   System.out.println("NIIIIC");
	   for(Element e: selectedElements)
	   {
		   System.out.println("IME EL: "+e.getName());
			 if(e instanceof GraphElement)
				 model.addElement(e);
		     else
		    	 model.addElement(e);
				 
				   //dodaj paintere veza
				   for(LinkPainter p : vezeZaBrisanje) {
					   if(!view.getLinkPainters().contains(p))
						   view.addLinkPainters(p);
				   }
	   }
		 for(Painter p: painters)	 
			 if(p instanceof ElementPainter)
				   view.addElementPainters((ElementPainter)p);
				   else 
					   view.addLinkPainters((LinkPainter)p);
		   
				   //dodaj u model tu vezu 
				   for(LinkPainter p : vezeZaBrisanje) {
					   if(!model.getElements().contains(p.getElement()))
						   model.addElement(p.getElement());
				   }
   }

}