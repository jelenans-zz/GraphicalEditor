package menu.actions;

import gge.model.GGEModel;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;

public class OpenDiagramAction extends AbstractAction {

	public OpenDiagramAction() {
		super();
		
		// TODO Auto-generated constructor stub
		putValue(Action.NAME, "Open Diagram");
		putValue(Action.SHORT_DESCRIPTION, "Open diagram");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/open.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.SHIFT_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		if (MainFrame.getInstance().getTree().getSelected() instanceof GGEModel)
		{
		GGEModel diagram= (GGEModel)MainFrame.getInstance().getTree().getSelected();
		ArrayList<GGEView> views= MainFrame.getInstance().getViews();
		
		for(GGEView view: views)
		{
			GGEModel model= view.getGGEModel();
			if (model.equals(diagram))
			{
			  for(Component c: MainFrame.getInstance().getTabbedPane().getComponents())
			  {
				  if(c.equals(view))
					  return;
			  }
				MainFrame.getInstance().getTabbedPane().addTab(diagram.getName(), null, view);
				MainFrame.getInstance().getTabbedPane().setSelectedComponent(view);
				return;
			}
		}
	
		} else
		{
			
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali dijagram!",
					"Otvaranje dijagrama", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
