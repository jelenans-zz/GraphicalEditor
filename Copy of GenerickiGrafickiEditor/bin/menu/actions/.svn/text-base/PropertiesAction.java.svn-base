package menu.actions;

import gge.model.GraphElement;
import gge.view.GGEView;
import gui.ElementProperties;
import gui.MainFrame;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JOptionPane;


public class PropertiesAction extends AbstractAction {

	public PropertiesAction() {
		super();
		putValue(Action.NAME, "Properties");
		putValue(Action.SHORT_DESCRIPTION, "Shows properties for selected element");
		//putValue(Action.SMALL_ICON, new ImageIcon("Slike/shape_ellipse.jpg"));
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		GGEView currView= (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		
	if(currView.getSelection().getSingleSelectedElement()!=null)	
	{
		ElementProperties.currView= currView;
		ElementProperties.selektovanElement= (GraphElement)currView.getSelection().getSingleSelectedElement();
		GraphElement ell = null;
		if(currView.getSelection().getSingleSelectedElement() instanceof GraphElement)
		ell= (GraphElement)currView.getSelection().getSingleSelectedElement();
		System.out.println("sel el: "+ell.getName());
		ElementProperties properties= new ElementProperties();
		properties.setVisible(true);
	} else
		{
		JOptionPane.showMessageDialog(MainFrame.getInstance(), "Selektujte jedan element!",
				"Element properties", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
