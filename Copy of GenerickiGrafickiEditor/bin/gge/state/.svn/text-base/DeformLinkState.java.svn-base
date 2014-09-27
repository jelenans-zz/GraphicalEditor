package gge.state;

import gge.command.ChangeElementLinkCommand;
import gge.command.DeformLinkCommand;
import gge.command.MoveLineInLinkCommand;
import gge.model.Element;
import gge.model.GraphElement;
import gge.model.Link;
import gge.view.GGEView;
import gui.MainFrame;


import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class DeformLinkState extends State {
	
	Point2D oldConnectionPoint;
	GGEView view;
	Link link;
	Point2D lastPosition;
	Point2D newConnectionPoint;
	Point2D tackaPomeranjeDeo;
	
	public DeformLinkState(GGEView view, Point2D cp, Point2D tackaPomeranjeDeo){
		oldConnectionPoint = cp;
		this.view = view;
		this.tackaPomeranjeDeo = tackaPomeranjeDeo;
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		
		lastPosition = e.getPoint();
		view.pointToUserSpace(lastPosition);
		Element elem = view.getElementAtPosition(lastPosition);
		
		if(link!=null && tackaPomeranjeDeo == null){
			//prevezivanje
		
		 Point2D pocetna = link.getPocetnaTacka();
		 Point2D krajnja = link.getKrajnjaTacka();
		 if((oldConnectionPoint.equals(pocetna) || oldConnectionPoint.equals(krajnja)) && elem!=null && elem instanceof GraphElement){
			for(Element l: view.getGGEModel().getElements()){
				if(l.equals(link)){
					if(oldConnectionPoint.equals(pocetna))
						view.getCommandManager().executeCommand(new ChangeElementLinkCommand(view.getGGEModel(),link,1,(GraphElement)elem));
					if(oldConnectionPoint.equals(krajnja))
						view.getCommandManager().executeCommand(new ChangeElementLinkCommand(view.getGGEModel(),link,2,(GraphElement)elem));
				}
			}
		 
		}
		 else 
		 {
		  //pomeranje breakPointa
			newConnectionPoint = lastPosition;
			view.getCommandManager().executeCommand(new DeformLinkCommand(view.getGGEModel(),link, oldConnectionPoint,newConnectionPoint));
			
		 }
	  }
		 else //pomeranje segmenta veze 
		 {
			 view.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
			 link = (Link)view.getSelection().getSingleSelectedElement();
			 if(link!=null){
				 if(link.getBreakPoints().size()!=0){
			 System.out.println("pomeranje segmenta veze");
			 double moveByX = lastPosition.getX() - tackaPomeranjeDeo.getX();
			 double moveByY = lastPosition.getY() - tackaPomeranjeDeo.getY(); 
			 List<Element> elements = new ArrayList<Element>(); 
			 //od pocetka do prvog breakpoint-a
			 Point2D t1 = link.getPocetnaTacka();
			 Point2D t2 = link.getBreakPoints().get(0);
			 Line2D linija = new Line2D.Double(t1,t2);
			 if(linija.ptLineDist(tackaPomeranjeDeo)<1){
				 elements.add(link.getFirst()) ;
				 view.getCommandManager().executeCommand(new MoveLineInLinkCommand(view,view.getGGEModel(), link, t1, t2, moveByX, moveByY, elements));
			 }
			 //za breakpoints
			 for(int i = 0; i< link.getBreakPoints().size()-1;i++){
				 Point2D prva = link.getBreakPoints().get(i);
				 Point2D druga = link.getBreakPoints().get(i+1);
				 Line2D l = new Line2D.Double(prva,druga);
				 if(l.ptLineDist(tackaPomeranjeDeo)<1)
				 {
					 //izvrsi komandu za pomeranje segmenta
					 view.getCommandManager().executeCommand(new MoveLineInLinkCommand(view,view.getGGEModel(), link, prva, druga, moveByX, moveByY,elements));
				 }
			 }
			 //za poslednji bp i poslednji el
			 t1 = link.getBreakPoints().get(link.getBreakPoints().size()-1);
			 t2 = link.getKrajnjaTacka();
			 linija = new Line2D.Double(t1,t2);
			 if(linija.ptLineDist(tackaPomeranjeDeo)<1){
				 elements.clear();
				 elements.add(link.getSecond()) ;
				 view.getCommandManager().executeCommand(new MoveLineInLinkCommand(view,view.getGGEModel(), link, t1, t2, moveByX, moveByY, elements));
			 }
			 }
		 }
			
		 }
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		link = (Link)view.getSelection().getSingleSelectedElement();
		if(link!=null){
			
		}
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

		

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		MainFrame.getInstance().getStatus().setStatus3(e.getX(),e.getY());
		
	}

	@Override
	public void paint(Graphics2D g2) {
		// TODO Auto-generated method stub

	}

}
