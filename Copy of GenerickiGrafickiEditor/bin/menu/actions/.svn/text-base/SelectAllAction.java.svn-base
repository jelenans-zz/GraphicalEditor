package menu.actions;

import gge.model.Element;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;


public class SelectAllAction extends AbstractAction {
	GGEView view;
	ArrayList<Element> elements;
	
	
	
	public SelectAllAction() {
		super();
		putValue(Action.NAME, "Select all");
		putValue(Action.SHORT_DESCRIPTION, "Select all");
		//putValue(Action.SMALL_ICON, new ImageIcon("Slike/cut.png"));
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		view=(GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		
		elements = (ArrayList<Element>) view.getGGEModel().getElements();
		
		if(elements.size()>0){
			
			for(Element e:elements){
				
				if(!view.getSelection().getElements().contains(e))
					view.getSelection().addElements(e);
				MainFrame.getInstance().getToolbar().getAlign().setEnabled(true);
				MainFrame.getInstance().getToolbar().getAlignTop().setEnabled(true);
				MainFrame.getInstance().getToolbar().getDelete().setEnabled(true);
				MainFrame.getInstance().setNameLbl(elements.size()+" elements");
				MainFrame.getInstance().setPosLbl("");
				MainFrame.getInstance().setSizeLbl("");
				MainFrame.getInstance().setTypeLbl("");
				view.getGGEModel().fireUpdates();
			}
		}
	}

}
