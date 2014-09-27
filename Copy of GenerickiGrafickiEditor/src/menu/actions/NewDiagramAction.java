package menu.actions;

import gge.model.GGEModel;
import gge.model.Project;
import gge.view.GGEView;
import gui.MainFrame;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

public class NewDiagramAction extends AbstractAction {

	public NewDiagramAction() {
		super();
		
		// TODO Auto-generated constructor stub
		putValue(Action.NAME, "Diagram");
		putValue(Action.SHORT_DESCRIPTION, "New Diagram");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/File.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Project selektovan
		if (MainFrame.getInstance().getTree().getSelected() instanceof Project)
		{
			Project project= (Project)MainFrame.getInstance().getTree().getSelected();

			GGEModel newDiagram = new GGEModel("Diagram " + (project.getDiagramCount() + 1));
			newDiagram.addObserver(MainFrame.getInstance().getTree());	
			GGEView newView= new GGEView(newDiagram, MainFrame.getInstance());
			newView.setBackground(Color.WHITE);
			newView.setFocusable(true);
			MainFrame.getInstance().getViews().add(newView);
			
			Object[] pathToDiagram = new Object[3];
			pathToDiagram[0] = MainFrame.getInstance().getWorkspace();
			pathToDiagram[1] = project;
			pathToDiagram[2] = newDiagram;
			MainFrame.getInstance().getTree().makeVisible(new TreePath(pathToDiagram));
			
			project.addGGEModel(newDiagram);
			
			MainFrame.getInstance().getTabbedPane().addTab(newDiagram.getName(), null, newView);
			MainFrame.getInstance().getTabbedPane().setSelectedComponent(newView);
			

		} else
		{
			
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali projekat!",
					"Dodavanje dijagrama", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
