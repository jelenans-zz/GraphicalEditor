package menu.actions;


import gge.model.Project;
import gge.model.Workspace;
import gui.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class NewProjectAction extends AbstractAction {

	public NewProjectAction() {
		super();
		
		// TODO Auto-generated constructor stub
		putValue(Action.NAME, "Project");
		putValue(Action.SHORT_DESCRIPTION, "New project");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/newp.jpg"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		

		if (MainFrame.getInstance().getTree().getSelected() instanceof Workspace)
		{
			Workspace workspace= (Workspace)MainFrame.getInstance().getTree().getSelected();
			Project newProject = new Project("Project " + (workspace.getProjectCount() + 1));		
			newProject.addObserver(MainFrame.getInstance().getTree());
			
			workspace.addProject(newProject);
			
		}
		else
		{
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali workspace!",
					"Dodavanje projekta", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
