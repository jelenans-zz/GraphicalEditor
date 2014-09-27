package gge.gui.workspace;

import gge.command.DeleteElementCommand;
import gge.command.PasteCommand;
import gge.model.Atribute;
import gge.model.Clipboard;
import gge.model.Connector;
import gge.model.Element;
import gge.model.Entity;
import gge.model.GGEModel;
import gge.model.Gerund;
import gge.model.GraphElement;
import gge.model.ISAhierarchy;
import gge.model.Link;
import gge.model.Project;
import gge.model.WeakEntity;
import gge.model.Workspace;
import gge.state.SelectElementState;
import gge.view.AtributePainter;
import gge.view.ConnectorPainter;
import gge.view.ElementPainter;
import gge.view.EntityPainter;
import gge.view.GGEView;
import gge.view.GerundPainter;
import gge.view.ISAhierarchyPainter;
import gge.view.LinkPainter;
import gge.view.Painter;
import gge.view.WeakEntityPainter;
import gui.MainFrame;
import gui.MainFrame.Focus;
import gui.PopUp;
import gui.PopUpTree;

import java.awt.Color;
import java.awt.Component;
import java.awt.Event;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

import com.sun.org.apache.bcel.internal.generic.POP;


@SuppressWarnings("serial")
public class WorkspaceTree extends JTree implements Observer, TreeSelectionListener {
	
	
	private Object selected;


	public Object getSelected() {
		return selected;
	}

	public void setSelected(Object selected) {
		this.selected = selected;
	}

	public WorkspaceTree(Workspace root) {
		super();
		
		WorkspaceModel model = new WorkspaceModel(root);
		setModel(model);
		setFocusable(true);
		addTreeSelectionListener(this);
		addMouseListener(new TreeMouseListener());
		addKeyListener(new TreeKeyListener());
	}
	int kk=1;



	@Override
	public void valueChanged(TreeSelectionEvent e) {
		//selected = e.getPath().getLastPathComponent();
		
		   // Get paths of all selected nodes
	    TreePath[] paths = getSelectionPaths();    
		getSelectionModel().addSelectionPaths(paths);
	    
	    for(int i=0;i< paths.length;i++)
	    {
	    	
	    	selected= paths[i].getLastPathComponent();

		// TODO Reakcija na izmenu selekcije u stablu.
		MainFrame.getInstance().getToolbar().getAlign().setEnabled(true);
		MainFrame.getInstance().getToolbar().getAlignTop().setEnabled(true);
		MainFrame.getInstance().getToolbar().getDelete().setEnabled(true);
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent(); 
		
		if (selected instanceof Element)
		{
		  if(currView!=null)
			if(currView.getGGEModel().getElements().contains(selected))
			{
				 currView.getSelection().removeAllElements();
				 Element currentElement= (Element)MainFrame.getInstance().getTree().getSelected();
				 if(!currView.getSelection().getElements().contains(currentElement))
					 currView.getSelection().addElements(currentElement);
			     currView.repaint();
			}

		} else if(selected instanceof GGEModel)
		{
			GGEModel diagram= (GGEModel)MainFrame.getInstance().getTree().getSelected();
			Component[] openedDiagrams= MainFrame.getInstance().getTabbedPane().getComponents();
			ArrayList<GGEView> views= MainFrame.getInstance().getViews();
			
			for(GGEView view: views)
			{
				GGEModel model= view.getGGEModel();
				if (model.equals(diagram))
				{
					for(Component opened: openedDiagrams)
					{
						if(opened.equals(view))
						{
							MainFrame.getInstance().getTabbedPane().setSelectedComponent(view);
							return;
						}
					}
				}
			}
		}
	    }
	   for(int i=0; i<getSelectionModel().getSelectionPaths().length;i++)
	   {
		//   System.out.println("i: "+i);
		   System.out.println("TREE SELECTION SIZE: "+getSelectionModel().getSelectionPaths().length);
	   }
	}

	@Override
	public void update(Observable o, Object arg) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SwingUtilities.updateComponentTreeUI(WorkspaceTree.this);
			}
		});
	}
	
	class TreeMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub

			if(arg0.getButton() == MouseEvent.BUTTON3){
				PopUpTree pop = new PopUpTree();
				pop.show(WorkspaceTree.this,arg0.getX(),arg0.getY());
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			MainFrame.focus= Focus.Tree;
			WorkspaceTree.this.requestFocusInWindow();
			//System.out.println("BBB");
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
			 	
			 }
		}
		
	

	class TreeKeyListener implements KeyListener{

		@Override
		public void keyPressed(KeyEvent arg0) {
			
		 if(arg0.getKeyCode() == KeyEvent.VK_DELETE)
			{
			    ArrayList<GGEView> views= MainFrame.getInstance().getViews();
				
				if (MainFrame.getInstance().getTree().getSelected() instanceof GGEModel)
				{
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
				else{ 
				
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali projekat/dijagram!",
						"Uklanjanje dijagrama", JOptionPane.INFORMATION_MESSAGE);
				}
			
			}
		 else if (arg0.getKeyCode() == KeyEvent.VK_C && arg0.isControlDown())
			  {
			
				if (MainFrame.getInstance().getTree().getSelected() instanceof GGEModel)
				{

				  Clipboard.getInstance().putDiagrams(MainFrame.getInstance().getTree().getSelectionModel().getSelectionPaths());
				} else if(MainFrame.getInstance().getTree().getSelected() instanceof Element)
				{

					  Clipboard.getInstance().putElements(MainFrame.getInstance().getTree().getSelectionModel().getSelectionPaths());
				}

			} else if(arg0.getKeyCode() == KeyEvent.VK_X && arg0.isControlDown())
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
			else if(arg0.getKeyCode() == KeyEvent.VK_V && arg0.isControlDown())
			{
				  if (MainFrame.getInstance().getTree().getSelected() instanceof Project)
				  {
							 Project proj= (Project)MainFrame.getInstance().getTree().getSelected();
							 int i=0;
							 
							 for (GGEModel diag : Clipboard.getInstance().getDiagrams())
							 {
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
					  GGEView view= null;
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
		}
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		}
		
	}
	
