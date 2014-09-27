/***********************************************************************
 * Module:  LassoSelectionState.java
 * Author:  Sladza
 * Purpose: Defines the Class LassoSelectionState
 ***********************************************************************/

package gge.state;


import gge.model.Atribute;
import gge.model.Element;
import gge.model.GraphElement;
import gge.model.Link;
import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class LassoSelectionState extends State {
	
	private GGEView view;
	private GraphElement currentElement;
	private double lassoStartX ;
	private double lassoStartY ;
	private double lassoCurrentX;
	private double lassoCurrentY;
	static final double scalingFactor = 1.2;
	static final double translateFactor = 10;
	Point2D lastPosition;
	
   public LassoSelectionState(GGEView view, double lassoStartX, double lassoStartY){
	   this.view = view;
	   this.lassoStartX = lassoStartX;
	   this.lassoStartY = lassoStartY;
	 
   }
   public void mouseClicked(MouseEvent e) {
	  lastPosition = e.getPoint();
	  view.pointToUserSpace(lastPosition);
	  
	  if(e.getButton() == MouseEvent.BUTTON1){
	   currentElement = (GraphElement) view.getElementAtPosition(lastPosition);
	   if(currentElement != null){
		   view.getSelection().removeAllElements();
		   view.getSelection().addElements(currentElement);
		   view.getController().getStateManager().setCurrentState(States.SELECT_ELEMENTS_STATE);
	   }
	   else {
		   view.getSelection().removeAllElements();
		   view.getController().getStateManager().setCurrentState(States.SELECT_ELEMENTS_STATE);
	   }
	  }
   }
   
   /** @param e */
   public void keyTyped(KeyEvent e) {
      // TODO: implement
   }

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// first insert all elements under lasso selection into view.getSelection() list 
	
		lastPosition = e.getPoint();
		view.pointToUserSpace(lastPosition);
		if(e.getButton() == MouseEvent.BUTTON1){
			//od dole levo ka gore desno
			if(lastPosition.getX()>lassoStartX && lastPosition.getY()<lassoStartY){ 
				
				for(Element element: view.getGGEModel().getElements()){
					if(element instanceof GraphElement){
					double elementX = ((GraphElement) element).getPosition().getX();
					double elementY = ((GraphElement) element).getPosition().getY();
					double elementW = ((GraphElement) element).getSize().getWidth();
					double elementH = ((GraphElement) element).getSize().getHeight();
					
				if(elementX>lassoStartX && elementX+elementW<lastPosition.getX()
					&& elementY<lassoStartY && elementY+elementH>lastPosition.getY()&&!(element instanceof Atribute))
						view.getSelection().addElements(element);
				
					}
					else {
						boolean dodaj = true;
						for(Point2D bp: ((Link)element).getBreakPoints()){
							if(!(bp.getX()>lassoStartX &&bp.getX()<lassoCurrentX 
									&& bp.getY()<lassoStartY && bp.getY()>lassoCurrentY)){
								dodaj = false;
								break;
							}
							
						}
						if(dodaj&&!(element instanceof Atribute))
							view.getSelection().addElements(element);
					}
				}
			}else 
			//od gore desno ka dole levo
			if(lastPosition.getX()<lassoStartX && lastPosition.getY()>lassoStartY){
				
				for(Element element: view.getGGEModel().getElements()){
					if(element instanceof GraphElement){
					double elementX = ((GraphElement) element).getPosition().getX();
					double elementY = ((GraphElement) element).getPosition().getY();
					double elementW = ((GraphElement) element).getSize().getWidth();
					double elementH = ((GraphElement) element).getSize().getHeight();
				if(elementX>lastPosition.getX() && elementX+elementW<lassoStartX && 
						elementY>lassoStartY && elementY+elementH<lastPosition.getY()
						&&!(element instanceof Atribute))
					
					view.getSelection().addElements(element);
					}
					else {
						boolean dodaj = true;
						for(Point2D bp: ((Link)element).getBreakPoints()){
							if(!(bp.getX()<lassoStartX &&bp.getX()>lassoCurrentX 
									&& bp.getY()>lassoStartY && bp.getY()<lassoCurrentY)){
								dodaj = false;
								break;
							}
							
						}
						if(dodaj&&!(element instanceof Atribute))
							view.getSelection().addElements(element);
					}
				}
			}else 
			
			
			//od dole desno ka levo gore
			if(lastPosition.getX()<lassoStartX && lastPosition.getY()<lassoStartY){ 
			
				for(Element element: view.getGGEModel().getElements()){
					if(element instanceof GraphElement){
					double elementX = ((GraphElement) element).getPosition().getX();
					double elementY = ((GraphElement) element).getPosition().getY();
					double elementW = ((GraphElement) element).getSize().getWidth();
					double elementH = ((GraphElement) element).getSize().getHeight();
				if(elementX>lastPosition.getX() && elementX+elementW<lassoStartX &&
						elementY<lassoStartY && elementY+elementH>lastPosition.getY()
						&&!(element instanceof Atribute))
					
					view.getSelection().addElements(element);
					}
					
					else {
						boolean dodaj = true;
						for(Point2D bp: ((Link)element).getBreakPoints()){
							if(!(bp.getX()<lassoStartX &&bp.getX()>lassoCurrentX 
									&& bp.getY()<lassoStartY && bp.getY()>lassoCurrentY)){
								dodaj = false;
								break;
							}
							
						}
						if(dodaj&&!(element instanceof Atribute))
							view.getSelection().addElements(element);
					}
				}
			}else 
			//od levog gornjeg coska ka desno dole
			if(lastPosition.getX()>lassoStartX && lastPosition.getY()>lassoStartY){ 
		
				for(Element element: view.getGGEModel().getElements()){
					if(element instanceof GraphElement){
					double elementX = ((GraphElement) element).getPosition().getX();
					double elementY = ((GraphElement) element).getPosition().getY();
					double elementW = ((GraphElement) element).getSize().getWidth();
					double elementH = ((GraphElement) element).getSize().getHeight();
				if(elementX>lassoStartX && elementX+elementW<lastPosition.getX() && elementY<lastPosition.getY() && elementY+elementH>lassoStartY
						&&!(element instanceof Atribute))
					view.getSelection().addElements(element);
				
					}
					else {
						boolean dodaj = true;
						for(Point2D bp: ((Link)element).getBreakPoints()){
							if(!(bp.getX()>lassoStartX &&bp.getX()<lassoCurrentX 
									&& bp.getY()>lassoStartY && bp.getY()<lassoCurrentY)){
								dodaj = false;
								break;
							}
							
						}
						if(dodaj&&!(element instanceof Atribute))
							view.getSelection().addElements(element);
					}
				}
			}
		
	view.repaint();
	
	// then change from lasso_selection_state to  default_state
	view.getController().getStateManager().setInDrag(false);
	lassoStartX = -1;
	lassoStartY = -1;
	lassoCurrentX = 0;
	lassoCurrentY = 0;
	if(view.getSelection().getElements().size()==0){
	MainFrame.getInstance().getToolbar().getAlign().setEnabled(false);
	MainFrame.getInstance().getToolbar().getAlignTop().setEnabled(false);
	MainFrame.getInstance().getToolbar().getDelete().setEnabled(false);
	}else{
		MainFrame.getInstance().getToolbar().getAlign().setEnabled(true);
		MainFrame.getInstance().getToolbar().getAlignTop().setEnabled(true);
		MainFrame.getInstance().getToolbar().getDelete().setEnabled(true);
	}
	view.getController().getStateManager().setCurrentState(States.SELECT_ELEMENTS_STATE);
	MainFrame.getInstance().getStatus().setStatus2("Selection");
		}
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	
	  lastPosition = e.getPoint();
	  view.pointToUserSpace(lastPosition);
	  
	   currentElement = (GraphElement) view.getElementAtPosition(lastPosition);
	   if(e.getButton() == MouseEvent.BUTTON1){
	   if(currentElement != null){
		   view.getSelection().removeAllElements();
		   view.getSelection().addElements(currentElement);
		   view.getController().getStateManager().setCurrentState(States.SELECT_ELEMENTS_STATE);
	   }
	   else {
		   if(lassoStartX==-1 && lassoStartY == -1){
				lassoStartX = lastPosition.getX();
				lassoStartY = lastPosition.getY();
				view.getController().getStateManager().setInDrag(true);
			}
	   }
	
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
public void mouseWheelMoved(MouseWheelEvent e) {
	// TODO Auto-generated method stub
	if(e.isControlDown()) {     // Ako je pritisnut Ctrl, radimo zoom u tački
		  
	      // Prvo je potrebno da odredimo novo skaliranje:
	      double newScaling = view.getTransformation().getScaleX();
	      if(e.getWheelRotation() > 0)
	        newScaling *= (double)e.getWheelRotation() * scalingFactor;
	      else
	        newScaling /= -(double)e.getWheelRotation() * scalingFactor;
	      // Zatim je potrebno da skaliranje održimo u intervalu [0.2, 5]
	      if(newScaling < 0.2)
	        newScaling = 0.2;
	      if(newScaling > 5)
	        newScaling = 5;
	    
	      // Poništavanje "smicanja":
	      Point2D oldPosition = e.getPoint();
	      view.pointToUserSpace(oldPosition);

	      view.getTransformation().setToScale(newScaling, newScaling);

	      Point2D newPosition = e.getPoint();
	      view.pointToUserSpace(newPosition);

	      view.getTransformation().translate(newPosition.getX() - oldPosition.getX(),
	        newPosition.getY() - oldPosition.getY());
	     
	      //prikaz procenata u toolbaru 
	      String procenti = (int)(view.getTransformation().getScaleX()*100) + "%";
		  MainFrame.getInstance().setEditedItemInCmb(procenti);
		   
		  
		  //skrolbarovi
	     int oldExtent = MainFrame.getInstance().getScrolZaTabbedPane().getVerticalScrollBar().getModel().getExtent();
	      MainFrame.getInstance().getScrolZaTabbedPane().getVerticalScrollBar().getModel().setExtent((int)(oldExtent/view.getTransformation().getScaleX()));
	      
	    }else if (e.isShiftDown()) { 		// Ako je pritisnut Shift
			view.getTransformation().translate(e.getWheelRotation()
					* translateFactor / view.getTransformation().getScaleX(), 0);
	    } else { 							// u ostalim sluÄ�ajevima vrÅ¡imo skrolovanje po Y osi
			view.getTransformation().translate(0, - e.getWheelRotation()
					* translateFactor /view.getTransformation().getScaleY());


		}

	
	    view.repaint();
}

@Override
public void mouseDragged(MouseEvent e) {
	
	Point2D mousePos = e.getPoint();
	view.pointToUserSpace(mousePos);
	
	
	if(view.getController().getStateManager().isInDrag()){
		lassoCurrentX = mousePos.getX();
		lassoCurrentY = mousePos.getY();
		view.repaint();
	}
	MainFrame.getInstance().getStatus().setStatus3(e.getX(),e.getY());
	Point mousePointPos=new Point();
    mousePointPos.setLocation(e.getPoint());
    view.autoscroll(mousePointPos);
}

@Override
public void mouseMoved(MouseEvent e) {
	
	
}
@Override
public void paint(Graphics2D g2) {
	
	if(view.getController().getStateManager().isInDrag() && lassoStartX != -1 && lassoStartY!=-1){ 
		g2.setColor(Color.GREEN);
		g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, 
				new float[] {2, 2}, 0));
		//s leva na desno
		if(lassoCurrentX>lassoStartX && lassoCurrentY>lassoStartY) 
		g2.draw(new Rectangle2D.Double(lassoStartX, lassoStartY, 
				Math.abs(lassoCurrentX-lassoStartX), Math.abs(lassoCurrentY-lassoStartY)));
		//od dole desno ka gore
		if(lassoCurrentX<lassoStartX && lassoCurrentY<lassoStartY)
			g2.draw(new Rectangle2D.Double(lassoCurrentX, lassoCurrentY, 
					Math.abs(lassoCurrentX-lassoStartX), Math.abs(lassoCurrentY-lassoStartY)));
		//gore desno ka dole
		else 
		if(lassoCurrentX<lassoStartX) //&& lassoCurrentY<lassoStartY)
			g2.draw(new Rectangle2D.Double(lassoCurrentX, lassoStartY, 
					Math.abs(lassoStartX-lassoCurrentX), Math.abs(lassoStartY-lassoCurrentY)));
		
		else
		//od dole levo ka gore
		if(lassoCurrentY<lassoStartY) //&& lassoCurrentY<lassoStartY)
			g2.draw(new Rectangle2D.Double(lassoStartX, lassoCurrentY, 
					Math.abs(lassoStartX-lassoCurrentX), Math.abs(lassoStartY-lassoCurrentY)));
		
	}
	
}

}