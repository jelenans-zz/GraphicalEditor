/***********************************************************************
 * Module:  Clipboard.java
 * Author:  Sladza
 * Purpose: Defines the Class Clipboard
 ***********************************************************************/

package gge.model;

import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreePath;


public class Clipboard {	

	private static Clipboard clipboard;

	private ArrayList<Element> elements;
	
	private ArrayList<GGEModel> diagrams;

	
	private Clipboard() {
		elements = new ArrayList<Element>();
		diagrams=new ArrayList<GGEModel>();
	}

	public static Clipboard getInstance() {
		if (clipboard == null) {
			clipboard = new Clipboard();
		}
		return clipboard;
	}
	
	public boolean isEmpty() {
		return elements.isEmpty();
	}

	/**
	 * Metoda koja kopira prosledjene elemente u listu elemenata na clipboard-u.
	 */
	public void putElements(List<Element> list) {
		elements.clear();
		
		if (list != null) {
			for (Element elem : list) {
				if(elem instanceof GraphElement)
					elem= (GraphElement)elem;
				else
					elem= (Link)elem;
				
				elements.add(elem.createCopy());
			}
		}

	}
	
	public void putElements(TreePath[] selectionPaths)
	{ 
		
		elements.clear();
		
		if (selectionPaths != null) 
		{
			System.out.println("n: "+selectionPaths.length);
			for(int i=0;i< selectionPaths.length;i++)
			{
				
					if(selectionPaths[i].getLastPathComponent() instanceof GraphElement)
						elements.add(((GraphElement)selectionPaths[i].getLastPathComponent()).createCopy());
					else if(selectionPaths[i].getLastPathComponent() instanceof Link)
						elements.add(((Link)selectionPaths[i].getLastPathComponent()).createCopy());
				
			}
		}
		
	}
	/**
	 * Metoda koja vraca listu kopija objekata koji su u clipboardu.
	 */
	public List<Element> getElements() {

		List<Element> elementsCopy = new ArrayList<Element>();

		for (Element elem : elements) {
			elementsCopy.add(elem.createCopy());
		}
		
		return elementsCopy;
	}
	
	public void putDiagrams(TreePath[] selectionPaths) { 
		
				diagrams.clear();
				
				if (selectionPaths != null) {
					for(int i=0;i< selectionPaths.length;i++)
					{
						if(selectionPaths[i].getLastPathComponent() instanceof GGEModel)
						{
							GGEModel diagram= (GGEModel)selectionPaths[i].getLastPathComponent();
							diagrams.add(diagram.createCopy());
						}
					}
				}
				
		}


	
	public List<GGEModel> getDiagrams() {

		List<GGEModel> diagramsCopy = new ArrayList<GGEModel>();

		for (GGEModel diagram : diagrams) {
			diagramsCopy.add(diagram.createCopy());
		}
		
		return diagramsCopy;
	}

	
}