package gui;


import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelListener;

import javax.swing.AbstractAction;
import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import menu.actions.CopyAction;
import menu.actions.CutAction;
import menu.actions.PasteAction;
import menu.actions.PropertiesAction;

import actions.DeleteElementAction;
import actions.RedoAction;
import actions.UndoAction;

@SuppressWarnings("serial")
public class PopUp extends JPopupMenu{
	
	
	PropertiesAction properties;
	UndoAction undo;
	RedoAction redo;
	DeleteElementAction delete; 
	CutAction cut;
	CopyAction copy;
	PasteAction paste;

	
		public PopUp(){
		super();
		copy = new CopyAction();
		cut = new CutAction();
		paste = new PasteAction();
		delete = new DeleteElementAction();
		undo = new UndoAction();
		redo = new RedoAction();
		properties = new PropertiesAction();
		
		this.add(copy);
		this.add(cut);
		this.add(paste);
		addSeparator();
		this.add(delete);
		addSeparator();
		this.add(undo);
		this.add(redo);
		addSeparator();
		this.add(properties);
		}

		public void PopUpMeniVanElementa(){
		delete.setEnabled(false);
		copy.setEnabled(false);
		cut.setEnabled(false);
		properties.setEnabled(false);
		}
}

