/***********************************************************************
 * Module:  Grid.java
 * Author:  Sladza
 * Purpose: Defines the Class Grid
 ***********************************************************************/

package gge.view;

import java.awt.BasicStroke;
import java.awt.Color;


public class Grid {
   private boolean visible;
   private int width;
   private int height;
   private BasicStroke lineStyle;
   private Color color;
   
   public boolean getVisible() {
      return visible;
   }
   
  
   public void setVisible(boolean newVisible) {
      visible = newVisible;
   }
   
   public int getWidth() {
      return width;
   }
   
   
   public void setWidth(int newWidth) {
      width = newWidth;
   }
   
   public int getHeight() {
      return height;
   }
   
   
   public void setHeight(int newHeight) {
      height = newHeight;
   }
   
   public BasicStroke getLineStyle() {
      return lineStyle;
   }
   
  
   public void setLineStyle(BasicStroke newLineStyle) {
      lineStyle = newLineStyle;
   }
   
   public Color getColor() {
      return color;
   }
   
  
   public void setColor(Color newColor) {
      color = newColor;
   }

}