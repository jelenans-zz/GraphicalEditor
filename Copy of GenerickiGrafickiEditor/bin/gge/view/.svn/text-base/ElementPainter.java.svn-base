/***********************************************************************
 * Module:  ElementPainter.java
 * Author:  Sladza
 * Purpose: Defines the Class ElementPainter
 ***********************************************************************/

package gge.view;
import gge.model.Connector;
import gge.model.Entity;
import gge.model.Gerund;
import gge.model.GraphElement;
import gge.model.WeakEntity;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Shape;
import java.awt.font.TextAttribute;
import java.awt.geom.AffineTransform;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.HashMap;
import java.util.Map;


public abstract class ElementPainter extends Painter {
	
	protected GraphElement element;
	
	
   public GraphElement getElement() {
	      return element;
	   }

   public void setElement(GraphElement newGraphElement) {
	      this.element = newGraphElement;
	   }
   
   protected void finalize() {
      // TODO: implement
   }
   
  
   public ElementPainter(GraphElement element) {
	   super();
	   this.element = element;
	   updateElementTransformation();
   }
   
   public void updateElementTransformation() {
		elementTransformation = new AffineTransform();	// resetujemo transformaciju na jedinicnu
		// i na nju nadodajemo translaciju elementa za njegovu tekucu poziciju:
		elementTransformation.translate(element.getPosition().getX(), element.getPosition().getY());
		
	}
   
   public void paint(Graphics2D g2){
	   AffineTransform graphicsTransformation = g2.getTransform(); // cuvamo tekucu transformaciju dijagrama

	   	
	   
		g2.transform(elementTransformation); // nadodajemo na nju transformaciju elementa
		
// PROPERTIES ELEMENTA..........................................................................
		g2.setPaint(element.getColor());
		if(element.isShading())
		{
			g2.setPaint(element.getShadow());
		}
			g2.fill(shape);

		g2.setPaint(element.getBorderColor());

		g2.setStroke(element.getLineStyle());
		
		g2.draw(shape);

	
		g2.setPaint(element.getFontColor());
		g2.setFont(new Font(element.getFontName(), element.getFontStyle(), element.getFontSize()));

		if(element.isUnderline())
		{
			Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
			fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
			g2.setFont(new Font(element.getFontName(), element.getFontStyle(), element.getFontSize()).deriveFont(fontAttributes));
		}
		
	   FontMetrics fm = g2.getFontMetrics();
		int textWidth = fm.stringWidth(element.getName());
		int textHeight = fm.getHeight();
		
		
		
		g2.drawString(element.getName(),
				(int) ((element.getSize().getWidth()/elementTransformation.getScaleX() - textWidth) / 2),
				(int) ((element.getSize().getHeight()/elementTransformation.getScaleY() + textHeight) / 2));

		
		
		if(element instanceof Entity || element instanceof WeakEntity || element instanceof Gerund)
		{
			
			GraphElement grafEl= (GraphElement)element;
			
			
			g2.translate(-element.getPosition().getX(), -element.getPosition().getY());
			int j;
			 for(int i=0;i<grafEl.getLinije().size();i++)
		     {
					if(grafEl.getAtributi().get(i).isUnderline())
					{
						Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
						fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
						g2.setFont(new Font(grafEl.getAtributi().get(i).getFontName(), 
											grafEl.getAtributi().get(i).getFontStyle(),
											grafEl.getAtributi().get(i).getFontSize()).deriveFont(fontAttributes));
					}

				 grafEl.getLinije().get(i).reset();
				 grafEl.getLinije().get(i).moveTo(grafEl.getPosition().getX()+grafEl.getSize().getWidth(),
							grafEl.getPosition().getY()+grafEl.getSize().getHeight());
				 grafEl.getLinije().get(i).lineTo(grafEl.getAtributi().get(i).getPosition().getX()+ grafEl.getAtributi().get(i).getSize().getWidth()/2,
						 grafEl.getAtributi().get(i).getPosition().getY());
		    	 g2.draw(grafEl.getLinije().get(i));

		     }
		} else if(element instanceof Connector)
		{
			GraphElement grafEl= (GraphElement)element;
			
			
			g2.translate(-element.getPosition().getX(), -element.getPosition().getY());
			int j;
			 for(int i=0;i<grafEl.getLinije().size();i++)
		     {
				 
				 if(grafEl.getAtributi().get(i).isUnderline())
					{
						Map<TextAttribute, Integer> fontAttributes = new HashMap<TextAttribute, Integer>();
						fontAttributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
						g2.setFont(new Font(grafEl.getAtributi().get(i).getFontName(), 
											grafEl.getAtributi().get(i).getFontStyle(),
											grafEl.getAtributi().get(i).getFontSize()).deriveFont(fontAttributes));
					}

				 grafEl.getLinije().get(i).reset();
				 grafEl.getLinije().get(i).moveTo(grafEl.getPosition().getX()+grafEl.getSize().getWidth(),
							grafEl.getPosition().getY()+(grafEl.getSize().getHeight())/2);
				 grafEl.getLinije().get(i).lineTo(grafEl.getAtributi().get(i).getPosition().getX()+ grafEl.getAtributi().get(i).getSize().getWidth()/2,
						 grafEl.getAtributi().get(i).getPosition().getY());
		    	 g2.draw(grafEl.getLinije().get(i));

		     }
		}
		g2.setTransform(graphicsTransformation); // vracamo originalnu transformaciju dijagrama


	 }
   
   public Boolean isElementAt(Point2D p2){
	   return shape.contains((p2.getX() - element.getPosition().getX())/elementTransformation.getScaleX(), 
				(p2.getY() - element.getPosition().getY())/elementTransformation.getScaleY());
	   
   }
   public boolean isElementAtX(int x){
	   return shape.contains((x - element.getPosition().getX())/elementTransformation.getScaleX(),0);
	   
   }
   public Boolean isElementIn(Rectangle2D rct2D) {
      // TODO: implement
      //
      return null;
   }
   public AffineTransform getElementTransformation() {
	return elementTransformation;
}

public void resizeElementTransformation(double scaleX,double scaleY, double translateX,double translateY){  //nova tacka u koju treba da se skalira   
	   
	   elementTransformation.scale(scaleX, scaleY);
	   elementTransformation.translate(translateX/elementTransformation.getScaleX(), translateY/elementTransformation.getScaleY());
   }


   public void moveElementTransformation(double x,double y) {
	  //  elementTransformation = new AffineTransform();	   
		//elementTransformation.translate(element.getPosition().getX()+x ,element.getPosition().getY()+y);
	   elementTransformation.translate(x/elementTransformation.getScaleX() ,y/elementTransformation.getScaleY());
	}
  
public Shape getShape() {
	return shape;
}


public void setShape(Shape shape) {
	this.shape = shape;
}


}