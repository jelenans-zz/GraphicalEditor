
package gge.view;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import gge.model.Element;
import gge.model.Link;
import gge.state.ConnectElementsState;
import gui.MainFrame;



public class LinkPainter extends Painter {
     
	Link veza ;
	Point2D pocetnaTacka;
	Point2D krajnjaTacka;
    Point2D postaviTacku;
    Point2D postaviTackuf;
	
	public static Point2D comparePoint;
	public static Point2D comparePointf;
	
	public LinkPainter(Link element) {
		super();
		
		System.out.println("POZIV: "+ConnectElementsState.ddd);
		ConnectElementsState.ddd++;
		veza = element;
		GeneralPath link= new GeneralPath();
		Link el = (Link)element;
		
		 
		 double toUpXf= (comparePointf.getX()-el.getFirst().getConnectionPoints().get(0).getX());
		 double toUpYf= (comparePointf.getY()-el.getFirst().getConnectionPoints().get(0).getY());
		 
		 double d1f= Math.sqrt(toUpXf*toUpXf + toUpYf*toUpYf);
		 System.out.println("up1: "+d1f);
		 
		 double toLeftXf= (comparePointf.getX()-el.getFirst().getConnectionPoints().get(1).getX());
		 double toLeftYf= (comparePointf.getY()-el.getFirst().getConnectionPoints().get(1).getY());
		 
		 double d2f= Math.sqrt(toLeftXf*toLeftXf + toLeftYf*toLeftYf);
		 System.out.println("left1: "+d2f); 
		 
		 double toDownXf= (comparePointf.getX()-el.getFirst().getConnectionPoints().get(2).getX());
		 double toDownYf= (comparePointf.getY()-el.getFirst().getConnectionPoints().get(2).getY());
		 
		 double d3f= Math.sqrt(toDownXf*toDownXf + toDownYf*toDownYf);
		 System.out.println("down1: "+d3f); 
		
		 double toRightXf= (comparePointf.getX()-el.getFirst().getConnectionPoints().get(3).getX()); 
		 double toRightYf= (comparePointf.getY()-el.getFirst().getConnectionPoints().get(3).getY());
		 
		 double d4f= Math.sqrt(toRightXf*toRightXf + toRightYf*toRightYf);
		 System.out.println("right1: "+d4f);
		 
	     double minDistancef=d1f;
	     
	     if(d2f<minDistancef)
	    	 minDistancef=d2f;
	     if(d3f<minDistancef)
	    	 minDistancef=d3f;
	     if(d4f<minDistancef)
	    	 minDistancef=d4f;
	     

	
	    if(minDistancef==d1f)
	    {
	    	System.out.println("UP 1");
	    	postaviTackuf= new Point2D.Double(el.getFirst().getConnectionPoints().get(0).getX(), 
	    									el.getFirst().getConnectionPoints().get(0).getY());
	    }
	    else if(minDistancef==d2f)
	    {
	    	System.out.println("LEFT 1");
	    	postaviTackuf= new Point2D.Double(el.getFirst().getConnectionPoints().get(1).getX(), 
	    									el.getFirst().getConnectionPoints().get(1).getY());
	    }
	    else if(minDistancef==d3f)
	    {
	    	System.out.println("DOWN 1");
	    	postaviTackuf= new Point2D.Double(el.getFirst().getConnectionPoints().get(2).getX(),
	    									el.getFirst().getConnectionPoints().get(2).getY());
	    }
	    else if(minDistancef==d4f)
	    {
	    	System.out.println("RIGHT 1");
	    	postaviTackuf= new Point2D.Double(el.getFirst().getConnectionPoints().get(3).getX(), 
	    									el.getFirst().getConnectionPoints().get(3).getY());
	    }



	
		 
		 double toUpX= (Math.abs(comparePoint.getX())-Math.abs(el.getSecond().getConnectionPoints().get(0).getX()));
		 double toUpY= (Math.abs(comparePoint.getY())-Math.abs(el.getSecond().getConnectionPoints().get(0).getY()));
		 
		 double d1= Math.sqrt(toUpX*toUpX + toUpY*toUpY);
		 System.out.println("up2: "+d1);
		 
		 
		 double toLeftX= (Math.abs(comparePoint.getX())-Math.abs(el.getSecond().getConnectionPoints().get(1).getX()));
		 double toLeftY= (Math.abs(comparePoint.getY())-Math.abs(el.getSecond().getConnectionPoints().get(1).getY()));
		 
		 double d2= Math.sqrt(toLeftX*toLeftX + toLeftY*toLeftY);
		 System.out.println("left2: "+d2);
		 
		 
		 double toDownX= (Math.abs(comparePoint.getX())-Math.abs(el.getSecond().getConnectionPoints().get(2).getX()));
		 double toDownY= (Math.abs(comparePoint.getY())-Math.abs(el.getSecond().getConnectionPoints().get(2).getY()));
		 
		 double d3= Math.sqrt(toDownX*toDownX + toDownY*toDownY);
		 System.out.println("down2: "+d3);
		 
		
		 double toRightX= (Math.abs(comparePoint.getX())-Math.abs(el.getSecond().getConnectionPoints().get(3).getX()));
		 double toRightY= (Math.abs(comparePoint.getY())-Math.abs(el.getSecond().getConnectionPoints().get(3).getY()));
		 
		 double d4= Math.sqrt(toRightX*toRightX + toRightY*toRightY);
		 System.out.println("right2: "+d4);

	     double minDistance=d1;
	     
	     if(d2<minDistance)
	    	 minDistance=d2;
	     if(d3<minDistance)
	    	 minDistance=d3;
	     if(d4<minDistance)
	    	 minDistance=d4;
	     

	
	    if(minDistance==d1)
	    {
	    	System.out.println("UP2: "+d1);
	    	postaviTacku= new Point2D.Double(el.getSecond().getConnectionPoints().get(0).getX(), el.getSecond().getConnectionPoints().get(0).getY());
	    }
	    else if(minDistance==d2)
	    {
	    	System.out.println("LEFT2");
	    	postaviTacku= new Point2D.Double(el.getSecond().getConnectionPoints().get(1).getX(), el.getSecond().getConnectionPoints().get(1).getY());
	    }
	    else if(minDistance==d3)
	    {
	    	System.out.println("DOWN2");
	    	postaviTacku= new Point2D.Double(el.getSecond().getConnectionPoints().get(2).getX(),el.getSecond().getConnectionPoints().get(2).getY());
	    }
	    else if(minDistance==d4)
	    {
	    	System.out.println("RIGHT2");
	    	postaviTacku= new Point2D.Double(el.getSecond().getConnectionPoints().get(3).getX(), el.getSecond().getConnectionPoints().get(3).getY());
	    }



		veza.setPocetnaTacka( new Point2D.Double(postaviTackuf.getX(),postaviTackuf.getY()));
		link.moveTo(postaviTackuf.getX(),postaviTackuf.getY());
		
		for(Point2D p: el.getBreakPoints())
		{
			link.lineTo(p.getX(), p.getY());
		}
		
		veza.setKrajnjaTacka(new Point2D.Double(postaviTacku.getX(),postaviTacku.getY()));
		link.lineTo(postaviTacku.getX(),postaviTacku.getY());
		
		
	
		shape = link;
		
	 }
	public Boolean isElementAt(Point2D position) {
		
		if(!veza.getBreakPoints().isEmpty()){	
			Line2D linija = new Line2D.Double(veza.getPocetnaTacka(),veza.getBreakPoints().get(0));
			if(linija.ptLineDist(position)<1)	
				return true;
			for(int i =0;i<veza.getBreakPoints().size()-1;i++){
				linija = new Line2D.Double(veza.getBreakPoints().get(i),veza.getBreakPoints().get(i+1));
				if(linija.ptLineDist(position)<1)	
					return true;
			}
			linija = new Line2D.Double(veza.getBreakPoints().get(veza.getBreakPoints().size()-1),veza.getKrajnjaTacka());
			if(linija.ptLineDist(position)<1)	
				return true;
		}
		else 
		{
			Line2D linija = new Line2D.Double(veza.getPocetnaTacka(),veza.getKrajnjaTacka());
			if(linija.ptLineDist(position)<1)	
				return true;
		}
		
		
		return false;
	}
	
	public boolean isElementAtX(int x) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public void moveElementTransformation(double xPos, double yPos) {
		elementTransformation.translate(xPos/elementTransformation.getScaleX() ,yPos/elementTransformation.getScaleY());
		
	}
	@Override
	public Element getElement() {
		// TODO Auto-generated method stub
		return veza;
	}
	@Override
	void paint(Graphics2D g2) {
		 AffineTransform graphicsTransformation = g2.getTransform(); // cuvamo tekucu transformaciju dijagrama

			g2.transform(elementTransformation); // nadodajemo na nju transformaciju elementa

			g2.draw(shape);
		
			FontMetrics fm = g2.getFontMetrics();
				int textWidth = fm.stringWidth(veza.getName());
				int textHeight = fm.getHeight();
				
				double XX = 0;
				double YY = 0;
					if(veza.getBreakPoints().size()>1){
				
				int brojTacke = veza.getBreakPoints().size()/2;
				XX = (veza.getBreakPoints().get(brojTacke -1 ).getX() + veza.getBreakPoints().get(brojTacke).getX());
				YY = (veza.getBreakPoints().get(brojTacke -1 ).getY() + veza.getBreakPoints().get(brojTacke).getY());
					
					}
				if(veza.getBreakPoints().size() == 1){
					XX = 2*veza.getBreakPoints().get(0).getX() + 20;
					YY = 2*veza.getBreakPoints().get(0).getY() - 20;
				}
				if(veza.getBreakPoints().isEmpty()){
					XX = (veza.getPocetnaTacka().getX() + veza.getKrajnjaTacka().getX()) ;
					YY = (veza.getPocetnaTacka().getY() + veza.getKrajnjaTacka().getY()) -20 ;
					
				}
				g2.drawString(veza.getName(),
						(int) ((XX/elementTransformation.getScaleX() - textWidth) / 2),
						(int) ((YY/elementTransformation.getScaleY() + textHeight) / 2));

				
				
			
			g2.setTransform(graphicsTransformation); // vracamo originalnu transformaciju dijagrama


		
	}
	
	

}