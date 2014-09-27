
package gge.state;

import gge.command.CutElementCommand;
import gge.command.DeleteElementCommand;
import gge.command.MoveCommand;
import gge.command.PasteCommand;
import gge.gui.workspace.WorkspaceTree;
import gge.model.Clipboard;
import gge.model.Element;
import gge.model.GraphElement;
import gge.model.Link;
import gge.state.StateManager.States;
import gge.view.ElementPainter;
import gge.view.GGEView;
import gge.view.LinkPainter;
import gge.view.Painter;
import gui.FindDialog;
import gui.MainFrame;
import gui.MainFrame.Focus;
import gui.PopUp;

import java.awt.Cursor;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Point2D.Double;
import java.util.ArrayList;

import javax.swing.JTextField;

import menu.actions.SelectAllAction;


public class SelectElementState extends State {
	public static boolean cut=false;
	GGEView view;
	public static Element currentElement = null;

	Point2D lastPosition;
	static final double scalingFactor = 1.2;
	static final double translateFactor = 10;
	private int startXPos, startYPos;
	private boolean levi;
	private boolean mousePressedInThisState = false;
	private boolean skrol=false;
	Point2D mousePos ;
	
	public SelectElementState(GGEView view){
		this.view = view;	
		this.view.requestFocusInWindow();
  	   // MainFrame.focus= Focus.View;
		levi = false;
		
	}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseReleased(MouseEvent e) {
	GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
	currView.requestFocusInWindow();
	view.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	MainFrame.focus= Focus.View;
	 mousePos = e.getPoint();
	view.pointToUserSpace(mousePos);
	 if (e.getButton() == MouseEvent.BUTTON1) {
		 
			if (currentElement != null ) {
				if(!e.isControlDown()) //nije stisnut ctrl
				view.getSelection().removeAllElements();
				
					if(currentElement instanceof GraphElement){
						if(!view.getSelection().getElements().contains(currentElement)){
							view.getSelection().addElements((GraphElement)currentElement);
							if(view.getSelection().getElements().size()==1){
								MainFrame.getInstance().setPositonEl("Position:");
								MainFrame.getInstance().setSize("Size:");
								
								MainFrame.getInstance().setNameLbl(currentElement.getName());
								int x=(int) ((GraphElement) currentElement).getPosition().getX();
								int y=(int) ((GraphElement) currentElement).getPosition().getY();
								MainFrame.getInstance().setTypeLbl(((GraphElement) currentElement).getType());
								MainFrame.getInstance().setPosLbl("X:"+x+",Y:"+y);
								int w=(int) ((GraphElement) currentElement).getSize().getWidth();
								int h=(int) ((GraphElement) currentElement).getSize().getHeight();
								MainFrame.getInstance().setSizeLbl("W:"+w+",H"+h);
							}else{
								MainFrame.getInstance().setNameLbl(view.getSelection().getElements().size()+" elements");
								MainFrame.getInstance().setPosLbl("");
								MainFrame.getInstance().setTypeLbl("");
								MainFrame.getInstance().setSizeLbl("");
							}
						
						}
						else 
							view.getSelection().removeElements((GraphElement)currentElement);
					view.repaint();
					MainFrame.getInstance().getToolbar().getAlign().setEnabled(true);
					MainFrame.getInstance().getToolbar().getAlignTop().setEnabled(true);
					MainFrame.getInstance().getToolbar().getDelete().setEnabled(true);
					}else if(currentElement instanceof Link){
						if(!view.getSelection().getElements().contains(currentElement)){
							view.getSelection().addElements((Link)currentElement);
							if(view.getSelection().getElements().size()==1){
								MainFrame.getInstance().setNameLbl(((Link)currentElement).getName());
								MainFrame.getInstance().setTypeLbl(((Link)currentElement).getType());
								MainFrame.getInstance().setSize("Second:");
								MainFrame.getInstance().setPositonEl("First:");
							MainFrame.getInstance().setPosLbl(((Link)currentElement).getFirst().getName());//pos->prvi
							MainFrame.getInstance().setSizeLbl(((Link)currentElement).getSecond().getName());//size->drugi
							}else{
								MainFrame.getInstance().setNameLbl(view.getSelection().getElements().size()+" elements");
								MainFrame.getInstance().setPosLbl("");
								MainFrame.getInstance().setTypeLbl("");
								MainFrame.getInstance().setSizeLbl("");
							}
						}
						else 
							view.getSelection().removeElements((Link)currentElement);
						view.repaint();
					}
				if(view.getSelection().getElements().size()>1){
					ArrayList<Element> elements=(ArrayList<Element>) view.getGGEModel().getElements();
					for(Element el:elements){
						
						if(el instanceof Link){
							GraphElement prvi=((Link) el).getFirst();
							GraphElement drugi=((Link) el).getSecond();
							if(view.getSelection().getElements().contains(prvi)&&view.getSelection().getElements().contains(drugi)){
								if(!view.getSelection().getElements().contains(el))
								view.getSelection().addElements(el);
							}
							
						}
						
					}
					
				}
			
			}
			
			if(currentElement==null){ // negde na prazno je kliknuto

				view.getSelection().removeAllElements();
				view.repaint();
				MainFrame.getInstance().getToolbar().getAlign().setEnabled(false);
				MainFrame.getInstance().getToolbar().getAlignTop().setEnabled(false);
				MainFrame.getInstance().getToolbar().getDelete().setEnabled(false);
				MainFrame.getInstance().setNameLbl("");
				MainFrame.getInstance().setPosLbl("");
				MainFrame.getInstance().setSizeLbl("");
				MainFrame.getInstance().setTypeLbl("");
			}
		
			
			 MainFrame.getInstance().getStatus().setStatus2("Selection");
			
	 }
	 if (e.getButton() == MouseEvent.BUTTON3)
		 {
		 view.getSelection().removeAllElements();
		 	view.repaint();
		 PopUp pop = new PopUp(); 
		 currentElement = view.getElementAtPosition(e.getPoint());
		 if(currentElement != null){
			view.getSelection().addElements(currentElement);
		 	pop.show(view, (int)e.getX(),(int) e.getY());
		 }else if(currentElement == null){
			 
			 pop.PopUpMeniVanElementa();
			 pop.show(view, (int)e.getX(),(int) e.getY());
		 }
		 
		 	//view.getSelection().removeAllElements();
		 	//view.repaint();
		 	MainFrame.getInstance().getToolbar().getAlign().setEnabled(false);
			MainFrame.getInstance().getToolbar().getAlignTop().setEnabled(false);
			MainFrame.getInstance().getToolbar().getDelete().setEnabled(false);
		 	
		 }
	// currentElement = null;
	 mousePressedInThisState = false;
	 view.setSelectedHandle(null);

}

@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mousePressed(MouseEvent e) {
	
	startXPos=e.getX();
	startYPos=e.getY();
	
	lastPosition = e.getPoint();
	view.pointToUserSpace(lastPosition);
			
	//currentElement = view.getElementAtPosition(lastPosition);
	
	
	// Proveravamo da li se na poziciji miÅ¡a nalazi hendl
	Element selectedElement = (Element) view.getSelection().getSingleSelectedElement();
	if (selectedElement != null ){
		if(selectedElement instanceof GraphElement)
		view.setSelectedHandle(view.getHandleHandler().getHandleForPoint((GraphElement)selectedElement, lastPosition, view.getTransformation().getScaleX()));
		
	}
	// Ako nemamo hendl, proveravamo elemente
	if (view.getSelectedHandle() == null)
		if (e.getButton() == MouseEvent.BUTTON1) {
			currentElement = view.getElementAtPosition(lastPosition);
			levi = true;
		}
	 if(MainFrame.getInstance().getScrolZaTabbedPane().contains((Point) lastPosition)){
		 skrol=true;
	 }
	mousePressedInThisState = true;
}

@Override
public void keyPressed(KeyEvent e) {
	
	
	if(e.getKeyCode() == KeyEvent.VK_DELETE) { //&& currentElement != null
		ArrayList<LinkPainter> vezeZaBrisanje = new ArrayList<LinkPainter>();
		for(Element el: view.getSelection().getElements()){
			if(el instanceof GraphElement){
			for(LinkPainter linkP: view.getLinkPainters()){
				if(((Link)linkP.getElement()).getFirst().equals(el)||((Link)linkP.getElement()).getSecond().equals(el))
					vezeZaBrisanje.add(linkP);
			}
			
			}
		}
			
		view.getCommandManager().executeCommand(new DeleteElementCommand(view.getGGEModel(),view,view.getSelection().getElements(),view.selectedElementsPainters(),vezeZaBrisanje));
		
	}
	
	else if (e.getKeyCode() == KeyEvent.VK_C && e.isControlDown()){
	{
		GGEView view= MainFrame.getInstance().getCurrentView();
//		WorkspaceTree tree= MainFrame.getInstance().getTree();
//	
//			System.out.println("DIAGRAM HAS FOCUS");
		    Clipboard.getInstance().putElements(view.getSelection().getElements());

	}
	}
	else if (e.getKeyCode() == KeyEvent.VK_X && e.isControlDown())
	{
		cut=true;

		
		ArrayList<LinkPainter> vezeZaBrisanje = new ArrayList<LinkPainter>();
		for(Element el: view.getSelection().getElements())
		{
			if(el instanceof GraphElement)
			{
				for(LinkPainter linkP: view.getLinkPainters())
				{
					if(((Link)linkP.getElement()).getFirst().equals(el)||((Link)linkP.getElement()).getSecond().equals(el))
						vezeZaBrisanje.add(linkP);
				}
		
			}
		}
	
		view.getCommandManager().executeCommand(new CutElementCommand(view.getGGEModel(),view,view.getSelection().getElements(),
				view.selectedElementsPainters(),vezeZaBrisanje));
	
	} else if (e.getKeyCode() == KeyEvent.VK_V && e.isControlDown()) {
		
		


		view.getCommandManager().executeCommand(new PasteCommand(view,SelectElementState.cut));

	}
	if(e.getKeyCode()==KeyEvent.VK_UP){
		
		view.getCommandManager().executeCommand(new MoveCommand(view,0 ,-translateFactor));
		

		
	}
	if(e.getKeyCode()==KeyEvent.VK_DOWN){
		
		view.getCommandManager().executeCommand(new MoveCommand(view,0 ,translateFactor));
		
	}
	if(e.getKeyCode()==KeyEvent.VK_LEFT){
	
		view.getCommandManager().executeCommand(new MoveCommand(view,-translateFactor,0));
		
	}
	if(e.getKeyCode()==KeyEvent.VK_RIGHT){
	
		view.getCommandManager().executeCommand(new MoveCommand(view,translateFactor,0));
		
	}else if (e.getKeyCode() == KeyEvent.VK_F && e.isControlDown()){
	
		FindDialog fd=new FindDialog();
		fd.setVisible(true);
	}else if (e.getKeyCode() == KeyEvent.VK_A && e.isControlDown()){
		SelectAllAction sa=new SelectAllAction();
		sa.actionPerformed(null);
	}else if (e.getKeyCode() == KeyEvent.VK_Z && e.isControlDown()){
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.getCommandManager().undo();
	} else if (e.getKeyCode() == KeyEvent.VK_Y && e.isControlDown()){
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.getCommandManager().redo();
	}
	
}

@Override
public void keyReleased(KeyEvent e) {
	
}

@Override
public void keyTyped(KeyEvent e) {
	// TODO Auto-generated method stub
	
}

@Override
public void mouseWheelMoved(MouseWheelEvent e) {
	int valueH=MainFrame.getInstance().getScrolZaTabbedPane().getHorizontalScrollBar().getValue();
	int valueV=MainFrame.getInstance().getScrolZaTabbedPane().getVerticalScrollBar().getValue();
	  
	if(e.isControlDown()) {     // Ako je pritisnut Ctrl, radimo zoom u tački
		  
	      // Prvo je potrebno da odredimo novo skaliranje:
	      double newScaling = view.getTransformation().getScaleX();
	      if(e.getWheelRotation() > 0)
	        newScaling *= (double)e.getWheelRotation() * scalingFactor;
	      else
	        newScaling /= -(double)e.getWheelRotation() * scalingFactor;
	      // Zatim je potrebno da skaliranje održimo u intervalu [0.2, 5]
	      if(newScaling < 0.2)
	        newScaling = 0.2;
	      if(newScaling > 5)
	        newScaling = 5;
	    
	      // Poništavanje "smicanja":
	      Point2D oldPosition = e.getPoint();
	      view.pointToUserSpace(oldPosition);

	      view.getTransformation().setToScale(newScaling, newScaling);

	      Point2D newPosition = e.getPoint();
	      view.pointToUserSpace(newPosition);

	      view.getTransformation().translate(newPosition.getX() - oldPosition.getX(),
	        newPosition.getY() - oldPosition.getY());
	     
	      //prikaz procenata u toolbaru 
	      String procenti = (int)(view.getTransformation().getScaleX()*100) + "%";
		  MainFrame.getInstance().setEditedItemInCmb(procenti);
		   
		  
		  //skrolbarovi
	     int oldExtent = MainFrame.getInstance().getScrolZaTabbedPane().getVerticalScrollBar().getModel().getExtent();
	      MainFrame.getInstance().getScrolZaTabbedPane().getVerticalScrollBar().getModel().setExtent((int)(oldExtent/view.getTransformation().getScaleX()));
	      
	    }else if (e.isShiftDown()) { 		// Ako je pritisnut Shift
			view.getTransformation().translate(e.getWheelRotation()
					* translateFactor / view.getTransformation().getScaleX(), 0);
			
//			MainFrame.getInstance().getScrolZaTabbedPane().getHorizontalScrollBar().setValue(valueH+e.getWheelRotation()*10);
//			
//			 System.out.println(MainFrame.getInstance().getScrolZaTabbedPane().getHorizontalScrollBar().getValue());
	    } else { 							// u ostalim sluÄ�ajevima vrÅ¡imo skrolovanje po Y osi
			view.getTransformation().translate(0, - e.getWheelRotation()
					* translateFactor /view.getTransformation().getScaleY());
//			  Rectangle rect = new Rectangle((int)(view.getVisibleRect().getX()-view.getVisibleRect().width/2),(int)(view.getVisibleRect().getY()- view.getVisibleRect().height/2),view.getVisibleRect().width, view.getVisibleRect().height);
//			  MainFrame.getInstance().getScrolZaTabbedPane().scrollRectToVisible(rect);
//			  Rectangle currentdim = view.getVisibleRect();
//			  
//			  view.setPreferredSize(new Dimension(currentdim.getSize().width,(int)(currentdim.getSize().width + e.getWheelRotation()
//						* translateFactor /view.getTransformation().getScaleY())));
//			  view.revalidate();
			
//			MainFrame.getInstance().getScrolZaTabbedPane().getVerticalScrollBar().setValue(valueV+e.getWheelRotation()*10);
//			int visAmount=MainFrame.getInstance().getScrolZaTabbedPane().getVerticalScrollBar().getVisibleAmount();
//			if(MainFrame.getInstance().getScrolZaTabbedPane().getVerticalScrollBar().getValue()==0){
//				
//				MainFrame.getInstance().getScrolZaTabbedPane().getVerticalScrollBar().setVisibleAmount(visAmount+e.getWheelRotation()*10);
			//}
			

			// System.out.println(MainFrame.getInstance().getScrolZaTabbedPane().getVerticalScrollBar().getValue());
		}

	
	    view.repaint();
	
}

@Override
public void mouseDragged(MouseEvent e) {
	
	Point2D mousePos = e.getPoint();
	view.pointToUserSpace(mousePos);
	
	
	//lasso selekcija 
	if(currentElement == null &&levi) // pritisnuto je na prazno
	{
		view.getSelection().removeAllElements();
		//view.repaint();
		view.getController().getStateManager().setLassoStart(mousePos.getX(), mousePos.getY());
		view.getController().getStateManager().setCurrentState(States.LASSO_SELECTION_STATE);
		 MainFrame.getInstance().getStatus().setStatus2("Lasso selection");
	}else if(currentElement!=null&&levi)
	{
		
	if(!view.getSelection().isEmpty() && mousePressedInThisState) {
//	Point2D mousePos = e.getPoint();
//	view.pointToUserSpace(mousePos);
	//view.pointToUserSpace(new Point2D.Double(startXPos,startYPos));
		
	if(view.getSelectedHandle() != null) {
		//resize state
		//view.getController().getStateManager().setLastPossition(lastPosition);
		//view.getController().getStateManager().setCurrentState(States.RESIZE_STATE);
	}else{//MOVESTATE
		
		if(currentElement instanceof Link){
			view.getController().getStateManager().setTackaPomeranjeDeo(lastPosition);
			view.getController().getStateManager().setCurrentState(States.DEFORM_LINK_STATE);
			
		}
		else {
		view.getController().getStateManager().setLassoStart(mousePos.getX(), mousePos.getY());
		MainFrame.getInstance().getStatus().setStatus2("Move element");
		view.getController().getStateManager().setCurrentState(States.MOVE_STATE);
		}
	}
  
	}
	
	
	}
	
	
}

@Override
public void mouseMoved(MouseEvent e) {

	MainFrame.getInstance().getStatus().setStatus3(e.getX(),e.getY());
	MainFrame.getInstance().getStatus().setStatus2("Selection");
}

@Override
public void mouseClicked(MouseEvent e) {
	 mousePos = e.getPoint();
		view.pointToUserSpace(mousePos);
	if(e.getClickCount() == 2){
		currentElement = view.getElementAtPosition(mousePos);
		if(currentElement != null){
		
		final JTextField tf = new JTextField(currentElement.getName(),10);
		tf.addKeyListener(new KeyListener() {
			
			
			@Override
			public void keyTyped(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER){
					currentElement.setName(tf.getText().trim());
					tf.setVisible(false);
					view.remove(tf);
					view.getGGEModel().fireUpdates();
					view.repaint();
				}
				
			}
		});
		if(currentElement instanceof Link){
			
			double XX = 0;
			double YY = 0;
			if(((Link) currentElement).getBreakPoints().size()>1){
			
			int brojTacke =((Link) currentElement).getBreakPoints().size()/2;
			XX = (((Link) currentElement).getBreakPoints().get(brojTacke -1 ).getX() + ((Link) currentElement).getBreakPoints().get(brojTacke).getX());
			YY = (((Link) currentElement).getBreakPoints().get(brojTacke -1 ).getY() + ((Link) currentElement).getBreakPoints().get(brojTacke).getY());
				
				}
			if(((Link) currentElement).getBreakPoints().size() == 1){
				XX = 2*((Link) currentElement).getBreakPoints().get(0).getX() + 20;
				YY = 2*((Link) currentElement).getBreakPoints().get(0).getY() - 20;
			}
			if(((Link) currentElement).getBreakPoints().isEmpty()){
				XX = (((Link) currentElement).getPocetnaTacka().getX() + ((Link) currentElement).getKrajnjaTacka().getX()) ;
				YY = (((Link) currentElement).getPocetnaTacka().getY() + ((Link) currentElement).getKrajnjaTacka().getY()) -20 ;
				
			}
			
			LinkPainter p = view.getLinkPainter((Link) currentElement);
			
			Rectangle rec = new Rectangle((int) ((XX/p.getElementTransformation().getScaleX()) / 2)-35, (int) ((YY/p.getElementTransformation().getScaleY())  / 2)-3, 75, 20);
			tf.setBounds(rec);
	
			if(rec.contains(mousePos)){
			MainFrame.getInstance().getView().add(tf);
			
			//while(tf.hasFocus()){
			//	tf.selectAll();
			//}
			
			}
			}
		else {   //graphElement je
			
			ElementPainter p = view.getElementPainter((GraphElement) currentElement);
			
			int x = (int) (((((GraphElement) currentElement).getSize().getWidth()/p.getElementTransformation().getScaleX())/2)-35/p.getElementTransformation().getScaleX()  + ((GraphElement) currentElement).getPosition().getX());
			int y = (int) (((((GraphElement) currentElement).getSize().getHeight()/p.getElementTransformation().getScaleY())/2)-3/p.getElementTransformation().getScaleY() + ((GraphElement) currentElement).getPosition().getY());
			Point2D tacka = new Point2D.Double(x,y);
			view.pointToUserSpace(tacka);
		
			Rectangle rec = new Rectangle(x,y, (int)(75*p.getElementTransformation().getScaleX()*view.getTransformation().getScaleX()),(int)(20*p.getElementTransformation().getScaleX()*view.getTransformation().getScaleX()));
			tf.setBounds(rec);
			
			if(rec.contains(mousePos)){
			MainFrame.getInstance().getView().add(tf);
			tf.selectAll();
			
			}
			
		}
		
		
	}
		
	}
	else {
		if(view.getComponentCount()!=0)
		view.remove(0);
		
	}
}
@Override
public void paint(Graphics2D g2) {
	// TODO Auto-generated method stub
	
}



}