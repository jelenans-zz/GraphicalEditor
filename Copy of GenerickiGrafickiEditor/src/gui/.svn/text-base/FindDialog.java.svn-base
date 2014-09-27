package gui;

import gge.command.AddElementCommand;
import gge.model.Atribute;
import gge.model.Element;
import gge.model.Entity;
import gge.model.GraphElement;
import gge.state.AddElementState;
import gge.view.ElementPainter;
import gge.view.AtributePainter;
import gge.view.GGEView;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Event;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FindDialog extends JDialog implements KeyListener{
	
	private JLabel lbIme;
	private  JTextField tfIme;
	private JButton btnOK;
	private JButton btnCancel;
	GGEView view;
	ArrayList<Element> elements;
	
	public FindDialog() {
		
		setTitle("Find element");
		setSize(((MainFrame.getInstance().getSize()).width/3+50),(MainFrame.getInstance().getSize()).height/3);
		setLocationRelativeTo(MainFrame.getInstance());
		setModal(true);
		
	
		lbIme = new JLabel("Naziv elementa: ");
		tfIme = new JTextField(20);
		
		
		JPanel pNewName= new JPanel(new FlowLayout(FlowLayout.LEFT));
		pNewName.add(lbIme);
		pNewName.add(tfIme);
		pNewName.add(new JLabel());
		pNewName.add(new JLabel());
		
		
		JPanel general= new JPanel(new FlowLayout(FlowLayout.LEFT));
		general.add(pNewName);
	
		JPanel buttons= new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOK= new JButton("OK");
		btnOK.setPreferredSize(new Dimension(80, 30));
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				view=(GGEView)MainFrame.getInstance().getTabbedPane().getSelectedComponent();
				elements = (ArrayList<Element>) view.getGGEModel().getElements();
				view.getSelection().removeAllElements();
				
				if(elements.size()!=0){
					for(Element e:elements){
					
						if(tfIme.getText().equals(e.getName())){
							
							view.getSelection().addElements(e);
						}
							
						view.getGGEModel().fireUpdates();
						
					}
					if(view.getSelection().getElements().size()==0){
						JOptionPane.showMessageDialog(FindDialog.this, "Ne postoji element sa nazivom:"+tfIme.getText().trim(),
								"Find", JOptionPane.INFORMATION_MESSAGE);
					}
				}else{
					if(view.getSelection().getElements().size()==0){
						JOptionPane.showMessageDialog(FindDialog.this, "Ne postoji nijedan element na aktivnom dijagramu",
								"Find", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			
			
			}		

		});
		btnCancel= new JButton("Cancel");
		btnCancel.setPreferredSize(new Dimension(80, 30));
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FindDialog.this.dispose();
				FindDialog.this.setVisible(false);				
			}
		});
	
		buttons.add(btnOK);
		buttons.add(btnCancel);
		


		add(general);
		add(buttons,BorderLayout.SOUTH);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode()==KeyEvent.VK_ESCAPE){
			this.setVisible(false);
		}
		
	}
	
	
	
	
	

}
