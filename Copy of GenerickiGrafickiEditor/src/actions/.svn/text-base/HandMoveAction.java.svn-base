package actions;

import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class HandMoveAction extends AbstractAction {
	
	public HandMoveAction() {
		super();
	
		putValue(Action.NAME, "Grabber");
		putValue(Action.SHORT_DESCRIPTION, "Use hand to move canvas");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/hand_curs.jpg"));
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.setElementType("moveCanvas");
		currView.getController().getStateManager().setCurrentState(States.MOVE_CANVAS);
		currView.getSelection().removeAllElements();
		
		Toolkit tk=Toolkit.getDefaultToolkit();
		Image src=tk.getImage("Slike/handispruzena.jpg");
		Cursor cursor = tk.createCustomCursor(src, new Point(0,0), "Custom Cursor");

		currView.setCursor(cursor);
		 MainFrame.getInstance().getStatus().setStatus2("Move canvas");
			
	}

}
