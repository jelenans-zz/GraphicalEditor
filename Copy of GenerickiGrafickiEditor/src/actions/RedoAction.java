package actions;

import gge.view.GGEView;
import gui.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;

@SuppressWarnings("serial")
public class RedoAction extends AbstractAction {
	
	public RedoAction() {
		super();
	
		putValue(Action.NAME, "Redo");
		putValue(Action.SHORT_DESCRIPTION, "Redo");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/redo.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		currView.getCommandManager().redo();
		
	}

}
