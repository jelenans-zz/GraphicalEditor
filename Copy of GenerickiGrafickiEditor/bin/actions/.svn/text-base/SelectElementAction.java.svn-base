package actions;

import gge.model.GGEModel;
import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class SelectElementAction extends AbstractAction {
	
	public SelectElementAction() {
		super();
	
		putValue(Action.NAME, "Select Element");
		putValue(Action.SHORT_DESCRIPTION, "Select Element");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/kursor.jpg"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.setElementType("selection");
		currView.getController().getStateManager().setCurrentState(States.SELECT_ELEMENTS_STATE);
		currView.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		
		 
	}

}
