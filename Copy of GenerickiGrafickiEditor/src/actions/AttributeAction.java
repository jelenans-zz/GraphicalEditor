package actions;


import gge.model.Connector;
import gge.model.Element;
import gge.model.Entity;
import gge.model.Gerund;
import gge.model.GraphElement;
import gge.model.WeakEntity;
import gge.state.StateManager.States;
import gge.view.GGEView;
import gui.DodavanjeAtributa;
import gui.MainFrame;

import java.awt.Cursor;
import java.awt.event.ActionEvent;


import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class AttributeAction extends AbstractAction {
	
	public AttributeAction() {
		super();
		
		putValue(Action.NAME, "Add attribute");
		putValue(Action.SHORT_DESCRIPTION, "Select to add attribute on canvas");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/elipsa.jpg"));
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();

		currView.setElementType("attribute");
		
			  GGEView view= MainFrame.getInstance().getCurrentView();
			  Element el= view.getSelection().getSingleSelectedElement();
			  if(el instanceof Entity || el instanceof Connector || el instanceof WeakEntity || el instanceof Gerund)
			  {
				  DodavanjeAtributa atrib= new DodavanjeAtributa((GraphElement)el);
				  atrib.setVisible(true);
				
			  }
			  else
			  {
				  JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali odgovarajuci element",
							"Dodavanje obeležja", JOptionPane.INFORMATION_MESSAGE);
			  }
//		currView.getController().getStateManager().setCurrentState(States.ADD_ELEMENT_STATE);
//		currView.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	}

}
