package gge.gui.workspace;

import gge.model.*;

import javax.swing.event.*;
import javax.swing.tree.*;

public class WorkspaceModel implements TreeModel {

	Workspace root;

	public WorkspaceModel(Workspace root) {
		this.root = root;
	}
	
	@Override
	public Object getChild(Object parent, int index) {
		if(parent instanceof Element) {
			return null;
		} else if(parent instanceof GGEModel) {
			return ((GGEModel)parent).getElement(index);
		} else if(parent instanceof Project) {
			return ((Project)parent).getDiagram(index);
		} else if(parent instanceof Workspace) {
			return ((Workspace)parent).getProject(index);
		}
		return root; 
	}

	@Override
	public int getChildCount(Object parent) {
		if(parent instanceof Element) {
			return 0;
		} else if(parent instanceof GGEModel) {
			return ((GGEModel)parent).getElementCount();
		} else if(parent instanceof Project) {
			return ((Project)parent).getDiagramCount();
		} else if(parent instanceof Workspace) {
			return ((Workspace)parent).getProjectCount();
		}
		return 0;
	}

	@Override
	public boolean isLeaf(Object node) {
		return (node instanceof Element);
	}

	@Override
	public void valueForPathChanged(TreePath path, Object newValue) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getIndexOfChild(Object parent, Object child) {
		if(parent instanceof GraphElement) {
			return -1;
		} else if(parent instanceof GGEModel && child instanceof Element) {
			return ((GGEModel)parent).getElementIndex((Element) child);
		} else if(parent instanceof Project && child instanceof GGEModel) {
			return ((Project)parent).getDiagramIndex((GGEModel)child);
		} else if(parent instanceof Workspace && child instanceof Project) {
			return ((Workspace)parent).getProjectIndex((Project)child);
		}
		return -1;
	}

	@Override
	public Object getRoot() {
		return root;
	}

	@Override
	public void addTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeTreeModelListener(TreeModelListener l) {
		// TODO Auto-generated method stub
		
	}
}
