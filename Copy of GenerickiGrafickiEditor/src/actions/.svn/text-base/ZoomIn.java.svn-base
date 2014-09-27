package actions;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;


import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;



public class ZoomIn extends AbstractAction{
	
	public ZoomIn() {
		super();
	
		
		putValue(Action.NAME, "Uvecaj");
		putValue(Action.SHORT_DESCRIPTION, "ZoomIn");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/ZoomIN.jpg"));
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		MainFrame.getInstance().getStatus().setStatus2("Zoom In");
		currView.getController().getStateManager().setCurrentState(States.ZOOM_IN_STATE);
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image src=tk.getImage("Slike/ZoomIN.jpg");
		Cursor cursor = tk.createCustomCursor(src, new Point(0,0), "Custom Cursor");

		currView.setCursor(cursor);
		 MainFrame.getInstance().getStatus().setStatus2("Zoom In");
		
	}
}
