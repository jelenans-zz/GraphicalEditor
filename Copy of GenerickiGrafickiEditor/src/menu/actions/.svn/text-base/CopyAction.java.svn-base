package menu.actions;

import gge.gui.workspace.WorkspaceTree;
import gge.model.Clipboard;
import gge.model.Element;
import gge.model.GGEModel;
import gge.model.GraphElement;
import gge.view.GGEView;
import gui.MainFrame;
import gui.MainFrame.Focus;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;


public class CopyAction extends AbstractAction {
	
	public CopyAction() {
		super();
		// TODO Auto-generated constructor stub
		putValue(Action.NAME, "Copy");
		putValue(Action.SHORT_DESCRIPTION, "Copy");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/copy.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GGEView view= MainFrame.getInstance().getCurrentView();
		
		if(MainFrame.focus== Focus.Tree)
		{
		  if (MainFrame.getInstance().getTree().getSelected() instanceof GGEModel)
		  {

			  Clipboard.getInstance().putDiagrams(MainFrame.getInstance().getTree().getSelectionModel().getSelectionPaths());
			  
		  }else if(MainFrame.getInstance().getTree().getSelected() instanceof Element)
		  {
			  Clipboard.getInstance().putElements(MainFrame.getInstance().getTree().getSelectionModel().getSelectionPaths());
		  }
		}
		else if (MainFrame.focus== Focus.View)
		{
		    Clipboard.getInstance().putElements(view.getSelection().getElements());
		}
	}

}
