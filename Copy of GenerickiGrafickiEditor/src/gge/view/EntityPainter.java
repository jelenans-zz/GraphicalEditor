

package gge.view;

import gge.model.Atribute;
import gge.model.Element;
import gge.model.Entity;
import gge.model.GraphElement;

import java.awt.geom.GeneralPath;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;


public class EntityPainter extends ElementPainter {
	int kk=1;
   protected void finalize() {
      // TODO: implement
   }
   
   public EntityPainter(GraphElement elem) {
		super(elem);
		 shape = new Rectangle2D.Double 
				(0, 0,
				elem.getSize().getWidth(), elem.getSize().getHeight());
//		 Entity entitet= (Entity)elem;
//		 ArrayList<GeneralPath> linije= entitet.getLinije();
//		 ArrayList<Atribute> atributi= entitet.getAtributi();
//		 kk++;
		 
//		 for(int i=0;i<linije.size();i++)
//		 {
//			linije.get(i).moveTo(entitet.getPosition().getX()+entitet.getSize().getWidth(),
//					entitet.getPosition().getY()+entitet.getSize().getHeight());
//			linije.get(i).lineTo(atributi.get(i).getPosition().getX()+ atributi.get(i).getSize().getWidth()/2,
//					atributi.get(i).getPosition().getY());
//		 }


	}

}