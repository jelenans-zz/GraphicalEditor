package menu.actions;

import gge.command.CommandManager;
import gge.command.PasteCommand;
import gge.gui.workspace.WorkspaceTree;
import gge.model.Atribute;
import gge.model.Clipboard;
import gge.model.Connector;
import gge.model.Element;
import gge.model.Entity;
import gge.model.GGEModel;
import gge.model.Gerund;
import gge.model.GraphElement;
import gge.model.ISAhierarchy;
import gge.model.Project;
import gge.model.WeakEntity;
import gge.state.SelectElementState;
import gge.view.AtributePainter;
import gge.view.ConnectorPainter;
import gge.view.ElementPainter;
import gge.view.EntityPainter;
import gge.view.GGEView;
import gge.view.GerundPainter;
import gge.view.ISAhierarchyPainter;
import gge.view.WeakEntityPainter;
import gui.MainFrame;
import gui.MainFrame.Focus;

import java.awt.Color;
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



public class PasteAction extends AbstractAction {
	


	public PasteAction() {
		super();
		
		putValue(Action.NAME, "Paste");
		putValue(Action.SHORT_DESCRIPTION, "Paste");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/paste.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));

		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GGEView view= MainFrame.getInstance().getCurrentView();

		if(MainFrame.focus== Focus.Tree)
		{

		  if (MainFrame.getInstance().getTree().getSelected() instanceof Project)
		  {
					 Project proj= (Project)MainFrame.getInstance().getTree().getSelected();
					 int i=0;
					 
					 for (GGEModel diag : Clipboard.getInstance().getDiagrams())
					 {
						 //System.out.println("diag_name: "+diag.getName());
						if(!SelectElementState.cut)
							diag.setName(diag.getName()+ "_copy");
						
						GGEView viewNew= new GGEView(diag, MainFrame.getInstance());
						viewNew.setBackground(Color.WHITE);
						viewNew.setFocusable(true);
						ElementPainter painter=null;
						for(Element elem: diag.getElements())
						{
							GraphElement element=(GraphElement)elem;
							
							if(elem instanceof Atribute)
								painter = new AtributePainter(element);
							if(elem instanceof Entity)
								painter = new EntityPainter(element);
							if(elem instanceof ISAhierarchy)
								painter = new ISAhierarchyPainter(element);
							if(elem instanceof WeakEntity)
								painter = new WeakEntityPainter(element);
							if(elem instanceof Gerund)
								painter = new GerundPainter(element);
							if(elem instanceof Connector)
								painter = new ConnectorPainter(element);
							
							viewNew.getElementPainters().add(painter);
						}
						
						 for(GGEModel d: proj.getGGEModel())
						  {
							  if((diag.getName()).equals(d.getName()))
								  diag.setName(diag.getName()+"1");
						  }
					    proj.addGGEModel(diag);
						MainFrame.getInstance().getViews().add(viewNew);
						i++;
					    
					    Object[] pathToDiagram = new Object[3];
						pathToDiagram[0] = MainFrame.getInstance().getWorkspace();
						pathToDiagram[1] = proj;
						pathToDiagram[2] = diag;
						MainFrame.getInstance().getTree().makeVisible(new TreePath(pathToDiagram));
					 }


	      } else if(MainFrame.getInstance().getTree().getSelected() instanceof GGEModel)
		  {
			  GGEModel diagram= (GGEModel)MainFrame.getInstance().getTree().getSelected();
			  ArrayList<GGEView> views= MainFrame.getInstance().getViews();
			  for(GGEView v: views)
				{
					GGEModel model= v.getGGEModel();
					if (model.equals(diagram))
					{
						view=v;
						break;
					}
				}
			  view.getCommandManager().executeCommand(new PasteCommand(view,SelectElementState.cut));
		  }
		}
		else if (MainFrame.focus== Focus.View)
		{
		  view.getCommandManager().executeCommand(new PasteCommand(view,SelectElementState.cut));
		}
	}

}
