/***********************************************************************
 * Module:  CommandManager.java
 * Author:  Sladza
 * Purpose: Defines the Class CommandManager
 ***********************************************************************/

package gge.command;

import gge.model.*;
import java.util.*;

public class CommandManager {
	
   private int currentCommandIndex = -1;
   protected List<Command> commands = new ArrayList<Command>();; //pamtimo komande koje su redom izvrsene
   protected GGEModel gGEModel;
   
   public CommandManager(GGEModel model){
	   this.gGEModel = model;
   }
   

  
   public void executeCommand(Command command) {
      for (int i = commands.size() - 1; i > currentCommandIndex; i--)
                  commands.remove(i);  // praznimo redo listu
              commands.add(command);
              command.execute();
              currentCommandIndex++;
   
   }
   
   public void undo() {
      if (currentCommandIndex > -1) {
               Command currentCommandToUndo = commands.get(currentCommandIndex);
               currentCommandToUndo.undo();
               currentCommandIndex--;
           }
   
   }
   public void redo() {
       if (currentCommandIndex < commands.size() - 1) {
           Command currentCommandToRedo = commands.get(currentCommandIndex + 1);
           currentCommandToRedo.execute();
           currentCommandIndex++;
       }
   }

}