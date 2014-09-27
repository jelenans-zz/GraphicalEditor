/***********************************************************************
 * Module:  GGETableView.java
 * Author:  Sladza
 * Purpose: Defines the Class GGETableView
 ***********************************************************************/

package gge.view;

import gge.model.*;

import java.awt.geom.Point2D;
import java.util.*;

import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;



@SuppressWarnings("serial")
public class GGETableView extends JTable implements Observer {
	 
		public GGEModel gGEModel;
		public static int BROJ_KOLONA = 5;
	    private GGETableModel tableModel;
		protected String[] columnNames = new String[BROJ_KOLONA];
		protected Object[][] tableData;// koristi se za cuvanje podataka
	   
	 
		public GGETableView(GGEModel model) {
	      // TODO: implement
		   super();
		  this.gGEModel = model;
		   columnNames[0] = "Number";
		   columnNames[1] = "Name";
		   columnNames[2] = "Type";
		   columnNames[3] = "Position";
		   columnNames[4] = "Size";
		   tableModel = new GGETableModel(columnNames);
		   
		   setModel(tableModel);
		   model.addObserver(this);
		         
	   }
	   

	/** @param row 
	    * @param column */
	   public boolean isCellEditable(int row, int column) {
	      // TODO: implement
	      return false;
	   }
	   
	   
	   /** @pdGenerated default parent getter */
	   public GGEModel getGGEModel() {
	      return gGEModel;
	   }
	   
	   /** @pdGenerated default parent setter
	     * @param newGGEModel */
	   public void setGGEModel(GGEModel newGGEModel) {
	      this.gGEModel = newGGEModel;
	   }
	  
	  

	class GGETableModel extends AbstractTableModel {
		  private String[] columnNames;

		  public GGETableModel(String[] columnNames) {
			  super();
			  this.columnNames = columnNames;
				
		  }
		 
		 
		  
	      public int getColumnCount() {
	         // TODO: implement
	         return columnNames.length;
	      }
	      public int getRowCount() {
	         // TODO: implement
	         return gGEModel.getElements().size();
	      }
	      
	      /** @param column */
	      public String getColumnName(int column) {
	         // TODO: implement
	    	  return columnNames[column];
	      }
	      
	      /** @param getColumnIndex 
	       * @param getRowIndex */
	      public Object getValueAt(int getRowIndex, int getColumnIndex) {
	         // TODO: implement
	    	  Element elem = gGEModel.getElement(getRowIndex);
	    	  if(elem instanceof GraphElement){
	    	  int rbr = getRowIndex+1;
				String pozicija = "X:"+(int)((GraphElement) elem).getPosition().getX()+ " Y:" +(int)((GraphElement) elem).getPosition().getY();
				String velicina ="H:"+ (int)((GraphElement) elem).getSize().getWidth()+ " W:" +(int)((GraphElement) elem).getSize().getHeight();
				String naziv = elem.getName();
				String tip = ((GraphElement) elem).getType();
				
				switch(getColumnIndex) {
				
				case 0:	return rbr;

				case 1:	return naziv;
				
				case 2:	return tip;
				
				case 3: return pozicija;
				
				case 4: return velicina;
				
				default : return "";
				}
				}else if(elem instanceof Link){
					int rbr = getRowIndex+1;
					String naziv=elem.getName();
					String tip=((Link) elem).getType();
					switch(getColumnIndex){
						case 0: return rbr;
						case 1: return naziv;
						case 2: return tip;
						case 3: return "";
						case 4: return "";
					
					
					}
				}
	    	  return "";
	      }
	   
	   }



	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		resizeAndRepaint();
	}

}