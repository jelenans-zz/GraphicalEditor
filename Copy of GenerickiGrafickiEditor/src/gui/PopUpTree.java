package gui;

import javax.swing.JPopupMenu;

import menu.actions.CopyAction;
import menu.actions.CutAction;
import menu.actions.PasteAction;
import menu.actions.PropertiesAction;
import actions.DeleteElementAction;
import actions.RedoAction;
import actions.UndoAction;

public class PopUpTree extends JPopupMenu {
	PropertiesAction properties;
	UndoAction undo;
	RedoAction redo;
	DeleteElementAction delete; 
	CutAction cut;
	CopyAction copy;
	PasteAction paste;

	
		public PopUpTree(){
		super();
		copy = new CopyAction();
		cut = new CutAction();
		paste = new PasteAction();
		delete = new DeleteElementAction();
		undo = new UndoAction();
		redo = new RedoAction();
		//properties = new PropertiesAction();
		
		this.add(copy);
		this.add(cut);
		this.add(paste);
		addSeparator();
		this.add(delete);
		addSeparator();
		this.add(undo);
		this.add(redo);
		addSeparator();
		//this.add(properties);
		}

		public void PopUpTreeVanElementa(){
		delete.setEnabled(false);
		copy.setEnabled(false);
		cut.setEnabled(false);
		//properties.setEnabled(false);
		}

}
