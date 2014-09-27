/***********************************************************************
 * Module:  State.java
 * Author:  Sladza
 * Purpose: Defines the Class State
 ***********************************************************************/

package gge.state;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;


public abstract class State {
	
	   public abstract void mouseClicked(MouseEvent e);
	 
	   public abstract void mouseEntered(MouseEvent e);
	  
	   public abstract void mouseReleased(MouseEvent e);
	  
	   public abstract void mouseExited(MouseEvent e);
	  
	   public abstract void mousePressed(MouseEvent e);
	  
	   public abstract void keyPressed(KeyEvent e);
	  
	   public abstract void keyReleased(KeyEvent e);
	  
	   public abstract void keyTyped(KeyEvent e);
	  
	   public abstract void mouseWheelMoved(MouseWheelEvent e);
	 
	   public abstract void mouseDragged(MouseEvent e);
	 
	   public abstract void mouseMoved(MouseEvent e);
	   
	   public abstract void paint(Graphics2D g2);
}