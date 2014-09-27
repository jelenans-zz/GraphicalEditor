/***********************************************************************
 * Module:  GGEView.java
 * Author:  Sladza
 * Purpose: Defines the Class GGEView
 ***********************************************************************/

package gge.view;

import gge.command.CommandManager;
import gge.command.ResizeCommand;
import gge.model.*;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Transparency;
import java.awt.dnd.Autoscroll;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Dimension2D;
import java.awt.geom.NoninvertibleTransformException;
import java.awt.geom.Point2D;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.Scrollable;

import gge.model.GGEModel;

import gge.state.SelectElementState;
import gge.state.StateManager;
import gge.state.StateManager.States;
import gge.state.ZoomState;
import gui.MainFrame;
import gui.PopUp;


@SuppressWarnings("serial")
public class GGEView extends JPanel implements Observer,Autoscroll{
	
   private String elementType;
   private GGEModel gGEModel;
   private SelectionHandleHandler handleHandler = new SelectionHandleHandler();
   AffineTransform transformation = new AffineTransform(); // tekuca transformaciona matrica
   protected Handle selectedHandle = null;
   protected SelectionModel selection = new SelectionModel();
   protected CommandManager commandManager;
   public List<ElementPainter> elementPainters;
   public List<LinkPainter> linkPainters;
   public Layer[] layer;  
   GGEController controller;
   PopUp popUp;
   public boolean showGrid;
   private static final double GRID_WIDTH = 160;
   private Point point;
 
  
  
  
   public ArrayList<Painter> selectedElementsPainters(){
	   ArrayList<Painter> list = new ArrayList<Painter>();
	   for(Element e: selection.getElements()){
		   for(Painter p: elementPainters ){
			   if(p instanceof ElementPainter){
			   if(e.equals(((ElementPainter)p).element)){
				   list.add(p);
				   continue;
			   }
			   }else 
			   {
				   if(e.equals(((LinkPainter)p).veza)){
					   list.add(p);
					   continue;
				   }
			   }
		   }
	   }
	   return list;
   }

  
public GGEView(GGEModel model,MainFrame parent) {

		elementPainters = new ArrayList<ElementPainter>();
		linkPainters = new ArrayList<LinkPainter>();
		this.gGEModel = model;
		model.addObserver(this);
		controller = new GGEController();
		addMouseListener(controller);
		addKeyListener(controller);
		addMouseWheelListener(controller);
		addMouseMotionListener(controller);
		setAutoscrolls(true);
		commandManager = new CommandManager(model);
		showGrid = true;
		setLayout(null);
		
	}
     

  
   public List<ElementPainter> getElementPainters() {
	return elementPainters;
}


public void setElementPainters(List<ElementPainter> elementPainters) {
	this.elementPainters = elementPainters;
}


public List<LinkPainter> getLinkPainters() {
	return linkPainters;
}


public void setLinkPainters(List<LinkPainter> linkPainters) {
	this.linkPainters = linkPainters;
}


public void update(Observable o, Object arg) {

	   //double newScaling = transformation.getScaleX();
		//Point2D oldPosition = e.getPoint();//tacka prije skaliranja,dole lijeva
		//pointToUserSpace(oldPosition);
		//GraphElement g=(GraphElement)arg;
		//transformation.setToTranslation(g.getPosition().getX(),g.getPosition().getY());

		//Point2D newPosition = e.getPoint();
		//pointToUserSpace(newPosition);

		//transformation.translate(
				//newPosition.getX() - oldPosition.getX(),
				//newPosition.getY() - oldPosition.getY());
		//Iterator<GraphElement> iter = this.getGGEModel().getIteratorElements();
		//while (iter.hasNext()) {
		//	GraphElement elem = iter.next();
			//EllipsePainter painter = new EllipsePainter(elem);
			//elementPainters.add(painter);
		//}
	   
	// Ovde je implementirano "brute force" resenje:
			// svaki put kad se desi neka izmena u modelu,
			// brisu se svi painter-i i kreiraju iz pocetka.
			// TODO: osmisliti i implementirati bolje resenje
	   
//	elementPainters.clear();
//	ElementPainter painter=null;
//	Iterator<Element> iter = this.getGGEModel().getIteratorElements();
//	while (iter.hasNext()) {
//	Element elem = iter.next();
//	
//	if(elem instanceof Atribute)
//		painter = new AtributePainter(element);
//	if(elem instanceof Entity)
//		painter = new EntityPainter(element);
//	if(elem instanceof ISAhierarchy)
//		painter = new ISAhierarchyPainter(element);
//	if(elem instanceof WeakEntity)
//		painter = new WeakEntityPainter(element);
//	if(elem instanceof Gerund)
//		painter = new GerundPainter(element);
//	if(elem instanceof Connector)
//		painter = new ConnectorPainter(element);
//	view.getElementPainters().add(painter);
//	}
	
//	   linkPainters.clear();
//			
//			//Iterator<Element> iter =  this.getGGEModel().getElements().iterator();
//			LinkPainter painter=null;
//			//while (iter.hasNext()) {
//			for(Element el: gGEModel.getElements()){
//				if(el instanceof Link)
//				{
//				Link elem = (Link)el;
//
//				painter = new LinkPainter(elem);
//				linkPainters.add(painter);
//				}
//			}
		
	   
	   
		
	   repaint();
   }
   
  
   public void paintComponent(Graphics g) {
     
	   
	   super.paintComponent(g);
	 
	   Graphics2D g2 = (Graphics2D)g;
	 
	   // omekÅ¡avanje ivica (antialiasing):
	   g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
	  
	   // primena transformacije (skrolovanje):
	   g2.transform(transformation);
	   if (showGrid) {
			drawGrid(g2);
		}
	  
	   	//g2.setColor(Color.BLACK);
	   for (ElementPainter painter : elementPainters)
			painter.paint(g2);
	     for (LinkPainter painter : linkPainters)
	    	painter.paint(g2);
		// obelezavanje selekcije :
	  
	    handleHandler.paintSelectionHandles(g2, selection, g2.getTransform().getScaleX());
	  
	    handleHandler.paintHandlesForLink(g2, selection, g2.getTransform().getScaleX());
	  
	  
	 
	    controller.stateManager.getCurrentState().paint(g2);

	   

		 }
		 

   
   
   public void drawGrid(Graphics2D g2) {
	   g2.setStroke(new BasicStroke(1));
	   Color c=Color.LIGHT_GRAY;
	   c.brighter();
	   g2.setColor(c);
		
		Point2D start = new Point2D.Double(0, 0);
		Point2D end = new Point2D.Double(getWidth(), getHeight());
		
		pointToUserSpace(start);
		pointToUserSpace(end);
		//hor linije
		for (int x = (int) Math.round(start.getX()); x < end.getX(); x += GRID_WIDTH) {
			g2.drawLine(x, (int) Math.round(start.getY()),x, (int) Math.round(end.getY()));
		}
		
		
		for (int y = (int) Math.round(start.getY()); y < end.getY(); y += GRID_WIDTH) {
			g2.drawLine((int) Math.round(start.getX()), y, (int) Math.round(end.getX()), y);
		}
		
	}
   public void toggleGrid() {
		showGrid = !showGrid;
		repaint();
	}
   
   /**
	 * Na osnovu hendla iznad koga se nalazi mis postavlja kursor
	 */
	private void setMouseCursor(Point2D point) {
		if(!gGEModel.getElements().isEmpty()){
		Element selectedElement = selection.getSingleSelectedElement();

		Painter painter = null;
		if(selectedElement instanceof GraphElement){
		for(ElementPainter p: elementPainters){
			if(p.element.equals(selectedElement))
				painter = p;
		  }
		
		 }
		else{
			for(LinkPainter p: linkPainters)
				if(p.veza.equals(selectedElement))
					painter = p;
		}
		

		if (selectedElement != null && selectedElement instanceof GraphElement) {
			Handle handle = handleHandler.getHandleForPoint((GraphElement)selectedElement, point, painter.elementTransformation.getScaleX() );
			if (handle != null) {
				Cursor cursor = null;
				controller.stateManager.setCurrentState(States.RESIZE_STATE);
				switch (handle) {
				case North:
					cursor = Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR);
					break;
				case South:
					cursor = Cursor.getPredefinedCursor(Cursor.S_RESIZE_CURSOR);
					break;
				case East:
					cursor = Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR);
					break;
				case West:
					cursor = Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR);
					break;
				case SouthEast:
					cursor = Cursor.getPredefinedCursor(Cursor.SE_RESIZE_CURSOR);
					break;
				case NorthWest:
					cursor = Cursor.getPredefinedCursor(Cursor.NW_RESIZE_CURSOR);
					break;
				case SouthWest:
					cursor = Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR);
					break;
				case NorthEast:
					cursor = Cursor.getPredefinedCursor(Cursor.NE_RESIZE_CURSOR);
					break;
				}
				setCursor(cursor);
			} else {
				controller.stateManager.setCurrentState(States.SELECT_ELEMENTS_STATE);
				setCursor(Cursor.getDefaultCursor());
				
			}
		}
		else {
			if(selectedElement instanceof Link && selectedElement!=null){
				//ovo ne mora biti samo connection point vec i pocetna i krajnja tacka 
			Point2D connectionPoint = handleHandler.getPointForLinkHandle((Link)selectedElement, point, painter.elementTransformation.getScaleX());
			if(connectionPoint!=null){
				setCursor(Cursor.getPredefinedCursor(Cursor.SW_RESIZE_CURSOR));
				controller.stateManager.setCp(connectionPoint);
				controller.stateManager.setTackaPomeranjeDeo(null);
				controller.stateManager.setCurrentState(States.DEFORM_LINK_STATE);
				}
			else {
				controller.stateManager.setCurrentState(States.SELECT_ELEMENTS_STATE);
			setCursor(Cursor.getDefaultCursor());
			}
			}
		}
		}
	}
	
	public void moveHandle(Point2D oldPosition, Point2D newPosition) {
		/* TODO U zavisnosti od tekuÄ‡eg hendla koji se pomera aÅ¾urirati poziciju i veliÄ�inu elementa Ä�iji se oblik menja.
		 * 		Obratiti paÅ¾nju da se, trenutno, elementi iscrtavaju preko shape objekata koji imaju definisanu veliÄ�inu
		 * 		prilikom svog kreiranja.
		 */
		GraphElement selectedElement = (GraphElement) selection.getSingleSelectedElement();
		Point2D pozicija = selectedElement.getPosition();
		Dimension2D velicina = selectedElement.getSize();
		Dimension2D novaVelicina = new Dimension(0,0);
		double X = 0;
		double Y = 0;
		double W = 0;
		double H = 0;
		double translateX = 0;
		double translateY = 0;
		Painter ppp  = null;
		for(Painter p : elementPainters){
			if(p instanceof ElementPainter){
			if(((ElementPainter) p).getElement().equals(selectedElement))
				 ppp  = p;
			}
		}
		Handle handle = handleHandler.getHandleForPoint(selectedElement, oldPosition, transformation.getScaleX());
		if (handle != null) {
			Point2D staraPozicija = handleHandler.getHandlePoint(selectedElement.getPosition(), selectedElement.getSize(), handle); //mora da se uzme sredina hendla da ne bi bilo greske
			
			
			switch (handle) {
			case North:  //ka gore
				
				X = pozicija.getX(); // nova X koordinata za pocetnu tacku
				Y = newPosition.getY(); // nova Y koordinata za pocetnu tacku
				W = velicina.getWidth();
				H = -newPosition.getY() + staraPozicija.getY()+velicina.getHeight();
				translateX = 0;  //stara pozicija
				translateY = -(staraPozicija.getY() - newPosition.getY());
				novaVelicina.setSize(W, H);	
				
				break;
			case South:  // ka dole
				
				X = pozicija.getX(); // nova X koordinata za pocetnu tacku
				Y = pozicija.getY(); // nova Y koordinata za pocetnu tacku
				W = velicina.getWidth();
				H = velicina.getHeight() + newPosition.getY() - staraPozicija.getY();
				translateX = 0;
				translateY = 0;
				novaVelicina.setSize(W, H);	
				
				
				break;
			case East:  //desno
				
				X = pozicija.getX(); // nova X koordinata za pocetnu tacku
				Y = pozicija.getY(); // nova Y koordinata za pocetnu tacku
				W = velicina.getWidth() + newPosition.getX() - staraPozicija.getX();
				H = velicina.getHeight();
				translateX = 0;
				translateY = 0;
				novaVelicina.setSize(W, H);	
	
				break;
				
			case West:  // levo
				
				X = newPosition.getX(); // nova X koordinata za pocetnu tacku
				Y = pozicija.getY(); // nova Y koordinata za pocetnu tacku
				W = velicina.getWidth() + staraPozicija.getX() - newPosition.getX();
				H = velicina.getHeight();
				translateX = -(staraPozicija.getX() - newPosition.getX());
				translateY = 0;
				novaVelicina.setSize(W, H);	
				
				break;
			
			case SouthEast: //dole desno
				
				X = pozicija.getX();
				Y = pozicija.getY();
				W = newPosition.getX() -X;
				H = newPosition.getY() - Y;
				
				translateX = 0;
				translateY = 0;
				novaVelicina.setSize(W, H);	
			
				break;
				
			case NorthWest:  //levo gore
				
				X = newPosition.getX();
				Y = newPosition.getY();
				W = staraPozicija.getX() -newPosition.getX() + velicina.getWidth();
				H = staraPozicija.getY() - newPosition.getY() + velicina.getHeight();
				translateX = -(staraPozicija.getX() - newPosition.getX());
				translateY = -(staraPozicija.getY()-newPosition.getY());
				novaVelicina.setSize(W, H);		
				
				break;
				
			case SouthWest: //levo dole
				
				X = newPosition.getX();
				Y = pozicija.getY();
				W = velicina.getWidth() -newPosition.getX() + staraPozicija.getX();
				H = newPosition.getY() - Y;
				translateX = -(staraPozicija.getX() - newPosition.getX());
				translateY = 0;
				novaVelicina.setSize(W, H);
				break;
				
			case NorthEast: //gore desno
				
				X = pozicija.getX();
				Y = newPosition.getY();
				W = newPosition.getX() - X ;
				H = velicina.getHeight() + staraPozicija.getY() - newPosition.getY();
				
				translateX = 0;
				translateY = -(staraPozicija.getY() - newPosition.getY());
				novaVelicina.setSize(W, H);
				
				break;
				
		    default: break;
			}

			commandManager.executeCommand(new ResizeCommand(gGEModel, selectedElement, ppp, new Point2D.Double(X,Y),novaVelicina,translateX,translateY));
			
		}
	}
	   /**
	 * Transformacija tacke iz fizickog u logicki koordinatni prostor
	 */
   public void pointToUserSpace(Point2D deviceSpace){
		try {
			transformation.inverseTransform(deviceSpace, deviceSpace);
		} catch (NoninvertibleTransformException e) {
			e.printStackTrace();
		}
	}
   

   public void addElementPainters(ElementPainter newElementPainter) {
	   if (newElementPainter == null)
			return;
		if (this.elementPainters == null)
			this.elementPainters = new ArrayList<ElementPainter>();
		if (!this.elementPainters.contains(newElementPainter.getElement()))
			this.elementPainters.add( newElementPainter);
	
   }
   
   public void addLinkPainters(LinkPainter newElementPainter) {
	   if (newElementPainter == null)
			return;
		if (this.linkPainters == null)
			this.linkPainters = new ArrayList<LinkPainter>();
		if (!this.linkPainters.contains(newElementPainter.getElement()))
			this.linkPainters.add(newElementPainter);

   }
   
   

  
   public void removeElementPainters(ElementPainter oldElementPainter) {
	   if (oldElementPainter == null)
			return;
		if (this.elementPainters != null)
			if (this.elementPainters.contains(oldElementPainter))
				this.elementPainters.remove(oldElementPainter);
   }
   
   public void removeLinkPainters(LinkPainter oldElementPainter) {
	   if (oldElementPainter == null)
			return;
		if (this.linkPainters != null)
			if (this.linkPainters.contains(oldElementPainter))
				this.linkPainters.remove(oldElementPainter);
   }
   
   
   public void removeAllElementPainters() {
      if (elementPainters != null)
         elementPainters.clear();
   }
  
  

   public Element getElementAtPosition(Point2D position) {
		/* Proveravamo da li se na poziciji kursora nalazi element.
		 * Prolazimo kroz sve elemente u modelu i preko painter-a
		 * proveravamo da li se na zadatoj lokaciji nalazi element.
		*/
	   for (ElementPainter painter : elementPainters){
			if (painter.isElementAt(position))
				return painter.getElement();
		   }
	   for (LinkPainter painter : linkPainters){
			if (painter.isElementAt(position))
				return painter.getElement();
		   }

	   return null;
	} 
   public Element getElementAtX(int x) {
		/* Proveravamo da li se na poziciji kursora nalazi element.
		 * Prolazimo kroz sve elemente u modelu i preko painter-a
		 * proveravamo da li se na zadatoj lokaciji nalazi element.
		*/
	   for (Painter painter : elementPainters){
		  
			if (painter.isElementAtX(x))
				return ((ElementPainter)painter).getElement();
		   
		  
		   }
		return null;
	}
   
   public class GGEController implements MouseListener, KeyListener, MouseWheelListener, MouseMotionListener  {
	      
	   
	  StateManager stateManager = new StateManager(gGEModel, GGEView.this);
   
      @Override
      public void mouseEntered(MouseEvent e) {
        stateManager.getCurrentState().mouseEntered(e);
      }
      
      @Override
      public void mouseReleased(MouseEvent e) {
        
    	  stateManager.getCurrentState().mouseReleased(e);
    
      }
    
      @Override
      public void mouseExited(MouseEvent e) {
        
    	  stateManager.getCurrentState().mouseExited(e);
      }
      
      @Override
      public void mousePressed(MouseEvent e) {
    	
    	  stateManager.getCurrentState().mousePressed(e);

		}

	@Override
	public void mouseClicked(MouseEvent e) {
		stateManager.getCurrentState().mouseClicked(e);
		
	}
	
	public void keyPressed(KeyEvent e) {

		stateManager.getCurrentState().keyPressed(e);

		
     }
     
     
     public void keyReleased(KeyEvent e) {
       
    	 stateManager.getCurrentState().keyReleased(e);
     }
     
    
     public void keyTyped(KeyEvent e) {
        
    	 stateManager.getCurrentState().keyTyped(e);
     }
     
    
     
     
     public void mouseDragged(MouseEvent e) {
    	 stateManager.getCurrentState().mouseDragged(e);
     }
     
   
     public void mouseMoved(MouseEvent e) {
    	 if(!(stateManager.getCurrentState() instanceof ZoomState) && GGEView.this.getComponentCount()==0){
    	 stateManager.getCurrentState().mouseMoved(e);
    	 Point2D point = e.getPoint();
		 pointToUserSpace(point);
    	 setMouseCursor(point);
    	 }
     }
     

     
     public void mouseWheelMoved(MouseWheelEvent e) {
    	 stateManager.getCurrentState().mouseWheelMoved(e);
      }
     
     public StateManager getStateManager(){
    	 return controller.stateManager;
     }
		
    
   }

public String getElementType() {
	
	return elementType;
}

public void setElementType(String elementType) {
	
	this.elementType = elementType;
}

public SelectionHandleHandler getHandleHandler() {
	return handleHandler;
}

public Handle getSelectedHandle() {
	return selectedHandle;
}

public void setSelectedHandle(Handle selectedHandle) {
	this.selectedHandle = selectedHandle;
}


public GGEModel getGGEModel() {
return gGEModel;
}


public AffineTransform getTransformation() {
return transformation;
}
public SelectionModel getSelection() {
	return selection;
}
public GGEController getController() {
	return controller;
}

public CommandManager getCommandManager() {
	return commandManager;
}
public Layer[] getLayer() {
    return layer;
 }
 
 
 public void setLayer(Layer[] newLayer) {
    this.layer = newLayer;
 }


public boolean isShowGrid() {
	return showGrid;
}


public void setShowGrid(boolean showGrid) {
	this.showGrid = showGrid;
}




public ElementPainter getElementPainter(GraphElement element){
	for(ElementPainter painter : elementPainters){
		if(painter.getElement() == element)
			return painter;
			
	}
	return null;
}

public LinkPainter getLinkPainter(Link element){
	for(LinkPainter painter : linkPainters){
		if(painter.getElement() == element)
			return painter;
			
	}
	return null;
}


@Override
public void autoscroll(Point cursorLocn) {
	Insets insets = getAutoscrollInsets();

	if (cursorLocn.getX() < insets.left)
		transformation.translate(10, 0);
	if (cursorLocn.getX() > insets.right)
		transformation.translate(-10, 0);
	if (cursorLocn.getY() < insets.top)
		transformation.translate(0, 10);
	if (cursorLocn.getY() > insets.bottom)
		transformation.translate(0, -10);
	
}


@Override
public Insets getAutoscrollInsets() {
	int top = (int) getVisibleRect().getMinY();
	int left = (int) getVisibleRect().getMinX();
	int bottom = (int) getVisibleRect().getMaxY();
	int right = (int) getVisibleRect().getMaxX();

	return new Insets(top, left, bottom, right);
}


}