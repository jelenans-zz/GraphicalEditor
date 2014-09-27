package actions;




import gge.command.Command;
import gge.command.DeleteElementCommand;
import gge.model.Element;
import gge.model.GGEModel;
import gge.model.GraphElement;
import gge.model.Link;
import gge.state.StateManager.States;
import gge.view.GGEView;
import gge.view.LinkPainter;
import gge.view.Painter;
import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import javax.swing.tree.TreePath;

import menu.actions.RemoveAction;

import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

@SuppressWarnings("serial")
public class DeleteElementAction extends AbstractAction {

	public DeleteElementAction() {
		super();
	
		putValue(Action.NAME, "Delete");
		putValue(Action.SHORT_DESCRIPTION, "Delete");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/Delete.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_D, ActionEvent.CTRL_MASK));

	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GGEView currView= null;
		int v=0;
	    List<Element> selectedElements=null; 
		ArrayList<Painter> selectedPainters = null;
		
		if(((GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent()) !=null)
		   currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		else
		{
			v=1;
		
			TreePath parentPath= MainFrame.getInstance().getTree().getSelectionModel().getLeadSelectionPath().getParentPath();
			GGEModel parent= (GGEModel)parentPath.getLastPathComponent();

		

			ArrayList<GGEView> views= MainFrame.getInstance().getViews();
	    
			for(GGEView view: views)
			{
				GGEModel model= view.getGGEModel();
				if (model.equals(parent))
				{
					currView=view;
					break;
				}
			}
			
		    TreePath[] selectionPaths=MainFrame.getInstance().getTree().getSelectionModel().getSelectionPaths();			    
		    selectedElements = new ArrayList<Element>();
		    selectedPainters = new ArrayList<Painter>();
		    
			for(int i=0;i< selectionPaths.length;i++)
			{
	           if(selectionPaths[i].getLastPathComponent() instanceof Element)
				{
					Element elem= (Element)selectionPaths[i].getLastPathComponent();
					selectedPainters.add(MainFrame.getInstance().getView().getElementPainter((GraphElement)elem));
					selectedElements.add(elem);
				}
			}
		
		}
		ArrayList<LinkPainter> vezeZaBrisanje = new ArrayList<LinkPainter>();
		for(Element el: currView.getSelection().getElements()){
			if(el instanceof GraphElement){
			for(LinkPainter linkP: currView.getLinkPainters()){
				if(((Link)linkP.getElement()).getFirst().equals(el)||((Link)linkP.getElement()).getSecond().equals(el))
					vezeZaBrisanje.add(linkP);
			}
			
			}
		}
		
		System.out.println("currView DEL: "+currView.getGGEModel().getName());
		if(v==0)
			currView.getCommandManager().executeCommand(new DeleteElementCommand(currView.getGGEModel(), currView, currView.getSelection().getElements(), currView.selectedElementsPainters(),vezeZaBrisanje));
		else
			currView.getCommandManager().executeCommand(new DeleteElementCommand(currView.getGGEModel(), currView, selectedElements,selectedPainters ,vezeZaBrisanje));
	}

}
