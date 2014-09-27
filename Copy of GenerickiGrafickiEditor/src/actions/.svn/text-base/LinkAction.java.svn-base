package actions;

import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.MainFrame;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;

public class LinkAction extends AbstractAction {

	public LinkAction() {
		super();
		
		putValue(Action.NAME, "Dodaj vezu");
		putValue(Action.SHORT_DESCRIPTION, "Select to add link on canvas");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/veza.jpg"));
	}
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.setElementType("link");
		currView.getController().getStateManager().setCurrentState(States.LINK_STATE);
		 MainFrame.getInstance().getStatus().setStatus2("Connect elements");
	}

}
