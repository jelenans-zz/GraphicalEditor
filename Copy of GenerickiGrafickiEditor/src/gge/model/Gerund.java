package gge.model;

import java.awt.Dimension;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class Gerund extends GraphElement {

	@Override
	protected void finalize() {
		// TODO Auto-generated method stub
		super.finalize();
	}

	public Gerund(Point2D newPosition, Dimension2D newSize) {
		super(newPosition, newSize);
		name = "gerund";
		type = "gerund";
	}

	 @Override
		public Gerund createCopy() {
			Point2D positionCopy = new Point2D.Double(position.getX(), position.getY());
			Dimension sizeCopy = new Dimension((int)size.getWidth(), (int)size.getHeight());
			Gerund gerundCopy = new Gerund(positionCopy, sizeCopy);
			gerundCopy.setName(name);
			gerundCopy.setType(type);
			gerundCopy.setDescription(description);
			gerundCopy.setColor(color);
			gerundCopy.setBorderColor(borderColor);
			gerundCopy.setLineStyle(lineStyle);
			gerundCopy.setLineStyleName(lineStyleName);
			gerundCopy.setFontName(fontName);
			gerundCopy.setFontStyle(fontStyle);
			gerundCopy.setFontSize(fontSize);
			gerundCopy.setFontColor(fontColor);
			gerundCopy.setUnderline(underline);
			gerundCopy.setShadowStyle(shadowStyle);
			gerundCopy.setShading(shading);
			gerundCopy.setShadow(shadow);
			gerundCopy.setResize(resize);
			gerundCopy.setFill(fill);
			return gerundCopy;
		}

}
