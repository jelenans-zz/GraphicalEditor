package menu.actions;

import gge.model.GGEModel;
import gge.view.GGEView;
import gui.MainFrame;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class SaveDiagramAction extends AbstractAction {
	
	public SaveDiagramAction() {
		super();
		putValue(Action.NAME, "Save Diagram");
		putValue(Action.SHORT_DESCRIPTION, "Save diagram");
		putValue(Action.SMALL_ICON, new ImageIcon("Slike/Floppy.png"));
		putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		//JOptionPane.showMessageDialog(MainFrame.getInstance(), "This option will be implemented soon!",
			//	"Save", JOptionPane.INFORMATION_MESSAGE);
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
			     
		//GGEModel model = MainFrame.getInstance().getView().getGGEModel();
		GGEView currView = (GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
		GGEModel model = currView.getGGEModel();

		XStream xstream = new XStream(new DomDriver());
		xstream.registerConverter(new ModelConverter());

		try {
			BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(choo.getSelectedFile()), "UTF8"));
			xstream.toXML(model, out);
			model.isSacuvano(true);
			System.out.println("sacuvano = true");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			    		}
	}

}
