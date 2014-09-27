package gui;

import gge.command.AddElementCommand;
import gge.model.Atribute;
import gge.model.Element;
import gge.model.Entity;
import gge.model.GraphElement;
import gge.view.AtributePainter;
import gge.view.ElementPainter;
import gge.view.GGEView;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DodavanjeAtributa extends JDialog {
	
	private JLabel lbIme;
	private  JTextField tfIme;
	private JButton btnOK;
	private JButton btnCancel;
	
	public DodavanjeAtributa(final GraphElement element) {


		setTitle("Add attribute");
		setSize(((MainFrame.getInstance().getSize()).width/3),(MainFrame.getInstance().getSize()).height/3);
		setLocationRelativeTo(MainFrame.getInstance());
		setModal(true);

		
		lbIme = new JLabel("Atribute name: ");
		tfIme = new JTextField(15);
		
		JPanel buttons= new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOK= new JButton("OK");
		btnOK.setPreferredSize(new Dimension(80, 30));
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
	
		 	String name= tfIme.getText();
		 	
		 	if(element.getAtributi()==null)
		 		System.out.println("NULISAAA");
			int n=  element.getAtributi().size(); 
			GraphElement newElem;
			if(n!=0)
			{
				newElem= new Atribute(new Point2D.Double
		 					(element.getAtributi().get(n-1).getPosition().getX()+100,
		 							element.getAtributi().get(n-1).getPosition().getY()),
		 					new Dimension(85, 35));

			} else
			{
				newElem=new Atribute(new Point2D.Double
						   (element.getPosition().getX()+100,
								   element.getPosition().getY()+100),
							 new Dimension(85, 35));
			}
			  newElem.setName(name);
			  newElem.setOldSize(new Dimension(85, 35));
			  newElem.setBorderColor(Color.BLACK);
			  newElem.setColor(Color.WHITE);
			  newElem.setFontColor(Color.BLACK);
			  newElem.setUnderline(false);
			  newElem.setFontName(Font.SERIF);
			  newElem.setFontStyle(0);
			  newElem.setFontSize(12);
			  newElem.setLineStyle(new BasicStroke(1,
							BasicStroke.CAP_ROUND,
							BasicStroke.JOIN_ROUND,
							5,
							null,0));
			  newElem.setShadow(new GradientPaint(
					   new Point2D.Double(newElem.getPosition().getX()+100,
							   				newElem.getPosition().getY()+100), 
					   Color.WHITE, 
					   new Point2D.Double( newElem.getPosition().getX()+110,
							   				newElem.getPosition().getY()+100)
					   , Color.WHITE, true));
			  newElem.setShading(false);
			  newElem.setFill(false);
			  newElem.setLineStyleName("puna");
		 	ElementPainter newPainter = new AtributePainter(newElem);
		 	GeneralPath linija=new GeneralPath();	
		 	element.dodajAtribut(linija,newElem,newPainter);
			DodavanjeAtributa.this.dispose();
			DodavanjeAtributa.this.setVisible(false);
			GGEView view= MainFrame.getInstance().getCurrentView();
			view.getCommandManager().executeCommand(new AddElementCommand(view.getGGEModel(),view, newElem, newPainter));
			view.repaint();
			}
		});
		
		btnCancel= new JButton("Cancel");
		btnCancel.setPreferredSize(new Dimension(80, 30));
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjeAtributa.this.dispose();
				DodavanjeAtributa.this.setVisible(false);
				
			}
		});
		
		buttons.add(btnOK);
		buttons.add(btnCancel);
		
		JPanel pNewName= new JPanel(new FlowLayout(FlowLayout.LEFT));
		pNewName.add(lbIme);
		pNewName.add(tfIme);
		add(pNewName);
		add(buttons,BorderLayout.SOUTH);
	}
	
	

}
