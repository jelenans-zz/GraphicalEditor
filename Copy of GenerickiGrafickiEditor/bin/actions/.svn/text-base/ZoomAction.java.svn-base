package actions;

import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Point2D.Double;

import gge.model.Element;
import gge.model.GraphElement;
import gge.view.GGEView;
import gui.MainFrame;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;



public class ZoomAction extends AbstractAction{
	
	public ZoomAction() {
		super();
	
		
		putValue(Action.NAME, "Zumiranje");
		putValue(Action.SHORT_DESCRIPTION, "ZoomIn");
		//putValue(Action.SMALL_ICON, new ImageIcon("Slike/ZoomIN.jpg"));
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		if(!currView.getGGEModel().getElements().isEmpty()){
		currView.scrollRectToVisible(currView.getVisibleRect());
		GraphElement el = (GraphElement)currView.getGGEModel().getElement(0);
		double minX = el.getPosition().getX();
		double maxX = (el.getPosition().getX()+ el.getSize().getWidth());
		double minY = el.getPosition().getY();
		double maxY = (el.getPosition().getY() + el.getSize().getHeight());
		
	
		for(Element e: currView.getGGEModel().getElements()){
			if(e instanceof GraphElement){
			if(((GraphElement) e).getPosition().getX() < minX)
				minX = ((GraphElement) e).getPosition().getX();
			if((((GraphElement) e).getPosition().getX()+ ((GraphElement) e).getSize().getWidth()) > maxX)
				maxX = (((GraphElement) e).getPosition().getX()+ ((GraphElement) e).getSize().getWidth());
			if(((GraphElement) e).getPosition().getY()< minY)
				minY = ((GraphElement) e).getPosition().getY();
			if((((GraphElement) e).getPosition().getY() + ((GraphElement) e).getSize().getHeight()) > maxY)
				maxY = (((GraphElement) e).getPosition().getY() + ((GraphElement) e).getSize().getHeight());
			}
		}
		String procenti = (String)((JComboBox)arg0.getSource()).getSelectedItem();
		
		int vrednost = Integer.parseInt(procenti.substring(0, procenti.length()-1));
		
		currView.getTransformation().setToScale(1, 1);
		double newScalingX = currView.getTransformation().getScaleX()*vrednost/100;
		
	  	
	     currView.getTransformation().setToScale(newScalingX, newScalingX);
	     
	     double noviRectX = (maxX - minX)*currView.getTransformation().getScaleX();
		 double noviRectY = (maxY - minY)*currView.getTransformation().getScaleX();
		 double Y = (currView.getVisibleRect().height - noviRectY)/2;
		 double X = (currView.getVisibleRect().width - noviRectX)/2;
			
	     currView.getTransformation().translate(-minX, -minY);
	     
	     //centriranje
	     currView.getTransformation().translate(X/currView.getTransformation().getScaleX(), Y/currView.getTransformation().getScaleX());
	    
		
	     currView.repaint();
		}
	}
}
