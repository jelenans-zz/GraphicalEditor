package gge.view;

import gge.model.GraphElement;

import java.awt.geom.Ellipse2D;
import java.awt.geom.GeneralPath;

public class ISAhierarchyPainter extends ElementPainter {

	@Override
	protected void finalize() {
		// TODO Auto-generated method stub
		super.finalize();
	}

	public ISAhierarchyPainter(GraphElement element) {
		super(element);
		double sirina=element.getSize().getWidth();
		double visina=element.getSize().getHeight();
		GeneralPath link=new GeneralPath();
		link.moveTo(0+sirina/2, 0);
		link.lineTo(0,0+visina/2);
		link.lineTo(0+sirina/2,0+visina);
		link.lineTo(0+sirina, 0+visina/2);
		link.closePath();

		GeneralPath linkUnut=new GeneralPath();
		linkUnut.moveTo(sirina/2,6);
		linkUnut.lineTo(9, visina/2);
		linkUnut.lineTo(sirina/2,54);
		linkUnut.lineTo(91,visina/2);
		linkUnut.closePath();
		
		link.append(linkUnut, false);
		shape = link;

	}
	
	

}
