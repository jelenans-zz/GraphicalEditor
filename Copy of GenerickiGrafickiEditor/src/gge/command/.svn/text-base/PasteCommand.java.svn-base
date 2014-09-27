
package gge.command;

import gge.model.*;
import gge.view.AtributePainter;
import gge.view.ConnectorPainter;
import gge.view.ElementPainter;
import gge.view.EntityPainter;
import gge.view.GGEView;
import gge.view.GerundPainter;
import gge.view.ISAhierarchyPainter;
import gge.view.LinkPainter;
import gge.view.WeakEntityPainter;
import gui.MainFrame;
import gui.MainFrame.Focus;

import java.awt.geom.Point2D;
import java.util.*;

import javax.swing.tree.TreePath;

public class PasteCommand extends Command {
  
	   private String type;
	   private boolean cut;
	   List<Element> copiedElements;
	   private ArrayList<String> oldNames= new ArrayList<String>();
	   private int i=0;
	   ElementPainter painter=null;
	   LinkPainter painter2=null;
   
  	   public PasteCommand(GGEView view,boolean cut){
	   
  	   this.view = view;
	   this.cut=cut;

	   copiedElements = Clipboard.getInstance().getElements(); 
  	   }
  


  
  public void execute() {


	    view.getSelection().removeAllElements();
		for (Element elem : copiedElements) 
		{
			if(elem instanceof GraphElement)
			{
		


			
		/* Trebalo bi da prilikom paste-ovanja uzmeš u obzir tekuću transformaciju radne površine, 
		 * tj. da proveriš koliko je ona skrolovana i zumirana. Možeš probati da transformišeš 
		 * početnu (0, 0) i krajnju (širina i visina) tačku GGEView panela u korisnički prostor (user space) 
		 * da bi dobila gde se on zapravo nalazi.*/
		
//			view.pointToUserSpace(new Point2D.Double(view.getLocationOnScreen().getX(), view.getLocationOnScreen().getY()));
//			view.pointToUserSpace(new Point2D.Double(view.getWidth(),view.getHeight()));
			
			double scrollX=view.getTransformation().getTranslateX();
			double scrollY=view.getTransformation().getTranslateY();
			double zoomX=view.getTransformation().getScaleX();
			double zoomY=view.getTransformation().getScaleY();
			
			
			double backX= Math.abs(scrollX)-Math.abs(((GraphElement)elem).getPosition().getX());
			double backY= Math.abs(scrollY)-Math.abs(((GraphElement)elem).getPosition().getY());
			
			((GraphElement)elem).getPosition().setLocation(((GraphElement)elem).getPosition().getX() + 20,
					((GraphElement)elem).getPosition().getY() + 20);	                       
			
//			((GraphElement)elem).getPosition().setLocation( view.getVisibleRect().getCenterX() , 
//					 										view.getVisibleRect().getCenterY());
			
			System.out.println("PASTE------------->pozicija elementa: ("+((GraphElement)elem).getPosition().getX()+","+((GraphElement)elem).getPosition().getY()+")");
			System.out.println("PASTE------------->SCROLL: ("+scrollX+","+scrollY+")");
			System.out.println("PASTE------------->ZOOM:  ("+zoomX+","+zoomY+")");
//
//			((GraphElement)elem).getPosition().setLocation(((GraphElement)elem).getPosition().getX() -scrollX, 
//															((GraphElement)elem).getPosition().getY() -scrollY);
				
			System.out.println("PASTE------------->LOCATION:  ("+((GraphElement)elem).getPosition().getX()+","+((GraphElement)elem).getPosition().getY()+")");
	
				
			oldNames.add(elem.getName());
			if(cut)
			{
				System.out.println("CUTTTT");
				elem.setName(elem.getName());
			}
			else
				elem.setName(elem.getName() + "_copy");

			 for(Element el: view.getGGEModel().getElements())
			  {
				  if((elem.getName()).equals(el.getName()))
					  elem.setName(elem.getName()+"1");
			  }
			 
			view.getGGEModel().addElement(elem);
			view.getSelection().addElements(elem);

		if(elem instanceof Atribute)
			painter = new AtributePainter((GraphElement)elem);
		if(elem instanceof Entity)
			painter = new EntityPainter((GraphElement)elem);
		if(elem instanceof ISAhierarchy)
			painter = new ISAhierarchyPainter((GraphElement)elem);
		if(elem instanceof WeakEntity)
			painter = new WeakEntityPainter((GraphElement)elem);
		if(elem instanceof Gerund)
			painter = new GerundPainter((GraphElement)elem);
		if(elem instanceof Connector)
			painter = new ConnectorPainter((GraphElement)elem);
		
		view.elementPainters.add(painter);
			}
			else
			{
				Link link= (Link)elem;
				if(link instanceof Link)
					painter2 = new LinkPainter(link);
				view.linkPainters.add(painter2);
			}

		
		if (MainFrame.focus== Focus.Tree)
		{
			if(MainFrame.getInstance().getTree().getSelected() instanceof GGEModel)
			{
				 GGEModel diagram=  (GGEModel)MainFrame.getInstance().getTree().getSelected();
				 Workspace workspace= MainFrame.getInstance().getWorkspace();
				 Project project = null;	 
				 
				 outerloop:
					   for(Project p: workspace.getProjects())
					   {
						   ArrayList<GGEModel> dijagrami= p.getGGEModel();
						   for(GGEModel m: dijagrami)
						   {
							   if(m.equals(diagram))
							   {
								   project=p;
								   break outerloop;
							   }

						   }
					   }
					Object[] pathToDiagram = new Object[4];
					pathToDiagram[0] = workspace;
					pathToDiagram[1] = project;
					pathToDiagram[2] = diagram;
					pathToDiagram[3] = elem;
					MainFrame.getInstance().getTree().makeVisible(new TreePath(pathToDiagram));
			}
			}	

	    }
  }
  
  public void undo() {

	  
	  for (Element elem : copiedElements) {
		    elem.setName(oldNames.get(i));
		    i++;
			view.getGGEModel().removeElement(elem);
			view.getSelection().removeElements(elem);
			view.getElementPainters().remove(view.getElementPainter((GraphElement)elem));
		
	  }
	   
  }

}