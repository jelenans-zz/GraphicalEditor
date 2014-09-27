package actions;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;

import gge.model.Element;
import gge.model.GraphElement;
import gge.model.Link;
import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;



public class BestFitZoomAction extends AbstractAction{
	
	public BestFitZoomAction() {
		super();
	
		
		putValue(Action.NAME, "Best fit");
		putValue(Action.SHORT_DESCRIPTION, "BestFit");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/bestfit.jpg"));
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		currView.getController().getStateManager().setCurrentState(States.SELECT_ELEMENTS_STATE);
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
		
		for(Element l: currView.getGGEModel().getElements()){
		  if(l instanceof Link)
		  {
			for(Point2D bp: ((Link)l).getBreakPoints()){
				if(bp.getX()>maxX)
					maxX = bp.getX();
				if(bp.getX()<minX)
					minX = bp.getX();
				if(bp.getY()>maxY)
					maxY = bp.getY();
				if(bp.getY()<minY)
					minY = bp.getY();
			}
		  }
		}
		
		
		//width i height rectangle-a koji treba da se smanjuje/povecava
		double noviRectX = (maxX - minX)*currView.getTransformation().getScaleX();
		double noviRectY = (maxY - minY)*currView.getTransformation().getScaleX();
		
		double newScalingX = currView.getTransformation().getScaleX();
		double scalingFactorX = 1;
		//skaliranje po x
		if(noviRectX > noviRectY ){	
		if((currView.getVisibleRect().width/noviRectX!=currView.getTransformation().getScaleX())){
		if(currView.getVisibleRect().width<noviRectX){		
		 scalingFactorX = noviRectX/currView.getVisibleRect().width;
		 newScalingX /=  scalingFactorX;
		}
		if(currView.getVisibleRect().width>noviRectX){
			scalingFactorX = currView.getVisibleRect().width/noviRectX;
			newScalingX *=  scalingFactorX;
			}
		}
		
	}
		//skaliranje po y
		
		else {
				if((currView.getVisibleRect().height/noviRectY!=currView.getTransformation().getScaleY())){
				if(currView.getVisibleRect().height<noviRectY){
				 scalingFactorX = noviRectY/currView.getVisibleRect().height;
				 newScalingX /=  scalingFactorX;
				}
				if(currView.getVisibleRect().height>noviRectY){
					scalingFactorX =currView.getVisibleRect().getHeight()/noviRectY;
					 newScalingX *=  scalingFactorX;
				}
				}
				
		
			}
	
		
	      currView.getTransformation().setToScale(newScalingX, newScalingX);
	      //u gornji levi ugao
	      currView.getTransformation().translate(-minX,-minY);
	  	
	      
	      noviRectX = (maxX - minX)*currView.getTransformation().getScaleX();
		  noviRectY = (maxY - minY)*currView.getTransformation().getScaleX();
			
			newScalingX = currView.getTransformation().getScaleX();
			scalingFactorX = 1;
			
	     if(currView.getVisibleRect().height<noviRectY){ 
	      if((currView.getVisibleRect().height/noviRectY!=currView.getTransformation().getScaleY())){
				if(currView.getVisibleRect().height<noviRectY){
				 scalingFactorX = noviRectY/currView.getVisibleRect().height;
				 newScalingX /=  scalingFactorX;
				}
				if(currView.getVisibleRect().height>noviRectY){
					scalingFactorX =currView.getVisibleRect().getHeight()/noviRectY;
					 newScalingX *=  scalingFactorX;
				}
				}
	      
	     }
	  
	      currView.getTransformation().setToScale(newScalingX, newScalingX);
	      //smesti ih u gornji levi ugao
	      currView.getTransformation().translate(-minX ,-minY );
	     
	     
	     
	     //centriranje
	     noviRectX = (maxX - minX)*currView.getTransformation().getScaleX();
		 noviRectY = (maxY - minY)*currView.getTransformation().getScaleX();

	     double X = (currView.getVisibleRect().width - noviRectX)/2; 
	     double Y = (currView.getVisibleRect().height - noviRectY)/2;

	     currView.getTransformation().translate(X/currView.getTransformation().getScaleX(),Y/currView.getTransformation().getScaleX());
	     
	     currView.repaint();
	     String procenti = (int)(currView.getTransformation().getScaleX()*100) + "%";
	     MainFrame.getInstance().setEditedItemInCmb(procenti);
		
		}
	
	}
	
	
	
}
