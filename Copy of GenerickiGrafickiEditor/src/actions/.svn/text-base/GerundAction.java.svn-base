package actions;

import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.Cursor;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

public class GerundAction extends AbstractAction {
	
	public GerundAction() {
		super();
		
		putValue(Action.NAME, "Dodaj gerund");
		putValue(Action.SHORT_DESCRIPTION, "Select to add gerund on canvas");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/gerund.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.setElementType("gerund");
		currView.getController().getStateManager().setCurrentState(States.ADD_ELEMENT_STATE);
		 MainFrame.getInstance().getStatus().setStatus2("Add element");
		currView.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

}
