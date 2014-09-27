package gge.view;

import gge.model.Element;
import gge.model.GraphElement;
import gge.model.Link;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Dimension2D;
import java.awt.geom.Line2D.Double;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

enum Handle {		// hendlovi za izmenu veliÄ�ine elementa
	North, South, East, West, SouthEast, SouthWest, NorthEast, NorthWest
}


public class SelectionHandleHandler {
	
	static final int handleSize = 10;

	/**
	 * Iscrtavanje selekcionih hendlova oko selektovanih elemenata.
	 * VeliÄ�ina hendlova i debljina isprekidane linije ne zavise od tekuÄ‡eg skaliranja.
	 */
	void paintSelectionHandles(Graphics2D g2, SelectionModel selection, double scale) {

		Iterator<Element> iter = selection.getIteratorElements();
		while (iter.hasNext()) {
			Element elem = iter.next();
	if(elem instanceof GraphElement){
		
			// Iscrtavanje pravougaonika sa isprekidanom linijom
			g2.setStroke(new BasicStroke(1 / (float)scale,
					BasicStroke.CAP_SQUARE, BasicStroke.JOIN_BEVEL, 1f,
					new float[] { 3f, 6f }, 0));
			g2.setPaint(Color.BLACK);
			g2.drawRect((int) ((GraphElement) elem).getPosition().getX(),
					(int) ((GraphElement) elem).getPosition().getY(), 
					(int) ((GraphElement) elem).getSize().getWidth(),
					(int) ((GraphElement) elem).getSize().getHeight());

			// Iscrtavanje hendlova
			for (Handle e : Handle.values()) {
				paintSelectionHandle(g2,
						getHandlePoint(((GraphElement) elem).getPosition(), ((GraphElement) elem).getSize(), e), scale);
			}
			
		
		}
		}
	}

	/**
	 * Iscrtavanje jednog selekcionog hendla za zadatu poziciju
	 */
	private void paintSelectionHandle(Graphics2D g2, Point2D position, double scale) {
		double size = handleSize / scale;
		g2.fill(new Rectangle2D.Double(position.getX() - size / 2, 
				position.getY() - size / 2, size, size));
	}

	/**
	 * Pronalazi taÄ�ku na kojoj se hendl nalazi za zadatu poziciju i veliÄ�inu elementa
	 * 
	 * @param topLeft - pozicija elementa
	 * @param size - veliÄ�ina elementa
	 * @param handlePosition - hendl koji nas interesuje
	 * @return taÄ�ka u kojoj se hendl nalazi
	 */
	protected Point2D getHandlePoint(Point2D topLeft, Dimension2D size, Handle handlePosition) {
		double x = 0, y = 0;

		// OdreÄ‘ivanje y koordinate

		// Ako su gornji hendlovi
		if (handlePosition == Handle.NorthWest
				|| handlePosition == Handle.North
				|| handlePosition == Handle.NorthEast) {
			y = topLeft.getY();
		}
		
		// Ako su centralni po y osi
		if (handlePosition == Handle.East || handlePosition == Handle.West) {
			y = topLeft.getY() + size.getHeight() / 2;
		}
		
		// Ako su donji
		if (handlePosition == Handle.SouthWest
				|| handlePosition == Handle.South
				|| handlePosition == Handle.SouthEast) {
			y = topLeft.getY() + size.getHeight();
		}

		// OdreÄ‘ivanje x koordinate

		// Ako su levi
		if (handlePosition == Handle.NorthWest || handlePosition == Handle.West
				|| handlePosition == Handle.SouthWest) {
			x = topLeft.getX();
		}
		
		// ako su centralni po x osi
		if (handlePosition == Handle.North || handlePosition == Handle.South) {
			x = topLeft.getX() + size.getWidth() / 2;
		}
		
		// ako su desni
		if (handlePosition == Handle.NorthEast || handlePosition == Handle.East
				|| handlePosition == Handle.SouthEast) {
			x = topLeft.getX() + size.getWidth();
		}

		return new Point2D.Double(x, y);
	}

	/**
	 * Za zadatu taÄ�ku i element vraÄ‡a hendl.
	 * @param device
	 * @param point
	 * @return Hendl ukoliko je "pogoÄ‘en", u suprotnom vraÄ‡a null
	 */
	public//radi detekciju da li je hendl pogodjen ili ne, da li sme da se promeni na public
	Handle getHandleForPoint(GraphElement elem, Point2D point, double scale) {
		for(Handle h: Handle.values()) {
			if(isPointInHandle(elem, point, h, scale)) {
				return h;
			}
		}
		return null;
	}
	
	/**
	 * Za zadati ureÄ‘aj, taÄ�ku i hendl odreÄ‘uje da li je taÄ�ka unutar hendla
	 */
	private boolean isPointInHandle(GraphElement elem, Point2D point, Handle handle, double scale) {
		Point2D handleCenter = getHandlePoint(elem.getPosition(), elem.getSize(), handle);
		return ((Math.abs(point.getX() - handleCenter.getX()) 
					<= (double) handleSize / 2 / scale) 
				&& (Math.abs(point.getY() - handleCenter.getY()) 
					<= (double) handleSize / 2 / scale));
	}
	/////////////////****metode za hendlere veze
	
	
	//iscrtavanje hendla
	void paintHandlesForLink(Graphics2D g2, SelectionModel selection, double scale){
	
		
			double size = handleSize / scale;
			for(Element g: selection.getElements()){
			 	  if(g instanceof Link){
			 	          GraphElement first = ((Link) g).getFirst();
			 	          GraphElement second = ((Link) g).getSecond();
			 	         // g2.fill(new Rectangle2D.Double(first.getPosition().getX()+first.getSize().getWidth()/2-size/2,first.getPosition().getY()+first.getSize().getHeight()/2-size/2,size,size));
			 	          g2.fill(new Rectangle2D.Double(((Link) g).getPocetnaTacka().getX()-size/2,((Link) g).getPocetnaTacka().getY()-size/2,size,size));  
			 	          for(Point2D cp: ((Link) g).getBreakPoints())
			 	                       g2.fill(new Rectangle2D.Double(cp.getX() - size/2, cp.getY() - size/2, size, size));
			 	        //  g2.fill(new Rectangle2D.Double(second.getPosition().getX()+second.getSize().getWidth()/2-size/2,second.getPosition().getY()+second.getSize().getHeight()/2-size/2,size,size));
			 	        		 g2.fill(new Rectangle2D.Double(((Link) g).getKrajnjaTacka().getX()-size/2,((Link) g).getKrajnjaTacka().getY()-size/2,size,size)); 
			 	  }
   }
 }
	
	//tacka oko koje je nacrtan hendl
	public
	Point2D getPointForLinkHandle(Link elem, Point2D point, double scale) {
	
		
		 for(Point2D cp: elem.getBreakPoints()) {
			 	    Point2D handleCenter = cp; //cp je sada centar hendla, i za svaki centar ispitujemo da li je u njegovoj okolini tacka i vracamo je
			 	                       
			 	    if( ((Math.abs(point.getX() - handleCenter.getX())
			 	              <= (double) handleSize / 2 / scale)
			 	              && (Math.abs(point.getY() - handleCenter.getY())
			 	              <= (double) handleSize / 2 / scale))){
			 	              return cp;
			 	                               
			 	          }
			 	     }
		 //pocetnu i krajnju tacku 
		 Point2D pocetna = elem.getPocetnaTacka();
		 if( ((Math.abs(point.getX() - pocetna.getX())
	              <= (double) handleSize / 2 / scale)
	              && (Math.abs(point.getY() - pocetna.getY())
	              <= (double) handleSize / 2 / scale))){
	              return pocetna;
	                               
	          }
		 Point2D krajnja = elem.getKrajnjaTacka();
		 if( ((Math.abs(point.getX() - krajnja.getX())
	              <= (double) handleSize / 2 / scale)
	              && (Math.abs(point.getY() - krajnja.getY())
	              <= (double) handleSize / 2 / scale))){
	              return krajnja;
	                               
	          }
		 
		 return null;
	}
}
