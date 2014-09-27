package gge.model;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class ISAhierarchy extends GraphElement {

	@Override
	protected void finalize() {
		// TODO Auto-generated method stub
		super.finalize();
	}

	public ISAhierarchy(Point2D newPosition, Dimension2D newSize) {
		super(newPosition, newSize);
		name = "ISA";
		type = "ISA";
	}
	public String getName(){
		return name;
	}

	 @Override
		public ISAhierarchy createCopy() {
			Point2D positionCopy = new Point2D.Double(position.getX(), position.getY());
			Dimension sizeCopy = new Dimension((int)size.getWidth(), (int)size.getHeight());
			ISAhierarchy ISAHierarchyCopy = new ISAhierarchy(positionCopy, sizeCopy);
			ISAHierarchyCopy.setName(name);
			ISAHierarchyCopy.setType(type);
			ISAHierarchyCopy.setDescription(description);
			ISAHierarchyCopy.setColor(color);
			ISAHierarchyCopy.setBorderColor(borderColor);
			ISAHierarchyCopy.setLineStyle(lineStyle);
			ISAHierarchyCopy.setLineStyleName(lineStyleName);
			ISAHierarchyCopy.setFontName(fontName);
			ISAHierarchyCopy.setFontStyle(fontStyle);
			ISAHierarchyCopy.setFontSize(fontSize);
			ISAHierarchyCopy.setFontColor(fontColor);
			ISAHierarchyCopy.setUnderline(underline);
			ISAHierarchyCopy.setShadowStyle(shadowStyle);
			ISAHierarchyCopy.setShading(shading);
			ISAHierarchyCopy.setShadow(shadow);
			ISAHierarchyCopy.setResize(resize);
			ISAHierarchyCopy.setFill(fill);
			ISAHierarchyCopy.setConnectionPoints(connectionPoints);
			return ISAHierarchyCopy;
		}
	 
}
