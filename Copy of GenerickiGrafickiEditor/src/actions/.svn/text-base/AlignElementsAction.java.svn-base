package actions;


import gge.model.Atribute;
import gge.model.Element;
import gge.model.Entity;
import gge.model.GraphElement;
import gge.model.Link;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class AlignElementsAction extends AbstractAction {
	 private Point2D position;
	 private int xPos,yPos;
	 int value;
	public AlignElementsAction() {
		
	}

	public AlignElementsAction(int value) {
		// TODO Auto-generated constructor stub
		super();
		if(value==0){
		putValue(Action.NAME, "Align left");
		putValue(Action.SHORT_DESCRIPTION, "Align left ");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/align.png"));
		}else{
			
			putValue(Action.NAME, "Align top");
			putValue(Action.SHORT_DESCRIPTION, "Align top");
			putValue(Action.SMALL_ICON, new ImageIcon("Slike/alignTOP.png"));
		}
		this.value=value;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		
		ArrayList<Element> elements=(ArrayList<Element>)currView.getSelection().getElements();
		int xMin=0;
		int yMin=0;
		if(elements.size()!=0){
			
			if(elements.get(0) instanceof GraphElement){
				xMin=(int) ((GraphElement) elements.get(0)).getPosition().getX();
				yMin=(int) ((GraphElement) elements.get(0)).getPosition().getY();
			}
			if(value==0){//lijevo
				//if()
				for(Element el: elements){
					if(el instanceof GraphElement){
					if(((GraphElement) el).getPosition().getX()<xMin){
						xMin=(int)((GraphElement) el).getPosition().getX();
					}
					}
				}
				for(Element grElem: elements){
					if(grElem instanceof GraphElement){
					  position=((GraphElement) grElem).getPosition();
					  xPos=(int) (xMin);
					  yPos=(int) (position.getY());
					  currView.getElementPainter((GraphElement)grElem).moveElementTransformation(-(((GraphElement) grElem).getPosition().getX()-xPos), 0);
					  position.setLocation(xPos,yPos);
					}else if(grElem instanceof Link){
						GraphElement prvi=((Link) grElem).getFirst();
						
						
						ArrayList<Point2D> points=(ArrayList<Point2D>) ((Link) grElem).getBreakPoints();
						for(Point2D p:points){
							p.setLocation(xMin+prvi.getSize().getWidth()/2,p.getY());
						}
					}
					
				  }				  
				  currView.getGGEModel().fireUpdates();
				  
			}else{
				
					for(Element el: elements){
						if(el instanceof GraphElement){
							if(((GraphElement) el).getPosition().getY()<yMin){
								yMin=(int) ((GraphElement) el).getPosition().getY();
							}
						}
					}
					 for(Element grElem: elements){
						 if(grElem instanceof GraphElement){
							
						  position=((GraphElement) grElem).getPosition();
						  xPos=(int) (position.getX());
						  yPos=(int) (yMin);
						  currView.getElementPainter((GraphElement)grElem).moveElementTransformation(0,-(((GraphElement) grElem).getPosition().getY()-yPos) );
						  position.setLocation(xPos,yPos);
						 }else if(grElem instanceof Link){
							 GraphElement prvi=((Link) grElem).getFirst();
							 ArrayList<Point2D> points=(ArrayList<Point2D>) ((Link) grElem).getBreakPoints();
								for(Point2D p:points){
									p.setLocation(p.getX(),yMin+prvi.getSize().getHeight()/2);
								}
						 }
							 
					  }
			
					  
					  currView.getGGEModel().fireUpdates();
			}
					
		
		}

	}
}
