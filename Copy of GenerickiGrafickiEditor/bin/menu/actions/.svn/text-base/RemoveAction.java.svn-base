package menu.actions;

import gge.model.GGEModel;
import gge.model.Project;
import gge.model.Workspace;
import gge.view.GGEView;
import gui.MainFrame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class RemoveAction extends AbstractAction {

	public RemoveAction() {
		super();
		putValue(Action.NAME, "Remove");
		putValue(Action.SHORT_DESCRIPTION, "Remove dijagram/project/workspace");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/Delete.png"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		ArrayList<GGEView> views= MainFrame.getInstance().getViews();
	
		if (MainFrame.getInstance().getTree().getSelected() instanceof GGEModel)
		{
		GGEModel diagram= (GGEModel)MainFrame.getInstance().getTree().getSelected();
		Workspace current= MainFrame.getInstance().getWorkspace();
		ArrayList<Project> projects= current.getProjects();
		
		for (Project project : projects) {
			ArrayList<GGEModel> diagrams= project.getGGEModel();
			if(diagrams.contains(diagram))
			{	
				project.removeGGEModel(diagram);
				break;
			}
		}
		
		for(GGEView view: views)
		{
			GGEModel model= view.getGGEModel();
			if (model.equals(diagram))
			{
				MainFrame.getInstance().getTabbedPane().remove(view);
				return;
			}
		}

		} else if (MainFrame.getInstance().getTree().getSelected() instanceof Project)
		{
		Project selectedProject= (Project)MainFrame.getInstance().getTree().getSelected();
		
		Workspace current= MainFrame.getInstance().getWorkspace();
		ArrayList<Project> projects= current.getProjects();
		
		for (Project project : projects) {
			ArrayList<GGEModel> diagrams= project.getGGEModel();

			for(GGEView view: views)
			{
				GGEModel model= view.getGGEModel();
				if (diagrams.contains(model))
				{
					MainFrame.getInstance().getTabbedPane().remove(view);

				}
			}
			if(project.equals(selectedProject))
			{	
				current.removeProject(selectedProject);
				return;
			}
		}

		}
		{
		
		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali projekat/dijagram!",
				"Uklanjanje dijagrama", JOptionPane.INFORMATION_MESSAGE);
		}
	
	}

}
