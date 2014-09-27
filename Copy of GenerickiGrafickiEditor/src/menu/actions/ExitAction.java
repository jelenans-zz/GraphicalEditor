package menu.actions;

import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;

public class ExitAction extends AbstractAction {

	public ExitAction() {
		super();
	
		// TODO Auto-generated constructor stub
		putValue(Action.NAME, "Exit");
		putValue(Action.SHORT_DESCRIPTION, "Exit");
		putValue(MNEMONIC_KEY, KeyEvent.VK_X);
		//putValue(Action.SMALL_ICON, new ImageIcon("Slike/Floppy.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		int code = JOptionPane.showConfirmDialog(MainFrame.getInstance(),
				"Da li ste sigurni da zelite da zatvorite aplikaciju?",
				"Zatvaranje aplikacije", JOptionPane.YES_NO_OPTION);
		if (code != JOptionPane.YES_OPTION) {
			return;
		} else {
			System.exit(1);
		}
		
	}

}
