/***********************************************************************
 * Module:  SelectionModel.java
 * Author:  Sladza
 * Purpose: Defines the Class SelectionModel
 ***********************************************************************/

package gge.view;

import gge.model.*;

import java.util.*;

public class SelectionModel {
   protected List<Element> elements = new ArrayList<Element>();
  // protected List<Link> selektovaneVeze = new ArrayList<Link>();
   
   
   public List<Element> getElements() {
      if (elements == null)
         elements = new ArrayList<Element>();
      return elements;
   }
//   public List<Link> getSelectedLinks() {
//	      if (selektovaneVeze == null)
//	         selektovaneVeze = new ArrayList<Link>();
//	      return selektovaneVeze;
//	   }
 //  public Iterator<Element> getIteratorSelectedElements() {
//		if (elements == null)
//			elements = new ArrayList<Element>();
//		return elements.iterator();
//	}
 // 
   public Iterator<Element> getIteratorElements() {
      if (elements == null)
         elements = new ArrayList<Element>();
      return elements.iterator();
   }
   
  
   public void addElements(Element newGraphElement) {
	   if (newGraphElement == null)
	         return;
	      if (elements == null)
	         elements = new ArrayList<Element>();
	      elements.add(newGraphElement);
   }
   
 //  public void addLink(Link newLink) {
//	   if (newLink == null)
//	         return;
//	      if (selektovaneVeze == null)
	//         selektovaneVeze = new ArrayList<Link>();
//	      selektovaneVeze.add(newLink);
  // }
  
   public void removeElements(Element oldGraphElement) {
      if (oldGraphElement == null)
         return;
      if (this.elements != null)
         if (this.elements.contains(oldGraphElement))
            this.elements.remove(oldGraphElement);
   }
   
   //public void removeSelektovaneVeze(Link oldLink) {
	//      if (oldLink == null)
	//         return;
	//      if (this.selektovaneVeze != null)
	//         if (this.selektovaneVeze.contains(oldLink))
	//            this.selektovaneVeze.remove(oldLink);
	//   }
   
   public void removeAllElements() {
      if (elements != null)
         elements.clear();
    //  if (selektovaneVeze!=null)
    //	  selektovaneVeze.clear();
   }
   
   /**
	 * Metoda proverava da li je selektovan tacno jedan element
	 * i, ako jeste, vraca ga.
	 */
	public Element getSingleSelectedElement() {
		
		//if(selektovaneVeze.size()==1)
		//	return selektovaneVeze.get(0);
		if(elements.size() == 1)
			return elements.get(0);
		return null;
	}
	public boolean isEmpty() {
		return elements.isEmpty() ;
	}
	
}