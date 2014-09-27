package gge.view;

import gge.model.GraphElement;
import java.awt.geom.GeneralPath;

public class WeakEntityPainter extends ElementPainter {

	@Override
	protected void finalize() {
		// TODO Auto-generated method stub
		super.finalize();
	}

	public WeakEntityPainter(GraphElement element) {
		super(element);
		/*shape = new Ellipse2D.Double 
				(element.getPosition().getX(), element.getPosition().getY(),
				element.getSize().getWidth(), element.getSize().getHeight());
	*/
		double sirina=element.getSize().getWidth();
		double visina=element.getSize().getHeight();
		
		GeneralPath weak=new GeneralPath();
		weak.moveTo(0,0);
		
		weak.lineTo(0,0+visina);
		weak.lineTo(0+sirina,0+visina);
		weak.lineTo(0+sirina,0);
		weak.closePath();
		
		GeneralPath inner=new GeneralPath();
		inner.moveTo(0+sirina/12, 0+visina/8);
		inner.lineTo(0+sirina/12, 0+(7*visina)/8);
		inner.lineTo(0+(11*sirina)/12,0+(7*visina)/8);
		inner.lineTo(0+(11*sirina)/12, 0+visina/8);
		inner.closePath();
		weak.append(inner, false);
		
		shape = weak;
	
	}

}
