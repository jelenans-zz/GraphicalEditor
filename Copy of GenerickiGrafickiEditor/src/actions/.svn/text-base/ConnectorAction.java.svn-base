package actions;

import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.Cursor;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

public class ConnectorAction extends AbstractAction {
	
	public ConnectorAction() {
		super();
	
		// TODO Auto-generated constructor stub
		putValue(Action.NAME, "Dodaj poveznik");
		putValue(Action.SHORT_DESCRIPTION, "Select to add connector on canvas");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/poveznik.jpg"));
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.setElementType("connector");
		currView.getController().getStateManager().setCurrentState(States.ADD_ELEMENT_STATE);
		currView.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		 MainFrame.getInstance().getStatus().setStatus2("Add element");
	}

}
