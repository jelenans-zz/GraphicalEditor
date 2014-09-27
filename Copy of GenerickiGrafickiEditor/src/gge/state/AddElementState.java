/***********************************************************************
 * Module:  AddElementState.java
 * Author:  Sladza
 * Purpose: Defines the Class AddElementState
 ***********************************************************************/

package gge.state;

import gge.command.AddElementCommand;
import gge.model.Connector;
import gge.model.Element;
import gge.model.Entity;
import gge.model.Gerund;
import gge.model.GraphElement;
import gge.model.ISAhierarchy;
import gge.model.WeakEntity;
import gge.state.StateManager.States;
import gge.view.ConnectorPainter;
import gge.view.ElementPainter;
import gge.view.GGEView;
import gge.view.GerundPainter;
import gge.view.ISAhierarchyPainter;
import gge.view.EntityPainter;
import gge.view.WeakEntityPainter;
import gui.DodavanjeAtributa;
import gui.MainFrame;
import gui.UnosEntiteta;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;

import javax.swing.JOptionPane;




public class AddElementState extends State {
  
	protected GGEView view;
	public static int j=1;
	int i = 1,k=1,l=1,m=1,n=1,p=1;
	public static GraphElement newElem = null;
	
	public AddElementState(GGEView view){
		this.view = view;
		
	}
   public void mouseClicked(MouseEvent e) {
      // TODO: implement
   }
   
  
   public void mousePressed(MouseEvent e) {
	// TODO: implement
   }

@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	

	 view.getSelection().removeAllElements();
	 if (e.getButton() == MouseEvent.BUTTON1) {
			 
	  if(!e.isPopupTrigger()){

	  ElementPainter newPainter = null;
	  Point2D mousePos = e.getPoint();
	  view.pointToUserSpace(mousePos);



//		 newElem = new Atribute(new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
// 			  new Dimension(85, 35));
//		  newElem.setName(view.getElementType()+"_"+i);
//		  i++;

//		  newElem.setOldSize(new Dimension(85, 35));
//		  newElem.setBorderColor(Color.BLACK);
//		  newElem.setColor(Color.WHITE);
//		  newElem.setFontColor(Color.BLACK);
//		  newElem.setUnderline(false);
//		  newElem.setFontName(Font.SERIF);
//		  newElem.setFontStyle(0);
//		  newElem.setFontSize(12);
//		  newElem.setLineStyle(new BasicStroke(1,
//						BasicStroke.CAP_ROUND,
//						BasicStroke.JOIN_ROUND,
//						5,
//						null,0));
//		  newElem.setShadow(new GradientPaint(
//				   new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
//				   Color.WHITE, 
//				   new Point2D.Double(mousePos.getX()+10,  mousePos.getY() - 20)
//				   , Color.WHITE, true));
//		  newElem.setShading(false);
//		  newElem.setFill(false);
//		  newElem.setLineStyleName("puna");
//		  newPainter = new EllipsePainter(newElem);


	  if(view.getElementType().equals("entity")){
		  
		  Point2D point= new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20);
		  UnosEntiteta unos= new UnosEntiteta();
		  unos.tacka=point;
		  unos.setVisible(true);
		  
		  if(unos.OK)
		  {
		  newElem.addConnectionPoints();
		  newElem.setBorderColor(Color.BLACK);
		  newElem.setColor(Color.WHITE);
		  newElem.setFontColor(Color.BLACK);
		  newElem.setUnderline(false);
		  newElem.setFontName(Font.SERIF);
		  newElem.setFontStyle(0);
		  newElem.setFontSize(12);
		  newElem.setLineStyle(new BasicStroke(1,
					BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_ROUND,
					5,
					null,0));
		  newElem.setShadow(new GradientPaint(
				   new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
				   Color.WHITE, 
				   new Point2D.Double(mousePos.getX()+10,  mousePos.getY() - 20)
				   , Color.WHITE, true));
		  newElem.setShading(false);
		  newElem.setFill(false);
		  newElem.setLineStyleName("puna");
		  newPainter = new EntityPainter(newElem);
		//  view.repaint();
		  }
	  }
	  if(view.getElementType().equals("connector")){
		  newElem = new Connector(new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
 			  new Dimension(100, 60));
		  newElem.addConnectionPoints();
		  newElem.setName(view.getElementType()+"_"+k);
		  k++;
		  newElem.setBorderColor(Color.BLACK);
		  newElem.setColor(Color.WHITE);
		  newElem.setFontColor(Color.BLACK);
		  newElem.setUnderline(false);
		  newElem.setFontName(Font.SERIF);
		  newElem.setFontStyle(0);
		  newElem.setFontSize(12);
		  newElem.setLineStyle(new BasicStroke(1,
					BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_ROUND,
					5,
					null,0));
		  newElem.setShadow(new GradientPaint(
				   new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
				   Color.WHITE, 
				   new Point2D.Double(mousePos.getX()+10,  mousePos.getY() - 20)
				   , Color.WHITE, true));
		  newElem.setShading(false);
		  newElem.setFill(false);
		  newElem.setLineStyleName("puna");
		  newPainter = new ConnectorPainter(newElem);
	  }
	  if(view.getElementType().equals("gerund")){

		  newElem = new Gerund(new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
 			  new Dimension(100, 60));
		  newElem.addConnectionPoints();
		  newElem.setName(view.getElementType()+"_"+l);
		  l++;
		  newElem.setBorderColor(Color.BLACK);
		  newElem.setColor(Color.WHITE);
		  newElem.setFontColor(Color.BLACK);
		  newElem.setUnderline(false);
		  newElem.setFontName(Font.SERIF);
		  newElem.setFontStyle(0);
		  newElem.setFontSize(12);
		  newElem.setLineStyle(new BasicStroke(1,
					BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_ROUND,
					5,
					null,0));
		  newElem.setShadow(new GradientPaint(
				   new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
				   Color.WHITE, 
				   new Point2D.Double(mousePos.getX()+10,  mousePos.getY() - 20)
				   , Color.WHITE, true));
		  newElem.setShading(false);
		  newElem.setFill(false);
		  newElem.setLineStyleName("puna");
		 newPainter = new GerundPainter(newElem);
	  }

	  if(view.getElementType().equals("weakEntity")){

		  newElem = new WeakEntity(new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
 			  new Dimension(100,60));
		  newElem.addConnectionPoints();
		  newElem.setName(view.getElementType()+"_"+m);
		  m++;
		  newElem.setBorderColor(Color.BLACK);
		  newElem.setColor(Color.WHITE);
		  newElem.setFontColor(Color.BLACK);
		  newElem.setUnderline(false);
		  newElem.setFontName(Font.SERIF);
		  newElem.setFontStyle(0);
		  newElem.setFontSize(12);
		  newElem.setLineStyle(new BasicStroke(1,
					BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_ROUND,
					5,
					null,0));
		  newElem.setShadow(new GradientPaint(
				   new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
				   Color.WHITE, 
				   new Point2D.Double(mousePos.getX()+10,  mousePos.getY() - 20)
				   , Color.WHITE, true));
		  newElem.setShading(false);
		  newElem.setFill(false);
		  newElem.setLineStyleName("puna");
		 newPainter = new WeakEntityPainter(newElem);
	  }
	  if(view.getElementType().equals("ISAhierarchy")){

		  newElem = new ISAhierarchy(new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
 			  new Dimension(100,60));
		  newElem.addConnectionPoints();
		  newElem.setName(newElem.getName()+"_"+n);
		  n++;
		  newElem.setBorderColor(Color.BLACK);
		  newElem.setColor(Color.WHITE);
		  newElem.setFontColor(Color.BLACK);
		  newElem.setUnderline(false);
		  newElem.setFontName(Font.SERIF);
		  newElem.setFontStyle(0);
		  newElem.setFontSize(12);
		  newElem.setLineStyle(new BasicStroke(1,
					BasicStroke.CAP_ROUND,
					BasicStroke.JOIN_ROUND,
					5,
					null,0));
		  newElem.setShadow(new GradientPaint(
				   new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
				   Color.WHITE, 
				   new Point2D.Double(mousePos.getX()+10,  mousePos.getY() - 20)
				   , Color.WHITE, true));
		  newElem.setShading(false);
		  newElem.setFill(false);
		  newElem.setLineStyleName("puna");
		 newPainter = new ISAhierarchyPainter(newElem);
	  }

//	  if(view.getElementType().equals("link")){
//		  newElem = new Link(new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
// 			  new Dimension(100,60));
//		  newElem.setName(view.getElementType()+"_"+p);
//		  p++;
//		  newElem.setBorderColor(Color.BLACK);
//		  newElem.setColor(Color.BLACK);
//		  newElem.setFontColor(Color.BLACK);
//		  newElem.setUnderline(false);
//		  newElem.setFontName(Font.SERIF);
//		  newElem.setFontStyle(0);
//		  newElem.setFontSize(12);
//		  newElem.setLineStyle(new BasicStroke(1,
//					BasicStroke.CAP_ROUND,
//					BasicStroke.JOIN_ROUND,
//					5,
//					null,
//					0));
//		  newElem.setShadow(new GradientPaint(
//				   new Point2D.Double(mousePos.getX() - 30, mousePos.getY() - 20), 
//				   Color.WHITE, 
//				   new Point2D.Double(mousePos.getX()+10,  mousePos.getY() - 20)
//				   , Color.WHITE, true));
//		  newElem.setShading(false);
//		  newElem.setFill(false);
//		  newElem.setLineStyleName("puna");
//		 newPainter = new LinkPainter(newElem);
//	  }
	  for(Element el: view.getGGEModel().getElements())
	  {
		  if((newElem.getName()).equals(el.getName()))
			  newElem.setName(newElem.getName()+"1");
	  }
	  	view.getCommandManager().executeCommand(new AddElementCommand(view.getGGEModel(),view, newElem, newPainter));
		view.repaint();
	    MainFrame.getInstance().getStatus().setStatus2("Add element");
	  }
	}if(e.getButton() == MouseEvent.BUTTON3){
		view.getController().getStateManager().setCurrentState(States.SELECT_ELEMENTS_STATE); 
		 MainFrame.getInstance().getStatus().setStatus2("Select element state");
	} 

	
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
	// TODO Auto-generated method stub
	
}

@Override
public void mouseMoved(MouseEvent e) {
	MainFrame.getInstance().getStatus().setStatus3(e.getX(),e.getY());
	
}
@Override
public void paint(Graphics2D g2) {
//	
//	g2.setColor(Color.BLACK);
//	g2.setStroke(new BasicStroke(1,
//			BasicStroke.CAP_ROUND,
//			BasicStroke.JOIN_ROUND,
//			5,
//			null,
//			0));
//	   
//	Entity entitet= (Entity)newElem;
	      
//	     for(int i=0;i<entitet.getLinije().size();i++)
//	     {
//	    	 g2.draw(entitet.getLinije().get(i));
//	     }

	
}

}