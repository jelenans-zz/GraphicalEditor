package gui;

import gge.command.AddElementCommand;
import gge.model.Atribute;
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
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class UnosEntiteta<tfAtribut> extends JDialog{
	
	private JLabel lbIme;
	private  JTextField tfIme;
	private JButton btnOK;
	private JButton btnCancel;
	int n;
	public static boolean OK;
	public static Point2D tacka;
	ArrayList<JTextField> tfAtribut;

	public UnosEntiteta() {
		
		setTitle("Unos podataka o entitetu");
		setSize(((MainFrame.getInstance().getSize()).width/3),(MainFrame.getInstance().getSize()).height-100);
		setLocationRelativeTo(MainFrame.getInstance());
		setModal(true);
		OK=false;
	
	
		lbIme = new JLabel("Naziv entiteta: ");
		tfIme = new JTextField(15);
		tfIme.setText("entity_"+ AddElementState.j);
		AddElementState.j++;
		
		JPanel pNewName= new JPanel(new FlowLayout(FlowLayout.LEFT));
		pNewName.add(lbIme);
		pNewName.add(tfIme);
		pNewName.add(new JLabel());
		pNewName.add(new JLabel());
		
		tfAtribut= new ArrayList<JTextField>();
		JLabel lbAtribut[]= new JLabel[10];  
		JPanel pAtributi= new JPanel(new FlowLayout(FlowLayout.LEFT));
		Box boxAtributi = new Box(BoxLayout.Y_AXIS);
		int j;
		n=10;
		for(int i=0;i<10;i++)
		{
			JPanel pAtribut= new JPanel(new FlowLayout(FlowLayout.LEFT));
			j=i+1;
			lbAtribut[i]= new JLabel("Atribut "+ j +": ");
            tfAtribut.add(new JTextField(15));
            pAtribut.add(lbAtribut[i]);
            pAtribut.add(tfAtribut.get(i));
            boxAtributi.add(pAtribut);
		}
		pAtributi.add(boxAtributi);
		
		JPanel general= new JPanel(new FlowLayout(FlowLayout.LEFT));
		general.add(pNewName);
		general.add(pAtributi);
		JPanel buttons= new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOK= new JButton("OK");
		btnOK.setPreferredSize(new Dimension(80, 30));
		btnOK.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				AddElementState.newElem = new Entity(tacka,new Dimension(100, 60));
				AddElementState.newElem.setName(tfIme.getText());			
				Entity rr= (Entity)AddElementState.newElem;

				for(int i=0;i<UnosEntiteta.this.n;i++)
				{
					String text= tfAtribut.get(i).getText();
					if(!text.equals(""))
					{
					int j=i+1;
					GraphElement newElem=new Atribute(new Point2D.Double(rr.getPosition().getX()+j*100,rr.getPosition().getY()+100),new Dimension(85, 35));
					  newElem.setName(tfAtribut.get(i).getText());
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
							   new Point2D.Double(tacka.getX()+j*100,tacka.getY()+100), 
							   Color.WHITE, 
							   new Point2D.Double(tacka.getX()+j*100+10,tacka.getY()+100)
							   , Color.WHITE, true));
					  newElem.setShading(false);
					  newElem.setFill(false);
					  newElem.setLineStyleName("puna");
					  ElementPainter newPainter = new AtributePainter(newElem);
					  GGEView view= MainFrame.getInstance().getCurrentView();
					  view.getCommandManager().executeCommand(new AddElementCommand(view.getGGEModel(),view, newElem, newPainter));
		   			  GeneralPath linija=new GeneralPath();	
		   			  rr.dodajAtribut(linija,newElem,newPainter);
					}
				}
				OK=true;
				UnosEntiteta.this.dispose();
				UnosEntiteta.this.setVisible(false);	
			}		

		});
		btnCancel= new JButton("Cancel");
		btnCancel.setPreferredSize(new Dimension(80, 30));
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				OK=false;
				UnosEntiteta.this.dispose();
				UnosEntiteta.this.setVisible(false);				
			}
		});
	
		buttons.add(btnOK);
		buttons.add(btnCancel);
		


		add(general);
		add(buttons,BorderLayout.SOUTH);
	}
	
	
	
	
	

}
