package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

@SuppressWarnings("serial")
public class StatusBar extends JPanel {

	private StatusPane status1;
	private StatusPane status2;
	private StatusPane status3;
	private StatusPane status4;
	
	public StatusBar() {
		setLayout(new GridLayout(1, 5, 5, 5));
		setBackground(Color.lightGray);
		setBorder(BorderFactory.createLineBorder(Color.GRAY));
			
		
		status1 = new StatusPane("");
		status2 = new StatusPane("Defaut state");
		status3 = new StatusPane("( 0 , 0 )");
		status4 = new StatusPane("Java 1.x");
		
		add(status1);
		add(status2);
		add(status3);
		add(status4);
		
		
		
	}
	
	public void setStatus3(int x,int y) {
		this.status3 .setText("("+x+","+y+")");
	}

	public void setStatus1(String status1) {
		
		this.status1.setText(status1);
	}

	public void setStatus2(String status2) {
		
		this.status2.setText(status2);
	}

	

}

@SuppressWarnings("serial")
class StatusPane extends JLabel {

	public StatusPane(String text) {
		super(text);
		setHorizontalAlignment(CENTER);
		setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		setPreferredSize(new Dimension(200, 25));
	}

}
