package actions;

import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.Cursor;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

public class ISAhierarchyAction extends AbstractAction {


	
	public ISAhierarchyAction() {
		super();
		
		putValue(Action.NAME, "Add ISA hierarchy");
		putValue(Action.SHORT_DESCRIPTION, "Select to add ISA hierarchy on canvas");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/isa.PNG"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
	
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.setElementType("ISAhierarchy");
		currView.getController().getStateManager().setCurrentState(States.ADD_ELEMENT_STATE);
		currView.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
		 MainFrame.getInstance().getStatus().setStatus2("Add element");
	}

}
