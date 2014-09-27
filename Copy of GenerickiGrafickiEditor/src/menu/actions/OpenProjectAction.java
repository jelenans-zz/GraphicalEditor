package menu.actions;

import gge.model.Atribute;
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
import gge.view.AtributePainter;
import gge.view.ConnectorPainter;
import gge.view.EntityPainter;
import gge.view.GGEView;
import gge.view.GerundPainter;
import gge.view.ISAhierarchyPainter;
import gge.view.LinkPainter;
import gge.view.WeakEntityPainter;
import gui.MainFrame;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;


public class OpenProjectAction extends AbstractAction {

	public OpenProjectAction() {
		super();
		
		// TODO Auto-generated constructor stub
		putValue(Action.NAME, "Open Project");
		putValue(Action.SHORT_DESCRIPTION, "Open Project");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/openp.jpg"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		//JOptionPane.showMessageDialog(MainFrame.getInstance(), "This option will be implemented soon!",
				//"Open project", JOptionPane.INFORMATION_MESSAGE);
		JFileChooser choo = new JFileChooser();
		 FileNameExtensionFilter filter = new FileNameExtensionFilter("All files", ".xml");
			    choo.setFileFilter(filter);
			    int returnVal = choo.showOpenDialog(choo);
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("You chose to open this file: " +
			            choo.getSelectedFile().getName());
			    

	XStream xstream = new XStream(new DomDriver());
	xstream.registerConverter(new ProjectConverter());
	
	try {
		BufferedReader in = new BufferedReader(new InputStreamReader(
				new FileInputStream(choo.getSelectedFile())));
		
		Project project = (Project) xstream.fromXML(in);
		
	    
	    for(GGEModel model : project.getGGEModel()){
	    	GGEView view = new GGEView(model, MainFrame.getInstance());
	    for(Element el : model.getElements()){
	    	if(el instanceof GraphElement){
	    		el = (GraphElement)el;
	    		if(el instanceof Connector){
	    			view.addElementPainters(new ConnectorPainter((GraphElement)el));
	    		}
	    		if(el instanceof Gerund){
	    			view.addElementPainters(new GerundPainter((GraphElement)el));
	    		}
	    		if(el instanceof Entity){
	    			view.addElementPainters(new EntityPainter((GraphElement)el));
	    		}
	    		if(el instanceof Atribute){
	    			view.addElementPainters(new AtributePainter((GraphElement)el));
	    		}
	    		if(el instanceof ISAhierarchy){
	    			view.addElementPainters(new ISAhierarchyPainter((GraphElement)el));
	    		}
	    		if(el instanceof WeakEntity){
	    			view.addElementPainters(new WeakEntityPainter((GraphElement)el));
	    		}
	    		else if(el instanceof Link){
	    		view.addLinkPainters(new LinkPainter((Link) el));
	    		}
	    	}
		}
	    //model.setName(choo.getSelectedFile().getName());
	    view.update(model, null);
	    MainFrame.getInstance().addProjectIntoTree(project, view);
	    }
	    MainFrame.getInstance().getWorkspace().addProject(project);
	
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
			    }else choo.cancelSelection();
	}
	

}
