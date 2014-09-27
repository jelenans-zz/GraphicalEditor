package gge.state;

import gge.command.Command;
import gge.command.MoveCanvaCommand;
import gge.model.GraphElement;
import gge.model.Link;
import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

public class MoveCanvasState extends State {
	
	 GraphElement currentElement;
	  protected GGEView view;
	  Point2D lastPosition;
	  static final double scalingFactor = 1.2;
		static final double translateFactor = 10;
	
	public MoveCanvasState(GGEView view) {
		super();
		this.view = view;
	}

	public MoveCanvasState() {
		super();
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		//Point2D mousePos = e.getPoint();
		//view.pointToUserSpace(mousePos);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image src=tk.getImage("Slike/handispruzena.jpg");
		Cursor cursor = tk.createCustomCursor(src, new Point(0,0), "Custom Cursor");

		view.setCursor(cursor);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		lastPosition = e.getPoint();
		view.pointToUserSpace(lastPosition);
				
		//view.getSelection().removeAllElements();
		if(SwingUtilities.isRightMouseButton(e)){
			System.out.println(view.getController().getStateManager().getCurrentState());
			view.getController().getStateManager().setCurrentState(States.SELECT_ELEMENTS_STATE);
			view.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			
			System.out.println(view.getController().getStateManager().getCurrentState());
		}
		if(SwingUtilities.isLeftMouseButton(e)){
			Toolkit tk=Toolkit.getDefaultToolkit();
			Image src=tk.getImage("Slike/handsavijena.jpg");
			Cursor cursor = tk.createCustomCursor(src, new Point(0,0), "Custom Cursor");

			view.setCursor(cursor);
			MainFrame.getInstance().getStatus().setStatus2("Move canvas");
		}

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
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
		// TODO Auto-generated method stub
		MainFrame.getInstance().getStatus().setStatus3(e.getX(),e.getY());
		Command command;
		Point2D end=e.getPoint();
		view.pointToUserSpace(end);
		int moveByX=(int) (end.getX()-lastPosition.getX());
		int moveByY=(int) (end.getY()-lastPosition.getY());
		
		command=new MoveCanvaCommand(view, moveByX, moveByY);
	
		view.getCommandManager().executeCommand(command);
		lastPosition = end;

		
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
