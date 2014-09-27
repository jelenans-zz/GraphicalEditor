package menu.actions;

import gge.model.GGEModel;
import gui.MainFrame;
import gui.RenameFileDialog;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class RenameAction extends AbstractAction {

	public RenameAction() {
		super();
	
		// TODO Auto-generated constructor stub
		putValue(Action.NAME, "Rename...");
		putValue(Action.SHORT_DESCRIPTION, "Rename File"); 
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (MainFrame.getInstance().getTree().getSelected()!= null)
		{
			Object selected= MainFrame.getInstance().getTree().getSelected();
			RenameFileDialog rename = new RenameFileDialog(selected);
			rename.setVisible(true);
			
		}else
		{
			
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali komponentu za izmenu naziva!",
					"Preimenovanje komponente", JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
