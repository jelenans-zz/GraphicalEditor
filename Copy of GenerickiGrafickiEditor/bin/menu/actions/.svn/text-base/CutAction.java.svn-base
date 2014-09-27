package menu.actions;



import gge.command.CutElementCommand;
import gge.command.DeleteElementCommand;
import gge.model.Clipboard;
import gge.model.Element;
import gge.model.GGEModel;
import gge.model.GraphElement;
import gge.model.Link;
import gge.model.Project;
import gge.model.Workspace;
import gge.state.SelectElementState;
import gge.view.ElementPainter;
import gge.view.GGEView;
import gge.view.LinkPainter;
import gge.view.Painter;
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

import com.thoughtworks.xstream.io.path.Path;

public class CutAction extends AbstractAction {

	public CutAction() {
		super();
	
		// TODO Auto-generated constructor stub
		putValue(Action.NAME, "Cut");
		putValue(Action.SHORT_DESCRIPTION, "Cut");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/cut.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		SelectElementState.cut=true;
		
		if (MainFrame.focus== Focus.View)
		{
			GGEView currView= MainFrame.getInstance().getCurrentView();		
		
			ArrayList<LinkPainter> vezeZaBrisanje = new ArrayList<LinkPainter>();
			for(Element el: currView.getSelection().getElements())
			{
				if(el instanceof GraphElement)
				{
					for(LinkPainter linkP: currView.getLinkPainters())
					{
						if(((Link)linkP.getElement()).getFirst().equals(el)||((Link)linkP.getElement()).getSecond().equals(el))
							vezeZaBrisanje.add(linkP);
					}
			
				}
			}
		
			currView.getCommandManager().executeCommand(new CutElementCommand(currView.getGGEModel(),currView,currView.getSelection().getElements(),currView.selectedElementsPainters(),vezeZaBrisanje));
		
		} else if (MainFrame.focus== Focus.Tree)
		{
			SelectElementState.cut=true;
			
			  if (MainFrame.getInstance().getTree().getSelected() instanceof GGEModel)
			  {

				  Clipboard.getInstance().putDiagrams(MainFrame.getInstance().getTree().getSelectionModel().getSelectionPaths());

				  ArrayList<GGEView> views= MainFrame.getInstance().getViews();
					Workspace current= MainFrame.getInstance().getWorkspace();
					ArrayList<Project> projects= current.getProjects();
					
					TreePath[] selectionPaths=MainFrame.getInstance().getTree().getSelectionModel().getSelectionPaths();
					for(int i=0;i< selectionPaths.length;i++)
					{
			           if(selectionPaths[i].getLastPathComponent() instanceof GGEModel)
						{
							GGEModel diagram= (GGEModel)selectionPaths[i].getLastPathComponent();
							for (Project project : projects) 
							{
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

								}
							}
						}
				}
			  }else if(MainFrame.getInstance().getTree().getSelected() instanceof Element)
			  {
				  
				    Clipboard.getInstance().putElements(MainFrame.getInstance().getTree().getSelectionModel().getSelectionPaths());
				  
				    TreePath[] selectionPaths=MainFrame.getInstance().getTree().getSelectionModel().getSelectionPaths();			    
				    List<Element> selectedElements = new ArrayList<Element>();
					ArrayList<Painter> selectedPainters = new ArrayList<Painter>();
				    
					for(int i=0;i< selectionPaths.length;i++)
					{
			           if(selectionPaths[i].getLastPathComponent() instanceof Element)
						{
							Element elem= (Element)selectionPaths[i].getLastPathComponent();
							selectedPainters.add(MainFrame.getInstance().getView().getElementPainter((GraphElement)elem));
							selectedElements.add(elem);
						}
					}


					TreePath parentPath= MainFrame.getInstance().getTree().getSelectionModel().getLeadSelectionPath().getParentPath();
					GGEModel parent= (GGEModel)parentPath.getLastPathComponent();
//					System.out.println("CUT DIAG: "+parent.getName());
					
					GGEView currView= null;
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


					
					
					ArrayList<LinkPainter> vezeZaBrisanje = new ArrayList<LinkPainter>();
					for(Element el: currView.getSelection().getElements()){
						if(el instanceof GraphElement){
						for(LinkPainter linkP: currView.getLinkPainters()){
							if(((Link)linkP.getElement()).getFirst().equals(el)||((Link)linkP.getElement()).getSecond().equals(el))
								vezeZaBrisanje.add(linkP);
						}
						
						}
					}
					
					currView.getCommandManager().executeCommand(new DeleteElementCommand(currView.getGGEModel(), currView, selectedElements,selectedPainters ,vezeZaBrisanje));
					
			  }
		}
		
	}

}
