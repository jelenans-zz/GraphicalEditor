package gui;

import gge.model.GGEModel;
import gge.model.GraphElement;
import gge.model.Project;
import gge.model.Workspace;
import gge.view.GGEView;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RenameFileDialog extends JDialog {
	
	private JLabel lbNovoIme;
	private  JTextField tfNovoIme;
	private JButton btnOK;
	private JButton btnCancel;
	private Object selektovana;


	public RenameFileDialog(final Object selected) {
		
		
		setTitle("Rename Dialog");
		setSize(((MainFrame.getInstance().getSize()).width/3),(MainFrame.getInstance().getSize()).height/3);
		setLocationRelativeTo(MainFrame.getInstance());
		setModal(true);

		
		lbNovoIme = new JLabel("New name: ");
		tfNovoIme = new JTextField(15);
		
		if (selected instanceof Workspace)
		{
			 tfNovoIme.setText(((Workspace) selected).getName());
		}

		else if (selected instanceof Project)
		{
			tfNovoIme.setText(((Project) selected).getName());
		}

		else if (selected instanceof GGEModel)
		{
			tfNovoIme.setText(((GGEModel) selected).getName());
		}
		else if (selected instanceof GraphElement)
		{
			tfNovoIme.setText(((GraphElement) selected).getName());
		}

		
		JPanel buttons= new JPanel(new FlowLayout(FlowLayout.CENTER));
		btnOK= new JButton("OK");
		btnOK.setPreferredSize(new Dimension(80, 30));
		
		btnOK.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				 String novoIme= tfNovoIme.getText();
//				 if(selected instanceof Workspace)
//					((Workspace) selektovana).setName(novoIme);
//				 if(selektovana instanceof Project)
//					 ((Project) selektovana).setName(novoIme);
//				 if(selektovana instanceof GGEModel)
//					 ((GGEModel) selektovana).setName(novoIme);
//				 if(selektovana instanceof GraphElement)
//					 ((GraphElement) selektovana).setName(novoIme);
					
					if (selected instanceof Workspace)
					{
						  ((Workspace) selected).setName(novoIme);
					}

					else if (selected instanceof Project)
					{
						  ((Project) selected).setName(novoIme);
					}

					else if (selected instanceof GGEModel)
					{
						String staroIme=((GGEModel) selected).getName();
						 ((GGEModel) selected).setName(novoIme);
						 ArrayList<GGEView> views= MainFrame.getInstance().getViews();
						Component[] openedDiagrams= MainFrame.getInstance().getTabbedPane().getComponents();
						 for(GGEView view: views)
							{
								GGEModel model= view.getGGEModel();
								if (model.equals((GGEModel) selected))
								{
									for(Component opened: openedDiagrams)
									{
										if(opened.equals(view))
										{
											int index=MainFrame.getInstance().getTabbedPane().indexOfTab(staroIme);
											MainFrame.getInstance().getTabbedPane().remove(view);
											MainFrame.getInstance().getTabbedPane().insertTab(novoIme, null,view, null, index);
											MainFrame.getInstance().getTabbedPane().setSelectedComponent(view);
											break;

										}
									}
									
								}
							}

					}
					else if (selected instanceof GraphElement)
					{
						  ((GraphElement) selected).setName(novoIme);
					}
					 
					RenameFileDialog.this.dispose();
					RenameFileDialog.this.setVisible(false);
				
			}
		});

		btnCancel= new JButton("Cancel");
		btnCancel.setPreferredSize(new Dimension(80, 30));
		btnCancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				RenameFileDialog.this.dispose();
				RenameFileDialog.this.setVisible(false);
				
			}
		});
		
		
		buttons.add(btnOK);
		buttons.add(btnCancel);
		
		JPanel pNewName= new JPanel(new FlowLayout(FlowLayout.LEFT));
		pNewName.add(lbNovoIme);
		pNewName.add(tfNovoIme);
		add(pNewName);
		add(buttons,BorderLayout.SOUTH);
	}
	
	
	

}
