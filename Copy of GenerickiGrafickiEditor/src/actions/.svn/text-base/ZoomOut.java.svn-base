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



public class ZoomOut extends AbstractAction{
	
	
	
	public ZoomOut() {
		super();
		
		putValue(Action.NAME, "Smanji");
		putValue(Action.SHORT_DESCRIPTION, "ZoomOut");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/ZoomOut.jpg"));
		
	}


	@Override
	public void actionPerformed(ActionEvent arg0) {
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.getController().getStateManager().setCurrentState(States.ZOOM_OUT_STATE);
		MainFrame.getInstance().getStatus().setStatus2("Zoom Out");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image src=tk.getImage("Slike/ZoomOut.jpg");
		Cursor cursor = tk.createCustomCursor(src, new Point(0,0), "Custom Cursor");

		currView.setCursor(cursor);
		 MainFrame.getInstance().getStatus().setStatus2("Zoom Out");
	}
}
