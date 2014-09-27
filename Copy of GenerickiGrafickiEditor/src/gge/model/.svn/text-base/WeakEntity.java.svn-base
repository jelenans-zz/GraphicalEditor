package gge.model;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;

public class WeakEntity extends GraphElement {
	
	ArrayList<Atribute>  key;

	@Override
	protected void finalize() {
		// TODO Auto-generated method stub
		super.finalize();
	}

	public WeakEntity(Point2D newPosition, Dimension2D newSize) {
		super(newPosition, newSize);
		name="weakEntity";
		type="weakEntity";
		key= new ArrayList<Atribute>();
	}
	
	
	
	 public ArrayList<Atribute> getKey() {
		return key;
	}

	public void setKey(ArrayList<Atribute> key) {
		this.key = key;
	}

	@Override
		public WeakEntity createCopy() {
			Point2D positionCopy = new Point2D.Double(position.getX(), position.getY());
			Dimension sizeCopy = new Dimension((int)size.getWidth(), (int)size.getHeight());
			WeakEntity weakEntityCopy = new WeakEntity(positionCopy, sizeCopy);
			weakEntityCopy.setName(name);
			weakEntityCopy.setType(type);
			weakEntityCopy.setDescription(description);
			weakEntityCopy.setColor(color);
			weakEntityCopy.setBorderColor(borderColor);
			weakEntityCopy.setLineStyle(lineStyle);
			weakEntityCopy.setLineStyleName(lineStyleName);
			weakEntityCopy.setFontName(fontName);
			weakEntityCopy.setFontStyle(fontStyle);
			weakEntityCopy.setFontSize(fontSize);
			weakEntityCopy.setFontColor(fontColor);
			weakEntityCopy.setUnderline(underline);
			weakEntityCopy.setShadowStyle(shadowStyle);
			weakEntityCopy.setShading(shading);
			weakEntityCopy.setShadow(shadow);
			weakEntityCopy.setResize(resize);
			weakEntityCopy.setFill(fill);
	  		weakEntityCopy.setAtributi(atributi);
	  		weakEntityCopy.setKey(key);
	  		weakEntityCopy.setConnectionPoints(connectionPoints);
			return weakEntityCopy;
		}


}
