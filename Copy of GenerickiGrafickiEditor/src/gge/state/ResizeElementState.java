package gge.state;

import gge.model.Element;
import gge.model.GraphElement;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.BasicStroke;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;


public class ResizeElementState extends State {

	  GraphElement currentElement; //element nad kojim vrsimo resize
	  protected GGEView view;
	  Point2D lastPosition; //tacka od koj pocinje drag
	  Point2D mousePos;  //pozicija misa trenutna
	  static final double scalingFactor = 1.2;
		static final double translateFactor = 10;
	   public ResizeElementState(GGEView view){
		   this.view = view;
		  
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
		
		mousePos = e.getPoint();
		view.pointToUserSpace(mousePos);
		
		
		view.moveHandle(lastPosition, mousePos);
		view.setSelectedHandle(null);
		
		
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mousePressed(MouseEvent e) {
		lastPosition = e.getPoint();
		view.pointToUserSpace(lastPosition);
			Element elem = view.getElementAtPosition(lastPosition);	
			if(elem instanceof GraphElement)
		currentElement = (GraphElement) elem;
		

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
		
	    mousePos = e.getPoint();
		view.pointToUserSpace(mousePos);
		
		MainFrame.getInstance().getStatus().setStatus3(e.getX(),e.getY());
			
		MainFrame.getInstance().getStatus().setStatus2("Resize element");

		if(view.getSelection().getElements().size()==1){
			int w=(int) ((GraphElement)view.getSelection().getSingleSelectedElement()).getSize().getWidth();
			int h=(int) ((GraphElement)view.getSelection().getSingleSelectedElement()).getSize().getHeight();
			
			MainFrame.getInstance().setSizeLbl("W:"+w+",H:"+h);
		}
		Point mousePointPos=new Point();
	    mousePointPos.setLocation(e.getPoint());
	    view.autoscroll(mousePointPos);
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
	}

	@Override
	public void paint(Graphics2D g2) {
		
//		g2.setStroke(new BasicStroke(1f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_BEVEL, 0, 
//				new float[] {2, 2}, 0));
//		currentElement = (GraphElement) view.getSelection().getSingleSelectedElement();
//		double w = currentElement.getSize().getWidth();
//		double h = currentElement.getSize().getHeight();
//		Point2D start = null;
//		double width = 0;
//		double height = 0;
	
		//ka gore desno levo i dole od elementa kada se povecava
//		if(mousePos.getX()>currentElement.getPosition().getX() && mousePos.getY()<currentElement.getPosition().getY()
//				&& mousePos.getX() < currentElement.getPosition().getX() + w ){  //ka gore desno 
//			start = new Point2D.Double(currentElement.getPosition().getX(), mousePos.getY());
//			width = currentElement.getSize().getWidth();
//			height = currentElement.getSize().getHeight() + Math.abs(mousePos.getY() - currentElement.getPosition().getY());
//		
//			g2.draw(new Rectangle2D.Double(start.getX(), start.getY(), 
//					width, height));
//		}
		
		
	}

}
