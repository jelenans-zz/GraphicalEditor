package actions;


import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class RectangleAction extends AbstractAction {
	
	public RectangleAction() {
		super();
		
		
		putValue(Action.NAME, "Add entity");
		putValue(Action.SHORT_DESCRIPTION, "Select to add entity on canvas");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/pravougaonik.jpg"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.setElementType("entity");
		currView.getController().getStateManager().setCurrentState(States.ADD_ELEMENT_STATE);
		currView.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		 MainFrame.getInstance().getStatus().setStatus2("Add element");
	}

}
