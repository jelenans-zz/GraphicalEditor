package gge.view;

import gge.model.GraphElement;

import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;

public class GerundPainter extends ElementPainter {

	@Override
	protected void finalize() {
		// TODO Auto-generated method stub
		super.finalize();
	}

	public GerundPainter(GraphElement element) {
		super(element);
		/*shape = new Rectangle2D.Double 
				(element.getPosition().getX(), element.getPosition().getY(),
				element.getSize().getWidth(), element.getSize().getHeight());
		*/
		double sirina=element.getSize().getWidth();
		double visina=element.getSize().getHeight();
		
		GeneralPath gerund=new GeneralPath();
		gerund.moveTo(0,0);
		
		gerund.lineTo(0,0+visina);
		gerund.lineTo(0+sirina,0+visina);
		gerund.lineTo(0+sirina,0);
		gerund.closePath();
		
		GeneralPath inner=new GeneralPath();
		inner.moveTo(0+sirina/2, 0);
		inner.lineTo(0,0+visina/2);
		inner.lineTo(0+sirina/2,0+visina);
		inner.lineTo(0+sirina, 0+visina/2);
		inner.closePath();
		
		gerund.append(inner, false);

		
		shape = gerund;
	}

}
