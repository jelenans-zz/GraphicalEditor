/***********************************************************************
 * Module:  ZoomOutCommand.java
 * Author:  Sladza
 * Purpose: Defines the Class ZoomOutCommand
 ***********************************************************************/

package gge.command;

import gge.model.*;
import java.util.*;

public class ZoomOutCommand extends Command {
   protected GGEModel model;
   
   
   
   public GGEModel getModel() {
      return model;
   }
   
  
   public void setModel(GGEModel newGGEModel) {
      this.model = newGGEModel;
   }
   
   public void execute() {
      // TODO: implement
   }
   
   public void undo() {
      // TODO: implement
   }

}