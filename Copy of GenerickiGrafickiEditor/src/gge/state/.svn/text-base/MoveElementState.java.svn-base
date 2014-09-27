/***********************************************************************
 * Module:  MoveElementState.java
 * Author:  Sladza
 * Purpose: Defines the Class MoveElementState
 ***********************************************************************/

package gge.state;

import gge.command.MoveCommand;
import gge.model.Element;
import gge.model.GraphElement;
import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;


public class MoveElementState extends State {
	GGEView view;
	public GraphElement currentElement = null;
	public GraphElement nekielem = null;
	Point2D lastPosition;
	static final double translateFactor = 30;
	private int startXPos, startYPos;
	Point2D mousePos;
	boolean esc;
	int deltaX,deltaY;
	
   public MoveElementState(GGEView view, double lassoStartX, double lassoStartY) {
		// TODO Auto-generated constructor stub
	   this.view=view;
	   this.startXPos=(int) lassoStartX;
	   this.startYPos=(int) lassoStartY;
	   esc=false;
	}

/** @param e */
   public void mousePressed(MouseEvent e) {
      // TODO: implement
	   startXPos=e.getX();
	   startYPos=e.getY();
	   lastPosition=e.getPoint();
	   view.pointToUserSpace(lastPosition);
	  
	   if (view.getSelectedHandle() == null)
			if (e.getButton() == MouseEvent.BUTTON1) {
				currentElement = (GraphElement) view.getElementAtPosition(lastPosition);
			
				
		}
	
	  
   }
   
   /** @param e */
   public void mouseReleased(MouseEvent e) {
     view.getController().getStateManager().setCurrentState(States.SELECT_ELEMENTS_STATE);
     MainFrame.getInstance().getStatus().setStatus2("Selection");
     System.out.println(view.getController().getStateManager().getCurrentState().toString());
     view.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	   
   }
   
   /** @param e */
   public void mouseDragged(MouseEvent e) {
	  
      mousePos=e.getPoint();
      view.pointToUserSpace(mousePos);
      
   
      
      //autoskrolovanje
      Point mousePointPos=new Point();
      mousePointPos.setLocation(e.getPoint());
      view.autoscroll(mousePointPos);
      view.setCursor(Cursor.getPredefinedCursor(Cursor.MOVE_CURSOR));
     
	  view.getCommandManager().executeCommand(new MoveCommand(view,mousePos.getX()-startXPos ,
			  									mousePos.getY()-startYPos));
      
     
	  startXPos=(int) mousePos.getX();
	  startYPos=(int) mousePos.getY();
	  if(view.getSelection().getElements().size()==1){
		  MainFrame.getInstance().setPosLbl("X:"+e.getX()+",Y:"+e.getY());
	  }
	  System.out.println(view.getController().getStateManager().getCurrentState().toString());
	  MainFrame.getInstance().getStatus().setStatus3(e.getX(),e.getY());
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
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void keyPressed(KeyEvent e) {
	
     
	
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
public void mouseMoved(MouseEvent e) {
	
	
}

@Override
public void paint(Graphics2D g2) {
	// TODO Auto-generated method stub
	
}

}