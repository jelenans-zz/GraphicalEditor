package gui;


import gge.view.GGEView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;

import actions.DeleteElementAction;
import actions.RedoAction;
import actions.UndoAction;
import menu.actions.AboutAction;
import menu.actions.CloseAllAction;
import menu.actions.CloseAction;
import menu.actions.OpenAnExistingDiagram;
import menu.actions.RemoveAction;
import menu.actions.CloseWorkspaceAction;
import menu.actions.CopyAction;
import menu.actions.CutAction;
import menu.actions.ExitAction;
import menu.actions.FindElementAction;
import menu.actions.HelpAction;
import menu.actions.NewDiagramAction;
import menu.actions.NewProjectAction;
import menu.actions.OpenDiagramAction;
import menu.actions.OpenProjectAction;
import menu.actions.OpenWorkspaceAction;
import menu.actions.PasteAction;
import menu.actions.PropertiesAction;
import menu.actions.RenameAction;
import menu.actions.SaveAllAction;
import menu.actions.SaveDiagramAction;
import menu.actions.SaveProjectAction;
import menu.actions.SaveWorkspaceAction;
import menu.actions.SelectAllAction;

@SuppressWarnings("serial")
public class Menu extends JMenuBar {

	GGEView ggeview;
	JMenu file;
	JMenu newMenu;

	NewProjectAction newProjectJMI;
	NewDiagramAction newDiagramJMI;
	JMenu openMenu;
	OpenWorkspaceAction openWorkspaceJMI;
	OpenAnExistingDiagram openDiagramJMI;
	JMenu saveMenu;
	SaveWorkspaceAction saveWorkspaceJMI;
	SaveDiagramAction saveDiagramJMI;
	SaveAllAction saveAllJMI;
	
	CloseWorkspaceAction closeWorkspace;
	RemoveAction remove;
	RenameAction renameFile;
	CloseAction closeDiagram;
	ExitAction exitJMI;
	
	JMenu projekat;
	OpenProjectAction openProjectJMI;
	SaveProjectAction saveProjectJMI;
	CloseAllAction closeProject;
	 
	JMenu edit;
	UndoAction undoJMI;
	RedoAction redoJMI;
	CopyAction CopyJMI;
	CutAction CutJMI;
	PasteAction PasteJMI;
	DeleteElementAction DeleteJMI;
	SelectAllAction SelectAllJMI;
	FindElementAction FindJMI;
	
	
	JMenu view;
	//DiagramAction diagram;
	PropertiesAction properties;
	static JCheckBoxMenuItem grid;
	JMenu tools;
	
	JMenuItem ZoomIn;
	JMenuItem ZoomOut;
	
	JMenu help;
	HelpAction HelpTopicsJMI;
	AboutAction AboutJMI;

	
	
	public Menu() {
		super();
	
		// TODO Auto-generated constructor stub
		file= new JMenu("File");
		file.setMnemonic('F');
		newMenu = new JMenu("New");
		newMenu.setMnemonic(KeyEvent.VK_N);

		newProjectJMI = new NewProjectAction();
		newDiagramJMI = new NewDiagramAction();
		//newDiagramJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
		
		openMenu = new JMenu("Open");
		openMenu.setMnemonic(KeyEvent.VK_O);
		openWorkspaceJMI = new OpenWorkspaceAction();
		openDiagramJMI = new OpenAnExistingDiagram();
		//openDiagramJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
		
		projekat = new JMenu("Project");
		projekat.setMnemonic(KeyEvent.VK_P);
		openProjectJMI = new OpenProjectAction();
		
		saveMenu = new JMenu("Save");
		saveAllJMI = new SaveAllAction();
		//saveAllJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK + ActionEvent.SHIFT_MASK));
		saveWorkspaceJMI = new SaveWorkspaceAction();
		saveProjectJMI = new SaveProjectAction();
		saveDiagramJMI = new SaveDiagramAction();
		//saveDiagramJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));

		
		closeWorkspace = new CloseWorkspaceAction();
		remove = new RemoveAction();
		renameFile= new RenameAction();
		closeDiagram = new CloseAction();
		closeProject = new CloseAllAction();
		exitJMI = new ExitAction();
		
		edit = new JMenu("Edit");
		edit.setMnemonic('E');
		
		undoJMI = new UndoAction();
		//undoJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		redoJMI = new RedoAction();
		//redoJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		CopyJMI = new CopyAction();
		//CopyJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
		CutJMI = new CutAction();
		//CutJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, ActionEvent.CTRL_MASK));
		PasteJMI = new PasteAction();
		//PasteJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
		SelectAllJMI = new SelectAllAction();
		//SelectAllJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
		DeleteJMI = new DeleteElementAction();
		FindJMI = new FindElementAction();
		//FindJMI.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.CTRL_MASK));
		
		view = new JMenu("View");
		view.setMnemonic('V');
		
		//diagram = new DiagramAction();
		properties = new PropertiesAction();
		//view.add(diagram);
		
		view.add(properties);
		grid=new JCheckBoxMenuItem("Show grid");
		grid.setToolTipText("Toogle view...");
		grid.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub

				if (MainFrame.getInstance().getCurrentView() instanceof GGEView)
					MainFrame.getInstance().getCurrentView().toggleGrid();
			}
		});
		grid.setSelected(true);
		view.addSeparator();
		view.add(grid);
		
		tools = new JMenu("Tools");
		tools.setMnemonic('t');
		//ElipseJMI = new JMenuItem("Elipse");
		//ElipseJMI.setIcon(new ImageIcon("Slike/shape_ellipse.jpg"));
		//RectangleJMI = new JMenuItem("Rectangle");
		//RectangleJMI.setIcon(new ImageIcon("Slike/rectangle.jpeg"));
		//ZoomIn = new JMenuItem("ZoomIn");
		//ZoomIn.setIcon(new ImageIcon("Slike/shape_ellipse.jpg"));
		//ZoomOut = new JMenuItem("ZoomOut");
		//ZoomOut.setIcon(new ImageIcon("Slike/shape_ellipse.jpg"));
		
		help = new JMenu("Help");
		help.setMnemonic('h');
		HelpTopicsJMI = new HelpAction();
		AboutJMI = new AboutAction();
		
		//file.add(edit);
		add(file);
		file.add(newMenu);

		newMenu.add(newProjectJMI);
		newMenu.add(newDiagramJMI);
		
		file.add(openMenu);
		openMenu.add(openWorkspaceJMI);
		openMenu.add(openProjectJMI);
		openMenu.add(openDiagramJMI);
		
		file.add(saveMenu);
		saveMenu.add(saveAllJMI);
		saveMenu.add(saveWorkspaceJMI);
		saveMenu.add(saveProjectJMI);
		saveMenu.add(saveDiagramJMI);
		file.add(new JSeparator());
		
		file.add(closeWorkspace);
		file.add(remove);
		file.add(closeDiagram);
		file.add(closeProject);
		file.add(new JSeparator());
		file.add(exitJMI);
		
		add(edit);
		edit.add(renameFile);
		edit.add(new JSeparator());
		edit.add(undoJMI);
		edit.add(redoJMI);
		edit.add(new JSeparator());
		edit.add(CopyJMI);
		edit.add(CutJMI);
		edit.add(PasteJMI);
		edit.add(new JSeparator());
		edit.add(DeleteJMI);
		edit.add(SelectAllJMI);
		edit.add(new JSeparator());
		edit.add(FindJMI);
		
		projekat.add(openProjectJMI);
		projekat.add(saveProjectJMI);
		projekat.add(closeProject);
		
		add(view);
		add(projekat);
		//add(tools);
		//tools.add(ElipseJMI);
		//tools.add(RectangleJMI);
		//tools.add(ZoomIn);
		//tools.add(ZoomOut);
		
		add(help);
		help.add(HelpTopicsJMI);
		help.add(new JSeparator());
		help.add(AboutJMI);
		
	}



	

	
	
}
