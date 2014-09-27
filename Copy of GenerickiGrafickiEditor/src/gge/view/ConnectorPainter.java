
package gge.view;

import gge.model.GraphElement;

import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.util.Collection;


public class ConnectorPainter extends ElementPainter{
  
   private boolean visibility;

	
	public ConnectorPainter(GraphElement element) {
		super(element);
		
		double sirina=element.getSize().getWidth();
		double visina=element.getSize().getHeight();
		
		GeneralPath link=new GeneralPath();
		link.moveTo(0+sirina/2, 0);
		link.lineTo(0,0+visina/2);
		link.lineTo(0+sirina/2,0+visina);
		link.lineTo(0+sirina, 0+visina/2);
		link.closePath();
		shape = link;
	}

		   
   public boolean getVisibility() {
      return visibility;
   }
   
  
   public void setVisibility(boolean newVisibility) {
      visibility = newVisibility;
   }
   
   
   public void paint(Line2D.Double l) {
      // TODO: implement
   }
   
   public void allignLink() {
      // TODO: implement
   }
   
   

}