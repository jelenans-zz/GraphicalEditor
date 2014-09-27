/***********************************************************************
 * Module:  Workspace.java
 * Author:  Sladza
 * Purpose: Defines the Class Workspace
 ***********************************************************************/

package gge.model;

import java.util.*;

public class Workspace extends Observable{
	
   private ArrayList<Project> projects;
   private String name;
   
   
   public Workspace() {
	   projects = new ArrayList<Project>();
      // TODO: implement
   }
   
   public Workspace(String name) {
	   projects = new ArrayList<Project>();
	   this.name=name;
	   }
   
   
   
   
   public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

protected void finalize() {
      // TODO: implement
   }
   
   
   /** @param file */
   public void open(String file) {
      // TODO: implement
   }
   
   public void close() {
      // TODO: implement
   }
   
   public void save() {
      // TODO: implement
   }
   
 
  
   public ArrayList<Project> getProjects() {
      if (projects == null)
         projects = new ArrayList<Project>();
      return projects;
   }
   
   
   public java.util.Iterator getIteratorProject() {
      if (projects == null)
         projects = new ArrayList<Project>();
      return projects.iterator();
   }
   
   
   public void setProjects(ArrayList<GGEModel> newProject) {
      removeAllProject();
      for (java.util.Iterator iter = newProject.iterator(); iter.hasNext();)
         addProject((Project)iter.next());
   }
   
 
   public void addProject(Project newProject) {
      if (newProject == null)
         return;
      if (this.projects == null)
         this.projects = new ArrayList<Project>();
      if (!this.projects.contains(newProject))
      {
         this.projects.add(newProject);
         setChanged();		
 		 notifyObservers(); 
      }
   }
   
   
   public void removeProject(Project oldProject) {
      if (oldProject == null)
         return;
      if (this.projects != null)
         if (this.projects.contains(oldProject))
         {
            this.projects.remove(oldProject);
            setChanged();		
    		 notifyObservers(); 
         }
   }
   
   
   public void removeAllProject() {
      if (projects != null)
         projects.clear();
   }


public Project getProject(int index) {
	Project rez= projects.get(index);
	return rez;
}


public int getProjectCount() {

	int brProj= projects.size();
	
	return brProj;
}


public int getProjectIndex(Project child) {
	if (projects.contains(child))
		return projects.indexOf(child);
	return -1;
}

public String toString(){
	return name;
}


}