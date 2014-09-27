package menu.actions;

import gge.model.GGEModel;
import gui.MainFrame;
import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class SaveAllAction extends AbstractAction {
	
	public SaveAllAction() {
		super();
		putValue(Action.NAME, "Save All");
		putValue(Action.SHORT_DESCRIPTION, "Save All");
		//putValue(Action.SMALL_ICON, new ImageIcon("Slike/Floppy.png"));
		

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MainFrame mainFrame = null;
	
		JFileChooser choo = new JFileChooser();
		 FileNameExtensionFilter filter = new FileNameExtensionFilter(".xml", "."
			        );
			    choo.setFileFilter(filter);
			    int returnVal = choo.showSaveDialog(choo);
			    		if(returnVal == JFileChooser.APPROVE_OPTION) {
			    String fileName = choo.getSelectedFile().getAbsolutePath();  // preuzimanje imena fajla
		     JOptionPane.showMessageDialog(mainFrame, "Odabrana datoteka: " + fileName); 
			       System.out.println("You chose to open this file: " +
			            choo.getSelectedFile().getName());
			     
		GGEModel model = MainFrame.getInstance().getView().getGGEModel();

		XStream xstream = new XStream(new DomDriver());
		xstream.registerConverter(new ModelConverter());

		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream("Dijagram1.gge"), "UTF8"));
			xstream.toXML(model, out);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		//JOptionPane.showMessageDialog(MainFrame.getInstance(), "This option will be implemented soon!",
		//		"Save", JOptionPane.INFORMATION_MESSAGE);
		
	}
	}
}
