package gui;

import gge.gui.workspace.WorkspaceTree;
import gge.model.GGEModel;
import gge.model.Project;
import gge.model.Workspace;
import gge.view.GGETableView;
import gge.view.GGEView;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import actions.ConnectorAction;
import actions.AttributeAction;
import actions.GerundAction;
import actions.HandMoveAction;
import actions.ISAhierarchyAction;
import actions.LinkAction;
import actions.RectangleAction;
import actions.SelectElementAction;
import actions.WeakEntityAction;

public class MainFrame extends JFrame{
	
	public enum Type{Element,Diagram};
	public enum Focus{Tree,View};
	private Project project;
	private Workspace workspace;
	private WorkspaceTree tree;
	public static Focus focus;
	private JLabel position;
	JLabel sizeLbl;
	JLabel typeLbl;
	JLabel posLbl ;
	JLabel nameLbl;
	JLabel size ;
	JLabel pos;
	public Workspace getWorkspace() {
		return workspace;
	}

	public void setWorkspace(Workspace workspace) {
		this.workspace = workspace;
	}

	
	public WorkspaceTree getTree() {
		return tree;
	}

	public void setTree(WorkspaceTree tree) {
		this.tree = tree;
	}
	
	// Maja: grupisite sve atribute na jednom mestu
	
	private static final long serialVersionUID = 1L;
	
	//static enum States{ellipse_selected,rectangle_selected};//0,1
	private JSplitPane splitPane;// u njega ide split_levi i split_centered
	private JSplitPane split_levi; // sa tree viewom i one dve kartice dole
	private JPanel elementi_desno; // u njemu je paleta i celokupni prikaz
	private JSplitPane split_centered; // u njega ide tabbedPane i split_desni
	
	private JScrollPane scrolPane ; //u njega ide tree
	private JTabbedPane tabbedPane; //centralni deo sa canvasom, svaki tab je dijagram
	private JScrollPane scrolZaTabbedPane;
//	private ButtonTabComponent btc;
	//public static States state;

//	public ButtonTabComponent getBtc() {
//		return btc;
//	}
//
//	public void setBtc(ButtonTabComponent btc) {
//		this.btc = btc;
//	}

	private ImagePanel prikaz;
	
	
	private JTabbedPane maliTabPane; // ide u split levi, donji deo 
	int orgX=0;
	int orgY=0;
	
//	private GGEModel model;
//	private GGEView view;
//	public void setView(GGEView view) {
//		this.view = view;
//	}
//
//	private GGETableView TableView;
	
	private GGEModel model;			// CURRENT
	private GGEView view;
	//public void setView(GGEView view) {
	//	this.view = view;
	//}
	public void setActiveView(GGEView newActiveView) {
		views.remove(view);
		//newActiveView.setPreferredSize(new Dimension(getWidth(), getHeight()));
		//add(newActiveView, BorderLayout.CENTER);
		view = newActiveView;
		views.add(view);
		//pack();
		//initializeTabbedPane();
		for(GGEView view: views)
		{
			if(view.equals(newActiveView)){
				Project project= (Project)MainFrame.getInstance().getTree().getSelected();

				GGEModel model= view.getGGEModel();
				model.addObserver(MainFrame.getInstance().getTree());	
				//GGEView newView= new GGEView(newDiagram, MainFrame.getInstance());
				view.setBackground(Color.WHITE);
				view.setFocusable(true);
				//MainFrame.getInstance().getViews().add(newView);
				
				Object[] pathToDiagram = new Object[3];
				pathToDiagram[0] = MainFrame.getInstance().getWorkspace();
				pathToDiagram[1] = project;
				pathToDiagram[2] = model;
				MainFrame.getInstance().getTree().makeVisible(new TreePath(pathToDiagram));
				
				project.addGGEModel(model);
				
				
				MainFrame.getInstance().getTabbedPane().addTab(model.getName(), null, view);
				MainFrame.getInstance().getTabbedPane().setSelectedComponent(view);
				return;
			
			}
		}
		
	}
	
	public void addProjectIntoTree(Project newProject, GGEView newActiveView) {
		views.remove(view);
		view = newActiveView;
		views.add(view);
		
		for(GGEView view: views)
		{
			if(view.equals(newActiveView)){
				this.project= newProject;

				GGEModel model= view.getGGEModel();
				model.addObserver(MainFrame.getInstance().getTree());	
				//GGEView newView= new GGEView(newDiagram, MainFrame.getInstance());
				view.setBackground(Color.WHITE);
				view.setFocusable(true);
				//MainFrame.getInstance().getViews().add(newView);
				
				Object[] pathToDiagram = new Object[3];
				pathToDiagram[0] = MainFrame.getInstance().getWorkspace();
				pathToDiagram[1] = project;
				pathToDiagram[2] = model;
				MainFrame.getInstance().getTree().makeVisible(new TreePath(pathToDiagram));
				
				project.addGGEModel(model);
				
				
				MainFrame.getInstance().getTabbedPane().addTab(model.getName(), null, view);
				MainFrame.getInstance().getTabbedPane().setSelectedComponent(view);
				return;
			
			}
		}
		
	}
	private ArrayList<GGEView>  views;
	private ArrayList<GGEModel>  models;
	Toolbar toolbar;
	private GGETableView TableView;
	private JScrollPane scrollZaTabelu;
	private static MainFrame instance;
	Menu mni ;
	JToolBar toolbarSaElementima = new JToolBar(Toolbar.VERTICAL);
	StatusBar status;
	

	public ArrayList<GGEModel> getModels() {
		return models;
	}

	public void setModels(ArrayList<GGEModel> models) {
		this.models = models;
	}

	
	
	public ArrayList<GGEView> getViews() {
		return views;
	}

	public void setViews(ArrayList<GGEView> views) {
		this.views = views;
	}

	public Menu getMni() {
		return mni;
	}

	public void setMni(Menu mni) {
		this.mni = mni;
	}

	
			
	public  static MainFrame getInstance(){
		if(instance == null)
			instance = new MainFrame();
		return instance;
	}

	private MainFrame(){
		super();

		addWindowFocusListener(new MyWindowFocusListener());
		
		toolbarSaElementima.setFloatable(true);
		toolbarSaElementima.add(new HandMoveAction());
		toolbarSaElementima.add(new SelectElementAction());
		toolbarSaElementima.add(new AttributeAction());
		toolbarSaElementima.add(new RectangleAction());
		toolbarSaElementima.add(new ConnectorAction());
		toolbarSaElementima.add(new GerundAction());
		toolbarSaElementima.add(new WeakEntityAction());
		toolbarSaElementima.add(new ISAhierarchyAction());
		toolbarSaElementima.add(new LinkAction());
		
	
		status = new StatusBar();
		position = new JLabel("(0 , 0)");
		views= new ArrayList<GGEView>();
		models= new ArrayList<GGEModel>();
		
		 model = new GGEModel("Diagram 1");

		 view = new GGEView(model,this); 
		 view.setBackground(Color.WHITE);
		 view.setFocusable(true);
		 
		 models.add(model);
		 views.add(view);
		 
		TableView = new GGETableView(model);
		TableView.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollZaTabelu = new JScrollPane(TableView);
		
		
		mni = new Menu();

		this.setLocation(150,150);
		
		setTitle("Editor ER dijagrama");
		setSize(Toolkit.getDefaultToolkit().getScreenSize().width*3/4,Toolkit.getDefaultToolkit().getScreenSize().height*3/4);
		
		initializeTree();
		initializeTabbedPane();
		initializeMaliTabbedPane();
		
		
		setJMenuBar(mni);
		toolbar=new Toolbar(this);
		add(toolbar,BorderLayout.NORTH);
	//	((GGEView)tabbedPane.getSelectedComponent()).getScro
		
		scrolZaTabbedPane = new JScrollPane(tabbedPane,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		
		// System.out.println(scrolZaTabbedPane.getVerticalScrollBar().getModel().getExtent());
		
		//scrolZaTabbedPane.getHorizontalScrollBar().setValues(180, 0, 0, 600);
		
		
		int prefBarWidth = scrolZaTabbedPane.getVerticalScrollBar().getPreferredSize().width;
		//tabbedPane.setV(new Rectangle2D.Double(tabbedPane., arg1, arg2, arg3))
		
		//scrolZaTabbedPane.get
		add(status,BorderLayout.SOUTH);
		
		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		splitPane.setOneTouchExpandable(true);
	
		//levi deo
		split_levi = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		scrolPane = new JScrollPane(tree);
		split_levi.add(scrolPane);
		split_levi.add(maliTabPane);
		split_levi.setDividerLocation(MainFrame.this.getHeight()*1/2);
		split_levi.setOneTouchExpandable(true);
		
		//desni deo
		//prikaz = new ImagePanel(
			//	new ImageIcon("Slike/gge.jpeg").getImage());
	
		
		//panPrikaz.setBackground(Color.black);
		//panPrikaz.add(new ImageGraphicAttribute(new Image("Slike/gge.jpeg"),ImageGraphicAttribute.BOTTOM_ALIGNMENT));
		elementi_desno = new JPanel(); //prva komponenta treba da bude paleta sa oblicima, a drugi deo view celog dijagrama
		elementi_desno.add(toolbarSaElementima);
		elementi_desno.setLocation(MainFrame.this.getHeight(),MainFrame.this.getWidth());
		
		//centar
		split_centered = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);
		split_centered.add(scrolZaTabbedPane);
		split_centered.add(elementi_desno);
		split_centered.setDividerLocation(MainFrame.this.getWidth()*4/6);
		split_centered.setResizeWeight(RIGHT_ALIGNMENT);
		
		
	
		
		
		splitPane.add(split_levi);
		splitPane.add(split_centered);

		
		splitPane.setDividerLocation(MainFrame.this.getWidth()*1/5);

		
		add(splitPane);

	}
	
	
private void initializeMaliTabbedPane(){
	
		JLabel type = new JLabel("Type:");
		size = new JLabel("Size:");
		pos = new JLabel("Position:");
		sizeLbl=new JLabel("W:  ,H:  ");
		typeLbl=new JLabel("_____");
		posLbl=new JLabel("X:   ,Y:  ");
		nameLbl=new JLabel("____");
		maliTabPane = new JTabbedPane(JTabbedPane.TOP);
		//String[] PropertiesNames = {"Width", "Heigth", "Color"};
		//Object[][] PropertiesValues = {{"100", "50", "Black"}};
		//JTable PropertiesTable = new JTable(PropertiesValues, PropertiesNames);
		JPanel pan = new JPanel(new FlowLayout(FlowLayout.LEFT));
		pan.add(new JLabel("Selected element:"));
		pan.add(nameLbl);
		JPanel sajz=new JPanel(new FlowLayout(FlowLayout.LEFT));		
		sajz.add(size);
		sajz.add(sizeLbl);
		JPanel tajp=new JPanel(new FlowLayout(FlowLayout.LEFT));
		tajp.add(type);
		tajp.add(typeLbl);
		JPanel position=new JPanel(new FlowLayout(FlowLayout.LEFT));
		position.add(pos);
		position.add(posLbl);
		Box boxCentar = new Box(BoxLayout.Y_AXIS);
		
		boxCentar.add(pan);
		boxCentar.add(tajp);
		boxCentar.add(position);
		boxCentar.add(sajz);
		 ///bjkhi
		
		maliTabPane.addTab("Properties", boxCentar);
		maliTabPane.addTab("Table",scrollZaTabelu);
	}


	private void initializeTree(){
	//	DefaultMutableTreeNode treeNode1 = new DefaultMutableTreeNode("Workspace");
//		DefaultMutableTreeNode treeNode2 = new DefaultMutableTreeNode("Diagram 1");
//		DefaultMutableTreeNode treeNode3 = new DefaultMutableTreeNode("Diagram 2");
//		DefaultMutableTreeNode treeNode4 = new DefaultMutableTreeNode("Project 1");
//		
//		DefaultMutableTreeNode treeNode5 = new DefaultMutableTreeNode("Diagram 1");
//		DefaultMutableTreeNode treeNode6 = new DefaultMutableTreeNode("Project 2");
//		
//		treeNode4.add(treeNode2);
//		treeNode4.add(treeNode3);
//		
//		treeNode1.add(treeNode4);
//		
//		treeNode6.add(treeNode5);
//		treeNode1.add(treeNode6);
//		
//		tree =  new JTree(treeNode1);
	
		
//NEW..............................................
		
		// kreiranje poÄ�etne workspace hijerarhije
				workspace = new Workspace("Workspace");
				project = new Project("Project 1");
				project.addGGEModel(model);
				workspace.addProject(project);
		
		// kreiranje stabla i povezivanje sa modelom
				tree = new WorkspaceTree(workspace);
				tree.getSelectionModel().setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);
				
				
				// stablo osluÅ¡kuje izmene u dijagramu,  projektu i workspace-u
				project.addObserver(tree);
				workspace.addObserver(tree);
				model.addObserver(tree);
				
				// inicijalno otvaranje putanje stabla
				Object[] pathToDiagram = new Object[3];
				pathToDiagram[0] = workspace;
				pathToDiagram[1] = project;
				pathToDiagram[2] = model;
				tree.makeVisible(new TreePath(pathToDiagram));


//NEW..............................................
	}
	

	
	private void initializeTabbedPane(){
		
	
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		view.setPreferredSize(new Dimension(900, 900));		
		
		tabbedPane.addTab(model.getName(), null, view);
		//tabbedPane.setPreferredSize(new Dimension(900, 900));
		//tabbedPane.addTab("2",new ImageIcon("bla"), new JPanel());
		//btc= new ButtonTabComponent(MainFrame.getInstance().getTabbedPane());
		//tabbedPane.setTabLayoutPolicy(arg0);
	}

	public JScrollPane getScrolZaTabbedPane() {
		return scrolZaTabbedPane;
	}

	public void setScrolZaTabbedPane(JScrollPane scrolZaTabbedPane) {
		this.scrolZaTabbedPane = scrolZaTabbedPane;
	}

	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public void setTabbedPane(JTabbedPane tabbedPane) {
		this.tabbedPane = tabbedPane;
	}

	@SuppressWarnings("serial")
	class ImagePanel extends JPanel {

		  private Image img;

		  public ImagePanel(String img) {
		    this(new ImageIcon(img).getImage());
		    
		  }

		  public ImagePanel(Image img) {
		    this.img = img;
		  }

		  public void paintComponent(Graphics g) {
			  
		    g.drawImage(img, (int)(this.getSize().getWidth()-img.getWidth(null))/2,
		    				 (int)(this.getSize().getHeight()-img.getHeight(null))/2, null);
		  }
	}

	public GGEView getView() {
		return view;
	}

	class MyWindowFocusListener implements WindowFocusListener{

		@Override
		public void windowGainedFocus(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
			view.requestFocusInWindow();
			TableView.requestFocusInWindow();
			
		}

		@Override
		public void windowLostFocus(WindowEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}

	public GGEView getCurrentView() {
		if (tabbedPane.getComponentCount() == 0) {
			return null;
		}
		
		return (GGEView)tabbedPane.getSelectedComponent();
	}

	public JToolBar getToolbarSaElementima() {
		return toolbarSaElementima;
	}
	public void setEditedItemInCmb(String procenti){ //kada se zumira da se promene procenti ovu metodu koristimo
		toolbar.setItemInEditor(procenti);
	}

	public void setToolbarSaElementima(JToolBar toolbarSaElementima) {
		this.toolbarSaElementima = toolbarSaElementima;
	}

	public Toolbar getToolbar() {
		return toolbar;
	}

	public StatusBar getStatus() {
		return status;
	}

	public void setSizeLbl(String sizeLbl) {
		this.sizeLbl.setText(sizeLbl);
	}

	public void setTypeLbl(String typeLbl) {
		this.typeLbl.setText(typeLbl);
	}

	public void setPosLbl(String posLbl) {
		this.posLbl.setText(posLbl);
	}

	public void setNameLbl(String nameLbl) {
		this.nameLbl.setText(nameLbl);
	}
	public void setPositonEl(String pos) {
		this.pos.setText(pos);
	}

	

	public void setSize(String size) {
		this.size.setText(size);
	}

	
	
}

