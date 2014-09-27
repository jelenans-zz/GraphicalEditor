
package gge.state;

import gge.command.AddElementCommand;
import gge.model.Element;
import gge.model.GraphElement;
import gge.model.Link;
import gge.state.StateManager.States;
import gge.view.GGEView;
import gge.view.LinkPainter;
import gui.MainFrame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;


public class ConnectElementsState extends State {
	
	GGEView view;
	GraphElement currentElement;
	GraphElement secondElement;	
	public static GeneralPath link;
	public static Point2D lastPosition;	
	Point2D oldPosition;
	Point2D currentPosition;
	Point2D aaaaa;
	boolean pocetak;
	boolean kraj;
	Point2D poslednjaTacka;



	public static Link veza ;
	public static ArrayList<GeneralPath> links;
	public static int ddd=0;

	
   public ConnectElementsState(GGEView view) {
		this.view=view;	
		pocetak=false;
		kraj=false;

	}

/** @param e */
   public void mouseClicked(MouseEvent e) {
      // TODO: implement
   }
   
   /** @param e */
   public void mouseReleased(MouseEvent e) {

	     lastPosition= e.getPoint();
	     LinkPainter.comparePoint= new Point2D.Double(lastPosition.getX(), lastPosition.getY());
	     
		 view.pointToUserSpace(lastPosition);
	     oldPosition=lastPosition;
	   
	    
	     if(view.getElementAtPosition(lastPosition)!=null && !(view.getElementAtPosition(lastPosition) instanceof Link))
	    	 secondElement= (GraphElement) view.getElementAtPosition(lastPosition);

	   
	     if(!kraj)
	     {
	    	 if(links!=null){
	    	 links.add(link);
	    	 aaaaa= link.getCurrentPoint();
	    	 }
	     } 
	     
		 if(secondElement!=null)
		 {
			if(!(veza.getFirst()).equals(secondElement))
			{
				
			System.out.println("SECOND EL: "+"X: "+lastPosition.getX()+"Y: "+lastPosition.getY());
			 veza.setSecond(secondElement);
			 kraj=true;
		
			 //view.getGGEModel().addLink(veza);
			 String naziv = generateName();
			 veza.setName(naziv);
			 view.getCommandManager().executeCommand(new AddElementCommand(view.getGGEModel(), view, veza, new LinkPainter(veza)));
			
			 links.clear();
			 secondElement=null;
			// view.linkPainters.add(new LinkPainter(veza));
			}
			else
				return;
		 } else
		 {
			if(e.getButton()==MouseEvent.BUTTON1) 
			{		
				
				poslednjaTacka = link.getCurrentPoint();
				veza.getBreakPoints().add(poslednjaTacka);
			}
			else if(e.getButton()==MouseEvent.BUTTON3)
				view.getController().getStateManager().setCurrentState(States.SELECT_ELEMENTS_STATE);
			
		 }
		 
   }
   
   /** @param e */
   public void mousePressed(MouseEvent e) {
	     lastPosition = e.getPoint();
	     LinkPainter.comparePointf= new Point2D.Double(lastPosition.getX(), lastPosition.getY());
		 view.pointToUserSpace(lastPosition);
	 
		 if(e.getButton()==MouseEvent.BUTTON1)
		 {
			if(!(view.getElementAtPosition(lastPosition) instanceof Link))
			 currentElement =  (GraphElement) view.getElementAtPosition(lastPosition);
			 if(currentElement!=null){
				 
				 pocetak=true;
				 kraj=false;
				 links= new ArrayList<GeneralPath>();
				
				 veza = new Link();
				 veza.setFirst(currentElement);
				 poslednjaTacka = lastPosition;
			
			 }
			 else
			 {
				 if(aaaaa!=null && !kraj) 
				 {
						 lastPosition=aaaaa;
						
				 }
			 }
			 
			 
		 }
		 MainFrame.getInstance().getStatus().setStatus2("Connect elements");

   }
   
   /** @param e */
   public void mouseMoved(MouseEvent e) {
	   MainFrame.getInstance().getStatus().setStatus3(e.getX(),e.getY());
	 
   } 

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyReleased(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseWheelMoved(MouseWheelEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseDragged(MouseEvent e) {
	 if(pocetak)
 	 {
		 currentPosition= e.getPoint();
		 view.pointToUserSpace(currentPosition);
		 if(!kraj)			
			 view.repaint();
			 
 	 }
	 Point mousePointPos=new Point();
	    mousePointPos.setLocation(e.getPoint());
	    view.autoscroll(mousePointPos);
}

@Override
public void paint(Graphics2D g2) {
	
	g2.setColor(Color.BLACK);
	g2.setStroke(new BasicStroke(1,
			BasicStroke.CAP_ROUND,
			BasicStroke.JOIN_ROUND,
			5,
			null,
			0));
	
	if(!links.isEmpty())
	{
	 for(int i=0;i<links.size();i++)
	 g2.draw(links.get(i));
	}
	    link=new GeneralPath();	
		link.moveTo(lastPosition.getX(), lastPosition.getY());
		link.lineTo(currentPosition.getX(),currentPosition.getY());
	if(links!=null)
		g2.draw(link);
}
private String generateName(){
	String ime = "";
	int rbr = 1;
	ArrayList<Integer> brojevi = new ArrayList<Integer>();
		for(Element e: view.getGGEModel().getElements()){
			if(e instanceof Link){
				String name = e.getName().trim();
				if (name.startsWith("link")&&name.contains("_")){		
				String[] parts = name.split("_");
				String br = parts[1];
				char[] array = br.toCharArray();
				boolean broj = true;
				for(int i = 0; i < array.length; i ++){
					if(!(array[i]>='0' && array[i]<='9'))
						broj = false;
					
				}
				if(broj)
					brojevi.add(Integer.parseInt(br));
				}
				
			}
		}
		boolean dodat = false;
		while(!dodat){
			if(!brojevi.contains(rbr)){
				dodat = true;
				break;
			}
			rbr++;
		}
		ime = "link_"+rbr;
		
	return ime;
}

}