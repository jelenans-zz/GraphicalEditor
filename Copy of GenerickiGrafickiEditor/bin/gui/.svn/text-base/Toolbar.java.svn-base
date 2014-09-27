package gui;

import gge.view.GGEView;

import java.awt.Dimension;

import javax.swing.JComboBox;
import javax.swing.JToolBar;
import menu.actions.CloseAction;
import menu.actions.CloseAllAction;
import menu.actions.CloseProject;
import menu.actions.CopyAction;
import menu.actions.CutAction;
import menu.actions.FindElementAction;
import menu.actions.NewDiagramAction;
import menu.actions.NewProjectAction;
import menu.actions.OpenDiagramAction;
import menu.actions.OpenProjectAction;
import menu.actions.PasteAction;
import menu.actions.SaveDiagramAction;
import menu.actions.SaveProjectAction;
import actions.AlignElementsAction;
import actions.DeleteElementAction;
import actions.BestFitZoomAction;
import actions.ZoomAction;
import actions.ZoomIn;
import actions.ZoomOut;
import actions.RedoAction;
import actions.UndoAction;


@SuppressWarnings("serial")
public class Toolbar extends JToolBar {
	MainFrame parent;
	NewDiagramAction  NewDiagram;
	OpenDiagramAction OpenDiagram;
	SaveDiagramAction SaveDiagram;
	CloseAction CloseDiagram;
	NewProjectAction  NewProject;
	OpenProjectAction OpenProject;
	SaveProjectAction SaveProject;
	CloseProject CloseProject;
	UndoAction Undo;
	RedoAction Redo;
	CopyAction Copy;
	CutAction Cut;
	PasteAction Paste;
	DeleteElementAction Delete;
	AlignElementsAction Align;
	AlignElementsAction AlignTop;
	ZoomIn ZoomIn;
	ZoomOut ZoomOut;
	BestFitZoomAction bestFit;
	JComboBox cmb;
	FindElementAction Find;
	
	
	
	public Toolbar(MainFrame parent) {
		super(JToolBar.HORIZONTAL);
		this.parent = parent;
	
		NewDiagram = new NewDiagramAction();
		OpenDiagram = new OpenDiagramAction();
		SaveDiagram = new SaveDiagramAction();
		CloseDiagram = new CloseAction();
		
		NewProject = new NewProjectAction();
		OpenProject = new OpenProjectAction();
		SaveProject = new SaveProjectAction();
		CloseProject = new CloseProject();

		Undo = new UndoAction();
		Redo = new RedoAction();
		

		Copy = new CopyAction();
		Cut = new CutAction();
		Paste = new PasteAction();
		
		Delete = new DeleteElementAction();
		Align=new AlignElementsAction(0);
		Align.setEnabled(false);
		AlignTop=new AlignElementsAction(1);
		AlignTop.setEnabled(false);
		ZoomIn = new actions.ZoomIn();
		ZoomOut = new actions.ZoomOut();
		bestFit = new BestFitZoomAction();
		cmb =  new JComboBox();
		fillProcents();

		Find = new FindElementAction();
		
		add(NewDiagram);
		add(OpenDiagram);
		add(CloseDiagram);
		add(SaveDiagram);
		addSeparator();
		add(NewProject);
		add(OpenProject);
		add(CloseProject);
		add(SaveProject);
		addSeparator();
		add(Copy);
		add(Cut);
		add(Paste);
		add(Delete);
		addSeparator();
		add(Undo);
		add(Redo);
		addSeparator();
		add(Align);
		add(AlignTop);
		
		addSeparator();
		add(ZoomIn);
		add(ZoomOut);
		add(bestFit);
		add(cmb);
		addSeparator();
		add(Find);
	}
	
	private void fillProcents(){
		cmb.setPreferredSize(new Dimension(10, 5));
		cmb.setEditable(true);
		String[] procenti = {"25%", "50%", "75%", "100%", "200%","500%","1000%"};
		cmb.setPrototypeDisplayValue("XXXXX"); // Set a desired width
		for(int i =0;i<procenti.length;i++)
			cmb.addItem(procenti[i].toString());
	    cmb.setMaximumSize(new Dimension((int)cmb.getMinimumSize().getWidth(), 35));
	    cmb.setSelectedItem("100%");
	    
	   cmb.addActionListener(new ZoomAction());
	
	}
	public void setItemInEditor(String procenata ){
		cmb.getEditor().setItem(procenata);
	}

	public AlignElementsAction getAlign() {
		return Align;
	}

	public void setAlign(AlignElementsAction align) {
		Align = align;
	}

	public AlignElementsAction getAlignTop() {
		return AlignTop;
	}

	public void setAlignTop(AlignElementsAction alignTop) {
		AlignTop = alignTop;
	}

	public DeleteElementAction getDelete() {
		return Delete;
	}

	public void setDelete(DeleteElementAction delete) {
		Delete = delete;
	}

}
