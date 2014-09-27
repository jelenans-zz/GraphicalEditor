/***********************************************************************
 * Module:  Project.java
 * Author:  Sladza
 * Purpose: Defines the Class Project
 ***********************************************************************/

package gge.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

public class Project extends Observable{
	
 
   public ArrayList<GGEModel> gGEModel;
   private String name;  
   
 public Project() {
		super();
		gGEModel = new ArrayList<GGEModel>();
	}

public Project(String name) {
		gGEModel = new ArrayList<GGEModel>();
		this.name = name;
	}

public String getName() {
	return name;
}

 public void setName(String name) {
	this.name = name;
}



/** @pdGenerated default getter */
public ArrayList<GGEModel>  getGGEModel() {  // Maja: ne treba praviti getere i setere za celu listu.
if (gGEModel == null)
   gGEModel = new ArrayList<GGEModel>();
return gGEModel;
}

   public void save() {
      // TODO: implement
   }
   
   public void open() {
      // TODO: implement
   }
   
   public void close() {
      // TODO: implement
   }
   
   public void changeStatus() {
      // TODO: implement
   }
   
   protected void finalize() {
	      // TODO: implement
	   }

   
	public GGEModel getDiagram(int index) {
		return gGEModel.get(index);
	}
   
   /** @pdGenerated default iterator getter */
   public Iterator<GGEModel> getIteratorGGEModel() {
      if (gGEModel == null)
         gGEModel =new ArrayList<GGEModel>();
      return gGEModel.iterator();
   }
   

   
   /** @pdGenerated default add
     * @param newGGEModel */
   public void addGGEModel(GGEModel newGGEModel) {
      if (newGGEModel == null)
         return;
      if (this.gGEModel == null)
         this.gGEModel = new ArrayList<GGEModel>();
      if (!this.gGEModel.contains(newGGEModel))
      {
         this.gGEModel.add(newGGEModel);
         setChanged();		
 		 notifyObservers(); 
      }
   }
   


/** @pdGenerated default remove
     * @param oldGGEModel */
   public void removeGGEModel(GGEModel oldGGEModel) {
      if (oldGGEModel == null)
         return;
      if (this.gGEModel != null)
         if (this.gGEModel.contains(oldGGEModel))
         {
            this.gGEModel.remove(oldGGEModel);
            setChanged();		
    		notifyObservers(); 
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllGGEModel() {
      if (gGEModel != null)
         gGEModel.clear();
   }

public int getDiagramCount() {

 int brDij= gGEModel.size();
 
	return brDij;
}

public int getDiagramIndex(GGEModel child) {
	if (gGEModel.contains(child))
		return gGEModel.indexOf(child);
	return -1;
}

public String toString() {
	return name;
}

}