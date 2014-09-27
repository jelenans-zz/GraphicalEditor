/***********************************************************************
 * Module:  DeleteElementCommand.java
 * Author:  Sladza
 * Purpose: Defines the Class DeleteElementCommand
 ***********************************************************************/

package gge.command;

import gge.model.*;
import gge.view.ElementPainter;
import gge.view.GGEView;
import gge.view.LinkPainter;
import gge.view.Painter;
import java.util.*;



public class DeleteElementCommand extends Command {
	
    
    protected GGEModel model; 
    private List<Painter> painters;    
    protected GGEView view;
    private List<Element> selectedElements;
    private List<LinkPainter> vezeZaBrisanje;
   
    
   	   public DeleteElementCommand(GGEModel model,GGEView view,List<Element> selectedElements, List<Painter> painters,ArrayList<LinkPainter> veze){
	   this.model = model;
	   this.view = view;
	   this.painters = painters;
	   this.selectedElements = new ArrayList<Element>(selectedElements);
	   vezeZaBrisanje = new ArrayList<LinkPainter>(veze);
	   
   }
   

 
   
   public void execute() {
	   int kkk=0;
	   for(Painter p: painters){
		   if(p instanceof ElementPainter)
			      view.removeElementPainters((ElementPainter)p);
			   else 
				   view.removeLinkPainters((LinkPainter)p);		  
	   }
	   
	   //izbrisi paintere veza
	   for(LinkPainter p : vezeZaBrisanje) {
		   if(view.getLinkPainters().contains(p))
			   view.removeLinkPainters(p);
	   }
	   
	   for(Element e: selectedElements){
		   if(e instanceof Entity || e instanceof Connector || e instanceof WeakEntity || e instanceof Gerund)
		   {
			   ArrayList<ElementPainter> elPainteri= ((GraphElement)e).getAtributPainteri();
			   
			   int i=0;
			   for(Painter p: elPainteri){			   
				   if(view.getElementPainters().contains(p))
					      view.removeElementPainters((ElementPainter)p);  
				   if(model.getElements().contains(((GraphElement)e).getAtributi().get(i)))
					   model.removeElement(((GraphElement)e).getAtributi().get(i));
				   i++;
			   }
			   

			   ((GraphElement)e).getAtributi().clear();
		   } else if(e instanceof Atribute)
		   {
			  e=(Atribute)e;
			  
			  for(Element el: view.getGGEModel().getElements())
			  {
				   if(el instanceof Entity || el instanceof Connector || el instanceof WeakEntity || el instanceof Gerund)
				  {
					  el= (GraphElement)el;
					  if(((GraphElement) el).getAtributi().contains(e))
					  {
						  int ind= ((GraphElement) el).getAtributi().indexOf(e);
						  ((GraphElement) el).getLinije().remove(ind);
					  }
				  }
			  }
		   }
		   System.out.println("el za brisanje "+kkk+" "+e.getName());
		   kkk++;
		   model.removeElement((Element)e);
	   }
	   //izbrisi iz modela tu vezu 
	   for(LinkPainter p : vezeZaBrisanje) {
		   if(model.getElements().contains(p.getElement()))
			   model.removeElement((Link)p.getElement());
	   }

	   
		
		view.getSelection().removeAllElements();
		
   }
   
   public void undo() {
	 for(Element e: selectedElements)
		 if(e instanceof GraphElement)
			 model.addElement(e);
	     else
	    	 model.addElement(e);
			 
			   //dodaj paintere veza
			   for(LinkPainter p : vezeZaBrisanje) {
				   if(!view.getLinkPainters().contains(p))
					   view.addLinkPainters(p);
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