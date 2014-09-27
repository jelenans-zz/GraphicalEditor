package actions;


import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.Cursor;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

public class WeakEntityAction extends AbstractAction {
	
	
	public WeakEntityAction() {
		super();
		
		putValue(Action.NAME, "Add weak entity");
		putValue(Action.SHORT_DESCRIPTION, "Select to add weak entity on canvas");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/weakEntity.png"));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.setElementType("weakEntity");
		currView.getController().getStateManager().setCurrentState(States.ADD_ELEMENT_STATE);
		currView.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		 MainFrame.getInstance().getStatus().setStatus2("Add element");
	}

}
