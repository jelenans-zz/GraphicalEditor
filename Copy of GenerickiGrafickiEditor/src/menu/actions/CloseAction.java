package menu.actions;

import gge.model.GGEModel;
import gge.view.GGEView;
import gui.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;


@SuppressWarnings("serial")
public class CloseAction extends AbstractAction {

	public CloseAction() {
		super();
	
		// TODO Auto-generated constructor stub
		putValue(Action.NAME, "Close diagram");
		putValue(Action.SHORT_DESCRIPTION, "Close dijagram");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/close.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_4, ActionEvent.SHIFT_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		

		if (MainFrame.getInstance().getTree().getSelected() instanceof GGEModel)
		{
//			
			GGEModel diagram= (GGEModel)MainFrame.getInstance().getTree().getSelected();
			ArrayList<GGEView> views= MainFrame.getInstance().getViews();
			
			for(GGEView view: views)
			{
				GGEModel model= view.getGGEModel();
				if (model.equals(diagram))
				{
					if(model.isSacuvano(false)){
						
					}
					MainFrame.getInstance().getTabbedPane().remove(view);
					return;
				}

			}

		}
	}

}
