/***********************************************************************
 * Module:  ZoomState.java
 * Author:  Sladza
 * Purpose: Defines the Class ZoomState
 ***********************************************************************/
//zumiranje klikom (defaultno)
package gge.state;

import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;


public class ZoomState extends State {
	
	GGEView view;
	double scalingFactor = 2;
	int in_out;
	static final double scaling = 1.2;
	static final double translateFactor = 10;
	public ZoomState(GGEView view,int i){
		this.view = view;
		this.in_out = i;
	}
   @Override
   public void mouseWheelMoved(MouseWheelEvent e) {
	   if(e.isControlDown()) {     // Ako je pritisnut Ctrl, radimo zoom u tački
			  
		      // Prvo je potrebno da odredimo novo skaliranje:
		      double newScaling = view.getTransformation().getScaleX();
		      if(e.getWheelRotation() > 0)
		        newScaling *= (double)e.getWheelRotation() * scaling;
		      else
		        newScaling /= -(double)e.getWheelRotation() * scaling;
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
public void mouseClicked(MouseEvent e) {
	if(e.getButton() == MouseEvent.BUTTON1){
		
		 // Prvo je potrebno da odredimo novo skaliranje:
	      double newScaling = view.getTransformation().getScaleX();
	      if(in_out==1)
	        newScaling *=  scalingFactor;
	      else
	        newScaling /=  scalingFactor;
	      // Zatim je potrebno da skaliranje održimo u intervalu [0.2, 5]
	      if(newScaling < 0.2)
	        newScaling = 0.2;
	      if(newScaling > 7)
	        newScaling = 7;

	      // Poništavanje "smicanja":
	      Point2D oldPosition = e.getPoint();
	      view.pointToUserSpace(oldPosition);

	      view.getTransformation().setToScale(newScaling, newScaling);

	      Point2D newPosition = e.getPoint();
	      view.pointToUserSpace(newPosition);

	      view.getTransformation().translate(newPosition.getX() - oldPosition.getX(),
	        newPosition.getY() - oldPosition.getY());
	      
	      
	      String procenti = (int)(view.getTransformation().getScaleX()*100) +"%";
	      
	      MainFrame.getInstance().setEditedItemInCmb(procenti);

	    }
		
		if(e.getButton() == MouseEvent.BUTTON3){
			view.getController().getStateManager().setCurrentState(States.SELECT_ELEMENTS_STATE);
			view.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		}
	    view.repaint();
	}
	


@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
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
public void mouseDragged(MouseEvent e) {
	// TODO Auto-generated method stub
	
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